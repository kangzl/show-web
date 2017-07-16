package com.kingfish.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingfish on 2017/7/14.
 */
@Controller
public class MasonryController {

    @RequestMapping("masonry-api.htm")
    public String api(Model mode) {
        return "masonry-example/index-api";
    }

    @RequestMapping("masonry-example.htm")
    public String example(Model mode) {
        return "masonry-example/example";
    }

    @RequestMapping("masonry-index.htm")
    public String index(Model mode) {
        return "masonry-example/index";
    }

    @RequestMapping("masonry-index1.htm")
    public String index1(Model mode) {
        return "masonry-example/index1";
    }

    @RequestMapping("masonry-index2.htm")
    public String index2(Model mode) {
        return "masonry-example/index2";
    }

    @RequestMapping("masonry-index3.htm")
    public String index3(Model mode) {
        return "masonry-example/index3";
    }

    @RequestMapping("masonry-index4.htm")
    public String index4(Model mode) {
        return "masonry-example/index4";
    }

    @RequestMapping("masonry-index5.htm")
    public String index5(Model mode) {
        return "masonry-example/index5";
    }

    @RequestMapping("masonry-index6.htm")
    public String index6(Model mode) {
        return "masonry-example/index6";
    }

    @RequestMapping("masonry-index7.htm")
    public String index7(Model mode) {
        return "masonry-example/index7";
    }

    @RequestMapping("masonry-index8.htm")
    public String index8(Model mode) {
        return "masonry-example/index8";
    }

}
