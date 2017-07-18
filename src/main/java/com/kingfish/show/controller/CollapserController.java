package com.kingfish.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingfish on 2017/7/19.
 */
@Controller
public class CollapserController {
    @RequestMapping("collapser.htm")
    public String index(Model mode) {
        return "collapser-example/index";
    }
}
