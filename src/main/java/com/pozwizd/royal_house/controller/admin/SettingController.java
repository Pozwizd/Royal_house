package com.pozwizd.royal_house.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/setting")
public class SettingController {

    @GetMapping("/contact")
    public ModelAndView contact() {

        return new ModelAndView("admin/contact");
    }


}
