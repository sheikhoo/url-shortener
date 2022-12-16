package ir.sheikhoo.url_shortener;

import ir.sheikhoo.url_shortener.modules.link.model.Links;
import ir.sheikhoo.url_shortener.modules.link.service.LinkeService;
import ir.sheikhoo.url_shortener.modules.setting.service.SettingService;
import ir.sheikhoo.url_shortener.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DecimalFormat;

@Controller
public class MainController {

    private LinkeService linkeService;
    private UserService userService;
    private SettingService settingService;

    @Autowired
    public MainController(LinkeService linkeService, UserService userService, SettingService settingService) {
        this.linkeService = linkeService;
        this.userService = userService;
        this.settingService=settingService;
    }

    @RequestMapping(value = {"","/"})
    public String index(Model model,@ModelAttribute("shorten_link") Links link){

        String number[] = new String[4];

        int limit;
        try {
            limit = settingService.getSetting().getNumberLinks();
        }catch (Exception e){
            limit = 5;
        }

        number[0]=format(linkeService.numberLink());
        number[1]=format(userService.numberUser());
        number[2]=format(linkeService.numberClick());

        model.addAttribute("nlinks",linkeService.getLatestLinks(limit));
        model.addAttribute("plinks",linkeService.getPopularLinks(limit));
        model.addAttribute("setting",settingService.getSetting());
        model.addAttribute("number",number);

        model.addAttribute("shorten_link",link);

        return "index";
    }



    /******* Format Number ******/
    private static String[] suffix = new String[]{"","k", "m", "b", "t"};
    private static int MAX_LENGTH = 4;

    private static String format(double number) {
        String r = new DecimalFormat("##0E0").format(number);
        r = r.replaceAll("E[0-9]", suffix[Character.getNumericValue(r.charAt(r.length() - 1)) / 3]);
        while(r.length() > MAX_LENGTH || r.matches("[0-9]+\\.[a-z]")){
            r = r.substring(0, r.length()-2) + r.substring(r.length() - 1);
        }
        return r;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("setting",settingService.getSetting());
        return "login";
    }

    @RequestMapping(value = "/{short_url}",method = RequestMethod.GET)
    public RedirectView localRedirect(@PathVariable("short_url") String short_url) {

            System.out.println(short_url);

        RedirectView redirectView = new RedirectView();
        Links links=linkeService.getLink(short_url);
         if(links!=null) {
             links.setClick(links.getClick() + 1);

             linkeService.editeLink(links);

             redirectView.setUrl(links.getTarget_url());
             return redirectView;
         }else {
             /*if(short_url.equals("panel")||short_url.equals("login")) {
                 redirectView.setUrl("/"+short_url);
                 return redirectView;
             }
             else {*/
                System.out.println("!!!!!!!!!!!!!!!!");
                 redirectView.setUrl("/");
                 return redirectView;
             //}
         }

    }
}
