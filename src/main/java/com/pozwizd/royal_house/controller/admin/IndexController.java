package com.pozwizd.royal_house.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class IndexController {


    @GetMapping({"/", ""})
    public ModelAndView index(Model model) {



        return new ModelAndView("admin/index");
    }
}
