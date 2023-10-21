package com.pozwizd.royal_house.controller;


import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.Status;
import com.pozwizd.royal_house.service.RequestsService;
import com.pozwizd.royal_house.service.ServiceImp.RequestsServiceImp;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/requests")
public class RequestsController {

    private final RequestsService requestsService;

    public RequestsController(RequestsServiceImp requestsService) {
        this.requestsService = requestsService;
    }

    @GetMapping({"/", ""})
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

    @GetMapping("/changeStatus/{id}")
    public String changeStatusRequestId(@PathVariable("id") Long requestsId) {
        Requests requests = requestsService.getRequests(requestsId);
        if (requests.getStatus().toString().equals("Новый")) {
            requests.setStatus(Status.Отвечено);
        } else {
            requests.setStatus(Status.Новый);
        }
        requestsService.updateRequests(requests);
        return "redirect:/requests";
    }


    @GetMapping("/get/{id}")
    public ModelAndView getRequestId(@PathVariable("id") Long requestsId, Model model) {
        model.addAttribute("requests", requestsService.getRequests(requestsId));
        return new ModelAndView("requestsCard");
    }

    @GetMapping("/delete/{id}")
    public String deleteRequestId(@PathVariable("id") Long requestsId) {
        requestsService.deleteRequests(requestsId);
        return "redirect:/requests";
    }

}



