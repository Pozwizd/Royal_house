package com.pozwizd.royal_house.controller;


import com.pozwizd.royal_house.criteria.RequestsSearchCriteria;
import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.RequestsPage;
import com.pozwizd.royal_house.service.ServiceImp.RequestsServiceImp;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestsController {

    @GetMapping("/inquiry")
    public ModelAndView getEmployees(){

        return new ModelAndView("inquiry");
    }
}



