package com.humanServices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String getIndexPage() {
    	System.out.println("\n\n*************In the index page\n\n");
        return "index";
    }
}
