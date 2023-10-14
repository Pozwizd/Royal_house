package com.pozwizd.royal_house.controller;

import com.pozwizd.royal_house.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InquiryListController {

    private final InquiryService inquiryService;

    public InquiryListController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }


    @GetMapping({"/inquiry"})
    public ModelAndView inquiryList(Model model) {
//        model.addAttribute("TitlePage", "Royal House");
//        model.addAttribute("allInquiry", inquiryService.findAll());


        return new ModelAndView("inquiry");
    }

}
