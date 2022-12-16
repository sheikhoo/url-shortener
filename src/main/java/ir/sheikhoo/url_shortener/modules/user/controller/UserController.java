package ir.sheikhoo.url_shortener.modules.user.controller;

import ir.sheikhoo.url_shortener.modules.link.model.Links;
import ir.sheikhoo.url_shortener.modules.link.service.LinkeService;
import ir.sheikhoo.url_shortener.modules.setting.service.SettingService;
import ir.sheikhoo.url_shortener.modules.user.model.Users;
import ir.sheikhoo.url_shortener.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import java.security.Principal;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private SettingService settingService;
    private LinkeService linkeService;

    @Autowired
    public UserController(UserService userService, SettingService settingService, LinkeService linkeService) {
        this.userService = userService;
        this.settingService = settingService;
        this.linkeService = linkeService;
    }

    @RequestMapping(value = "/panel")
    public String panelIndex(Model model, Principal principal,@ModelAttribute("shorten_link") Links link){
        model.addAttribute("links",linkeService.getUserLink(principal.getName()));
        model.addAttribute("setting",settingService.getSetting());
        model.addAttribute("user",userService.findUser(principal.getName()));
        model.addAttribute("shorten_link",link);
        return "panel/index";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerUser(){
        return "panel/register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute Users users){
        userService.registerUser(users);
        return "redirect:/panel";
    }





 /*   @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Users> showAll(){
        return userService.findAll();
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void addUser(@ModelAttribute Users users){
        System.out.println("HI");
        System.out.println(users.getName());
        userService.registerUser(users);
    }*/


}
