package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.model.Services;
import com.pozwizd.royal_house.model.Visible;
import com.pozwizd.royal_house.service.ServicesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/admin/services")
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

    @PostMapping("/edit-service/{id}")
    public ModelAndView editBasicBuilding(@RequestParam("servicesId") String id,
                                          @RequestParam(name = "urlBanner", required = false) MultipartFile urlBanner,
                                          @RequestParam(name = "urlPreview", required = false) MultipartFile urlPreview,
                                          @RequestParam(name = "servicesName", required = false) String servicesName,
                                          @RequestParam(name = "visibleServices", required = false) boolean visibleServices,

                                          Model model) {

        Services services = servicesService.getServices(Long.parseLong(id));
        services.setName(servicesName);
        if (visibleServices) {
            services.setVisible(Visible.Да);
        } else {
            services.setVisible(Visible.Нет);
        }

        if (!urlBanner.isEmpty()) {

            String oldUrlBanner = services.getUrlBanner();
            if (oldUrlBanner != null && !urlBanner.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldUrlBanner;
                File file = new File(filePath);
                file.delete();
            }
            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlBanner.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlBanner.transferTo(dest);
                services.setUrlBanner("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!urlPreview.isEmpty()) {

            String oldUrlPreview = services.getUrlPreview();
            if (oldUrlPreview != null && !urlPreview.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldUrlPreview;
                File file = new File(filePath);
                file.delete();
            }
            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlPreview.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlPreview.transferTo(dest);
                services.setUrlPreview("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Обновляем значения
        services.setName(servicesName);
//        services.setText(visibleServices);
        servicesService.updateServices(services);
        return new ModelAndView("redirect:/services/get/" + services.getId());
    }

}
