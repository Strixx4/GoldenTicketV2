package com.study.gtnext.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping("")
    public String home() {
        return "redirect:index";
    }

    @GetMapping("index")
    public String index() {
        return "index.html";
    }

    @GetMapping("login")
    public String login() {
        return "login.html";
    }

    @GetMapping("carrello")
    public String carrello() {
        return "carrello.html";
    }

}
