package ir.sheikhoo.url_shortener.modules.link.controller;

import ir.sheikhoo.url_shortener.modules.link.model.Links;
import ir.sheikhoo.url_shortener.modules.link.service.LinkeService;
import ir.sheikhoo.url_shortener.modules.user.model.Users;
import ir.sheikhoo.url_shortener.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/link")
public class LinkController {

    private LinkeService linkeService;
    private UserService userService;

    @Autowired
    public LinkController(LinkeService linkeService, UserService userService) {
        this.linkeService = linkeService;
        this.userService = userService;
    }

    @RequestMapping(value = "/deletelink",method = RequestMethod.GET)
    public String deleteLink(@Param("id") int id){
        linkeService.deleteLink(id);
        return "redirect:/panel";
    }

    @RequestMapping(value = "/addmainlink",method = RequestMethod.POST)
    public String addMainLink(RedirectAttributes rattrs, @ModelAttribute Links links, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()) {
            rattrs.addAttribute("error","Url can not empity");
            return "redirect:/";
        }

        if(principal!=null)
            rattrs.addAttribute("shorten_link",linkeService.shortenUrl(links.getTarget_url(),userService.findUser(principal.getName())));
        else
            rattrs.addAttribute("shorten_link",linkeService.shortenUrl_(links.getTarget_url()));

        return "redirect:/";
    }

    @RequestMapping(value = "/addlink",method = RequestMethod.POST)
    public String addLink(RedirectAttributes rattrs, @ModelAttribute @Valid Links links, BindingResult bindingResult,Principal principal){
        if(bindingResult.hasErrors()) {
            rattrs.addAttribute("error","Url can not empity");
            return "redirect:/panel";
        }

        rattrs.addAttribute("shorten_link",linkeService.shortenUrl(links.getTarget_url(),userService.findUser(principal.getName())));
        return "redirect:/panel";
    }
}
