package com.blackmanx.falerotraining;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/login")
    public String login(){
        return "login.html";
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
}
