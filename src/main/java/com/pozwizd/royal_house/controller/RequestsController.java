package com.pozwizd.royal_house.controller;


import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.service.ServiceImp.RequestsServiceImp;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestsController {

    private final RequestsServiceImp requestsService;

    public RequestsController(RequestsServiceImp requestsService) {
        this.requestsService = requestsService;
    }

    @GetMapping("/requests")
    public ModelAndView list(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) String phoneNumber,
                             @RequestParam(defaultValue = "4") int size,
                             Model model) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Requests> requests = requestsService.findByRequest(name,
                phoneNumber,
                email,pageable);

        long totalPages = requests.getTotalPages();
        long totalElements = requests.getTotalElements();

        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("requests", requests);
        model.addAttribute("currentPage", page);

        return new ModelAndView("requests");
    }

}



