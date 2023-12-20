package com.pozwizd.royal_house.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


//TODO: Удалить как можно быстрее
@Controller
@AllArgsConstructor
public class ExampleController {


    @GetMapping("/example")
    public ModelAndView SecondaryMarket(Model model) {


        return new ModelAndView("/Example");
    }

}
