package com.kingfish.show.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingfish on 2017/7/13.
 */
@Controller
public class WookmarkExampleController {

    @RequestMapping("example.htm")
    public String example(Model mode) {
        return "wookmark-example/example";
    }

    @RequestMapping("example-amd.htm")
    public String exampleAmd(Model mode) {
        return "wookmark-example/example-amd/index";
    }

    @RequestMapping("example-and-filter.htm")
    public String exampleAndFilter(Model mode) {
        return "wookmark-example/example-filter/and-filter";
    }

    @RequestMapping("example-fade.htm")
    public String exampleFade(Model mode) {
        return "wookmark-example/example-filter/fade";
    }

    @RequestMapping("example-index.htm")
    public String exampleIndex(Model mode) {
        return "wookmark-example/example-filter/index";
    }

    @RequestMapping("example-only-filter.htm")
    public String exampleOnlyFilter(Model mode) {
        return "wookmark-example/example-filter/only-filter";
    }

    @RequestMapping("example-endless-scroll.htm")
    public String exampleEndlessScroll(Model mode) {
        return "wookmark-example/example-endless-scroll";
    }

    @RequestMapping("example-flexible.htm")
    public String exampleFlexible(Model mode) {
        return "wookmark-example/example-flexible";
    }

    @RequestMapping("example-lightbox.htm")
    public String exampleLightbox(Model mode) {
        return "wookmark-example/example-lightbox";
    }

    @RequestMapping("example-load-images.htm")
    public String exampleLoadImages(Model mode) {
        return "wookmark-example/example-load-images";
    }

    @RequestMapping("example-placeholder.htm")
    public String examplePlaceholder(Model mode) {
        return "wookmark-example/example-placeholder";
    }

    @RequestMapping("example-sort.htm")
    public String exampleSort(Model mode) {
        return "wookmark-example/example-sort";
    }

    @RequestMapping("example-stamp.htm")
    public String exampleStamp(Model mode) {
        return "wookmark-example/example-stamp";
    }

}
