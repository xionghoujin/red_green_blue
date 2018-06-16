package com.bst.red_green_blue.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 熊厚谨 on 2018/6/16 11:12
 *
 * @author 熊厚谨
 */
@RequestMapping("/error")
@RestController
public class ErrorController {

    @RequestMapping("/myerror")
    public String Myerror(Model model){

        return "没有权限";
    }
}
