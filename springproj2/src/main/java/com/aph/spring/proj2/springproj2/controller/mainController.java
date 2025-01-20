package com.aph.spring.proj2.springproj2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping(value = "/spring2")
public class mainController {
    
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("index");
        return mav;
    }
}
