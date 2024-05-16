package com.watchdogs.eventnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchBarController {
    @RequestMapping("/")
    public String searchbar(){

        return "Search";
    }

}
