package com.pozwizd.royal_house.controller.admin;

import ch.qos.logback.classic.Logger;
import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.StatusBuilding;
import com.pozwizd.royal_house.service.BuildingService;
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
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingService buildingService;
    private Logger logger;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }


    @GetMapping({"/", ""})
    public ModelAndView list(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String address,
                             @RequestParam(required = false) StatusBuilding status,
                             @RequestParam(defaultValue = "4") int size,
                             Model model) {

        model.addAttribute("pageActive", "buildings");

        Pageable pageable = PageRequest.of(page, size);

        Page<Building> buildings = buildingService.findByRequest(name, address, status, pageable);

        long totalPages = buildings.getTotalPages();
        long totalElements = buildings.getTotalElements();

        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("buildings", buildings);
        model.addAttribute("currentPage", page);

        return new ModelAndView("admin/buildings");
    }


    @GetMapping("/get/{id}")
    public ModelAndView getRequestId(@PathVariable("id") Long buildingId, Model model) {

        model.addAttribute("pageActive", "buildings");

        model.addAttribute("building", buildingService.findById(buildingId));
        return new ModelAndView("admin/buildingCard");
    }


    @PostMapping("/edit-basic/{id}")
    public ModelAndView editBasicBuilding(@RequestParam("buildingId") String id,
                                          @RequestParam(name = "mainBanner", required = false) MultipartFile mainBanner,
                                          @RequestParam(name = "buildingName", required = false) String buildingName,
                                          @RequestParam(name = "statusBuilding", required = false) boolean statusBuilding,
                                          @RequestParam(name = "address", required = false) String address,


                                          Model model) {

        Building building = buildingService.findById(Long.parseLong(id));
        building.setName(buildingName);
        building.setAddress(address);
        if (statusBuilding) {
            building.setStatusBuilding(StatusBuilding.Активен);
        } else {
            building.setStatusBuilding(StatusBuilding.Отключен);
        }

        if (!mainBanner.isEmpty()) {
            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + mainBanner.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                mainBanner.transferTo(dest);
                building.setMainBanner("/images/" + fileName);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        buildingService.update(building);
        return new ModelAndView("redirect:/buildings/get/" + building.getId());
    }


    @PostMapping("/edit-about-project/{id}")
    public ModelAndView editAboutProjectBuilding(@RequestParam("buildingId") String id,
                                                 @RequestParam(name = "urlSlide1", required = false) MultipartFile urlSlide1,
                                                 @RequestParam(name = "urlSlide2", required = false) MultipartFile urlSlide2,
                                                 @RequestParam(name = "urlSlide3", required = false) MultipartFile urlSlide3,
                                                 @RequestParam(name = "TextAboutProject", required = false) String TextAboutProject,
                                                 Model model, HttpServletRequest request) {

        Building building = buildingService.findById(Long.parseLong(id));

        if (!urlSlide1.isEmpty()) {
            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide1.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide1.transferTo(dest);
                building.setUrlSlide1("/images/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!urlSlide2.isEmpty()) {
            try {

                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide2.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide2.transferTo(dest);
                building.setUrlSlide2("/images/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!urlSlide3.isEmpty()) {
            try {

                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide3.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide3.transferTo(dest);
                building.setUrlSlide3("/images/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        building.setTextAbout(request.getParameter("TextAboutProject"));
        buildingService.update(building);
        return new ModelAndView("redirect:/buildings/get/" + building.getId());
    }


}
