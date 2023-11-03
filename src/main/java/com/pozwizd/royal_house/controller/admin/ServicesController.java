package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.Services;
import com.pozwizd.royal_house.model.StatusRequests;
import com.pozwizd.royal_house.model.Visible;
import com.pozwizd.royal_house.service.ServicesService;
import jakarta.servlet.http.HttpServletRequest;
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
@RequestMapping("/services")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping({"/", ""})
    public ModelAndView list(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(required = false) String name,
                             @RequestParam(defaultValue = "4") int size,
                             Model model) {

        model.addAttribute("pageActive", "services");

        Pageable pageable = PageRequest.of(page, size);

        Page<Services> services = servicesService.findByRequest(name, pageable);

        long totalPages = services.getTotalPages();
        long totalElements = services.getTotalElements();

        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("services", services);
        model.addAttribute("currentPage", page);

        return new ModelAndView("admin/services");
    }

    @GetMapping("/changeStatus/{id}")
    public String changeStatusRequestId(@PathVariable("id") Long servicesId, HttpServletRequest request, Model model) {


        Services services = servicesService.getServices(servicesId);
        if (services.getVisible().toString().equals("Да")) {
            services.setVisible(Visible.Нет);
        } else {
            services.setVisible(Visible.Да);;
        }
        servicesService.updateServices(services);
        String referer = request.getHeader("Referer");
        if (referer != null) {
            return "redirect:" + referer;
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/get/{id}")
    public ModelAndView getServicesId(@PathVariable("id") Long servicesId, Model model) {

        model.addAttribute("pageActive", "services");

        model.addAttribute("services", servicesService.getServices(servicesId));
        return new ModelAndView("admin/serviceCard");
    }

    @GetMapping("/delete/{id}")
    public String deleteRequestId(@PathVariable("id") Long servicesId) {
        servicesService.deleteServices(servicesId);
        return "redirect:/services";
    }

}
