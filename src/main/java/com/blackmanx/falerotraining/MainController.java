package com.blackmanx.falerotraining;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackmanx.falerotraining.dto.UserDto;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact.html";
    }

    @RequestMapping("/services")
    public String services(){
        return "services.html";
    }

    @RequestMapping("/pricing")
    public String pricing(){
        return "pricing.html";
    }
    @RequestMapping("/register")
    public String register(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register.html";
    }
}
