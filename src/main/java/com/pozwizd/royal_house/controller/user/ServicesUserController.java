package com.pozwizd.royal_house.controller.user;

import com.pozwizd.royal_house.service.ServiceBannerService;
import com.pozwizd.royal_house.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ServicesUserController {

    private final ServiceBannerService serviceBannerService;
    private final ServicesService servicesService;



    @GetMapping("/services")
    public ModelAndView services(Model model) {

        model.addAttribute("serviceBanners", serviceBannerService.getServiceBanner(1L));
        model.addAttribute("services", servicesService.getAllServices());

        return new ModelAndView("user/services");
    }

    @GetMapping("/service/{id}")
    public ModelAndView service(Model model,
                                @PathVariable String id) {

        model.addAttribute("service", servicesService.getServices(Long.parseLong(id)));

        return new ModelAndView("user/serviceCard");
    }

}
