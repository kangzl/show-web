package com.kingfish.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingfish on 2017/7/13.
 */
@Controller
public class WookmarkExampleController {

    @RequestMapping("example-endless-scroll.htm")
    public String test(Model mode) {
        return "wookmark-example/example-endless-scroll";
    }
}
