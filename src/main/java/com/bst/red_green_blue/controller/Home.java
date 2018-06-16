package com.bst.red_green_blue.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Home {

    @RequestMapping(value = {"/","/index"})
    @PreAuthorize("hasRole('ADMIN')")
    public String index(Model model){

        model.addAttribute("key1","我的Java世界Security!!!");
        return "index";
    }

    @RequestMapping(value="/login" )
    public String login(){

        return"login";
    }

    @RequestMapping(value="/welcome")
    public String welcome(){

        return "welcome";
    }

    @RequestMapping(value = {"/news"})
    @PreAuthorize("hasRole('USER')")
    public String news(Model model){

        return "news";
    }



}
