package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.model.AboutCompany;
import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/setting")
public class SettingController {

    private final BuildingService buildingService;
    private final InfographicBuildingService infographicBuildingService;
    private final InfographicInfrastructureService infographicInfrastructureService;
    private final SpecificationBuildingService specificationBuildingService;
    private final InfrastructureBuildingService infrastructureBuildingService;
    private final InfographicRoomService infographicRoomService;

    private final AboutCompanyService aboutCompanyService;
    private final UserService userService;

    public SettingController(BuildingService buildingService, InfographicBuildingService infographicBuildingService, InfographicInfrastructureService infographicInfrastructureService, SpecificationBuildingService specificationBuildingService, InfrastructureBuildingService infrastructureBuildingService, InfographicRoomService infographicRoomService, AboutCompanyService aboutCompanyService, UserService userService) {
        this.buildingService = buildingService;
        this.infographicBuildingService = infographicBuildingService;
        this.infographicInfrastructureService = infographicInfrastructureService;
        this.specificationBuildingService = specificationBuildingService;
        this.infrastructureBuildingService = infrastructureBuildingService;
        this.infographicRoomService = infographicRoomService;
        this.aboutCompanyService = aboutCompanyService;
        this.userService = userService;
    }

    @GetMapping("/contact")
    public ModelAndView contact() {

        return new ModelAndView("admin/contact");
    }

    @GetMapping("/bindingObject")
    public ModelAndView bindingObject(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(defaultValue = "4") int size,
                                      Model model) {

        model.addAttribute("pageActive", "requests");

        Pageable pageable = PageRequest.of(page, size);

        Page<Building> buildings = buildingService
                .findByName(name,
                        pageable);

        long totalPages = buildings.getTotalPages();
        long totalElements = buildings.getTotalElements();

        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);

        model.addAttribute("buildings", buildings);
        model.addAttribute("currentPage", page);

        model.addAttribute("users", userService.getAllUsers());

        return new ModelAndView("admin/bindingObject");
    }

    @GetMapping("/secondaryMarket")
    public ModelAndView secondaryMarket() {

        return new ModelAndView("admin/secondaryMarket");
    }

    @GetMapping("/editPageService")
    public ModelAndView editPageService() {

        return new ModelAndView("admin/editPageService");
    }


    @GetMapping("/editPageAboutCompany")
    public ModelAndView PageAboutCompany(Model model) {


        return new ModelAndView("admin/editPageAboutCompany");
    }


    @PostMapping("/editPageAboutCompany")
    public ModelAndView editPageAboutCompany(@RequestParam(name = "urlBanner", required = false) MultipartFile urlBanner,
                                             @RequestParam(name = "textBanner", required = false) String textBanner,
                                             @RequestParam(name = "titleText", required = false) String titleText,
                                             @RequestParam(name = "textareaAboutCompany", required = false) String textareaAboutCompany,
                                             Model model)  {

        long aboutCompanyId = 1L;

        if (aboutCompanyService.findAboutCompanyById(aboutCompanyId) == null) {
            AboutCompany aboutCompany = new AboutCompany();
            aboutCompany.setId(aboutCompanyId);
            aboutCompany.setBannerText(textBanner);
            aboutCompany.setTitle(titleText);

            aboutCompanyService.saveAboutCompany(aboutCompany);

        } else {
            AboutCompany aboutCompany = aboutCompanyService.findAboutCompanyById(aboutCompanyId);

            aboutCompany.setBannerText(textBanner);
            aboutCompany.setTitle(titleText);
            aboutCompanyService.saveAboutCompany(aboutCompany);
        }

        return new ModelAndView("admin/editPageAboutCompany");
    }

}
