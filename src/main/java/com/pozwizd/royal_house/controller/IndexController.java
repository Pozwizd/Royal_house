package com.pozwizd.royal_house.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {


    @GetMapping({"/", ""})
    public ModelAndView index(Model model) {
//        model.addAttribute("TitlePage", "Royal House");


        return new ModelAndView("index");
    }
}
