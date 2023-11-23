package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("/setting")
public class ContactController {

    private final BuildingService buildingService;
    private final InfographicBuildingService infographicBuildingService;
    private final InfographicInfrastructureService infographicInfrastructureService;
    private final SpecificationBuildingService specificationBuildingService;
    private final InfrastructureBuildingService infrastructureBuildingService;
    private final InfographicRoomService infographicRoomService;
    private final UserService  userService;

    public ContactController(BuildingService buildingService, InfographicBuildingService infographicBuildingService, InfographicInfrastructureService infographicInfrastructureService, SpecificationBuildingService specificationBuildingService, InfrastructureBuildingService infrastructureBuildingService, InfographicRoomService infographicRoomService, UserService userService) {
        this.buildingService = buildingService;
        this.infographicBuildingService = infographicBuildingService;
        this.infographicInfrastructureService = infographicInfrastructureService;
        this.specificationBuildingService = specificationBuildingService;
        this.infrastructureBuildingService = infrastructureBuildingService;
        this.infographicRoomService = infographicRoomService;
        this.userService = userService;
    }

    @GetMapping("/contact")
    public ModelAndView ContactPage(@RequestParam(name = "buildingId", required = true) String id,
                                    Model model) {

        return new ModelAndView("admin/contact");
    }

    @PostMapping("/contact-edit/{id}")
    public ModelAndView ContactEditPage(@RequestParam(name = "buildingId", required = true) String id,
                                        @RequestParam(name = "phoneNumber", required = false) String phone,

                                        Model model) {


        return new ModelAndView("admin/contact");

    }
}
