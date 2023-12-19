package com.pozwizd.royal_house.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AboutCompanyController {


    @GetMapping("/aboutCompany")
    public ModelAndView aboutCompany(Model model) {


        return new ModelAndView("user/aboutCompany");
    }

}

