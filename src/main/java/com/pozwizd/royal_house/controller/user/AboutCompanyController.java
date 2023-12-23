package com.pozwizd.royal_house.controller.user;

import com.pozwizd.royal_house.service.AboutCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AboutCompanyController {

    private final AboutCompanyService aboutCompanyService;

    @GetMapping("/aboutCompany")
    public ModelAndView aboutCompany(Model model) {

        model.addAttribute("aboutCompanyService", aboutCompanyService.findAboutCompanyById(1L));

        return new ModelAndView("user/aboutCompany");
    }

}

