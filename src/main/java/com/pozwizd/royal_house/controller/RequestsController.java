package com.pozwizd.royal_house.controller;


import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.service.RequestsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inquiry")
public class RequestsController {

    private final RequestsService requestsService;

    public RequestsController(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "0") int page, Model model) {

        Pageable pageable = PageRequest.of(page, 1);

        Page<Requests> requests = requestsService.findAll(pageable);

        model.addAttribute("requests", requests);
        model.addAttribute("currentPage", page);

        return new ModelAndView("inquiry");
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {

        Requests requests = requestsService.getRequests(id);

        model.addAttribute("requests", requests);

        return "request";
    }

    // other handlers...

}
