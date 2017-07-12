package com.kingfish.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingfish on 2017/7/12.
 */
@Controller
public class HomeController {

    @RequestMapping({"/", "/index.htm", "/index.html"})
    public String helloHtml(Model mode) {
        mode.addAttribute("hello","from TemplateController.helloHtml");
        return "index";
    }
}
