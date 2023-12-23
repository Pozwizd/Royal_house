package com.pozwizd.royal_house.controller.user;


import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.Subjects;
import com.pozwizd.royal_house.service.BuildingService;
import com.pozwizd.royal_house.service.SubjectsService;
import com.pozwizd.royal_house.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@AllArgsConstructor
public class BuildingUserController {

    private final UserService userService;

    private final BuildingService buildingService;
    private final SubjectsService subjectsService;


    @GetMapping({"/", ""})
    public ModelAndView index(Model model) {

        List<Building> buildings = buildingService.findAll();
        List<Subjects> subjects = subjectsService.findAllSubjects();

        model.addAttribute("buildings", buildings);
        model.addAttribute("subjects", subjects);


        return new ModelAndView("user/index");
    }

    @GetMapping("/building/{id}")
    public ModelAndView buildingCard(@PathVariable String id, Model model) {

        Building building = buildingService.findById(Long.valueOf(id));

        model.addAttribute("building", building);
        return new ModelAndView("user/cardBuilding");
    }


}
