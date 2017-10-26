package com.zsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

    @RequestMapping("/get/Map")
    public String indexMap(){
        System.out.println("123123123123");
        return "Map";
    }

}
