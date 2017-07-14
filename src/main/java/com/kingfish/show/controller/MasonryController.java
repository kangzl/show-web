package com.kingfish.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingfish on 2017/7/14.
 */
@Controller
public class MasonryController {

    @RequestMapping("masonry-example.htm")
    public String example(Model mode) {
        return "masonry-example/example";
    }

}
