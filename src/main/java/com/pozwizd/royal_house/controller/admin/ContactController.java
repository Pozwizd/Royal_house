package com.pozwizd.royal_house.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/setting")
public class ContactController {

    @GetMapping("/contact")
    public ModelAndView ContactPage(){
        return new ModelAndView("admin/contact");
    }
}
