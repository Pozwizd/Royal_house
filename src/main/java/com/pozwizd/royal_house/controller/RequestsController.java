package com.pozwizd.royal_house.controller;


import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.service.RequestsService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestsController {

    private final RequestsService requestsService;

    public RequestsController(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    @GetMapping("/inquiry")
    public ModelAndView list(@RequestParam(defaultValue = "0") int page, Model model) {

        Pageable pageable = PageRequest.of(page, 2);

        Page<Requests> requests = requestsService.findAll(pageable);
        long totalPages = requests.getTotalPages();

        long totalElements = requests.getTotalElements();
        model.addAttribute("totalElements", totalElements);

        model.addAttribute("requests", requests);
        model.addAttribute("currentPage", page);

        return new ModelAndView("inquiry");
    }

}



