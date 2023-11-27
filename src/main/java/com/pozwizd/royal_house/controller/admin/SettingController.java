package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.model.AboutCompany;
import com.pozwizd.royal_house.model.AdditionalEmail;
import com.pozwizd.royal_house.model.Building;
import com.pozwizd.royal_house.model.User;
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public ModelAndView contact(Model model) {

        User user = userService.getUserById(1L);

        model.addAttribute("user", user);

        return new ModelAndView("admin/contact");
    }

    @PostMapping("/contactEdit")
    public ModelAndView contactEdit(@RequestParam(name = "phoneNumber", required = false) String phoneNumber,
                                    @RequestParam(name = "viber", required = false) String viber,
                                    @RequestParam(name = "telegram", required = false) String telegram,
                                    @RequestParam(name = "email", required = false) String email,
                                    @RequestParam(name = "instagram", required = false) String instagram,
                                    @RequestParam(name = "facebook", required = false) String facebook,
                                    @RequestParam(name = "address", required = false) String address,
                                    @RequestParam(name = "additionalAddress[]", required = false) List<String> additionalAddress,
                                    @RequestParam(name = "oldPassword", required = false) String oldPassword,
                                    @RequestParam(name = "newPassword", required = false) String newPassword,
                                    @RequestParam(name = "repeatNewPassword", required = false) String repeatNewPassword,
                                    Model model) {

        User user = userService.getUserById(1L);

        if (phoneNumber != null) {
            user.setPhoneNumber(phoneNumber);
        }
        if (viber != null) {
            user.setViber(viber);
        }
        if (telegram != null) {
            user.setTelegram(telegram);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (instagram != null) {
            user.setInstagram(instagram);
        }
        if (facebook != null) {
            user.setFacebook(facebook);
        }
        if (address != null) {
            user.setAddress(address);
        }
        if (additionalAddress != null) {
            List<AdditionalEmail> additionalEmails = new ArrayList<>();
            for (String s : additionalAddress) {
                AdditionalEmail additionalEmail = new AdditionalEmail();
                additionalEmail.setEmail(s);
                additionalEmails.add(additionalEmail);
            }
            user.setAdditionalEmails(additionalEmails);
        }


        if (user.getPassword() == oldPassword) {
            if (newPassword.equals(repeatNewPassword)) {
                user.setPassword(newPassword);
            }
        }

        userService.updateUser(user);

        return new ModelAndView("redirect:/setting/contact");
    }



    @GetMapping("/bindingObject")
    public ModelAndView bindingObject(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(defaultValue = "4") int size,
                                      Model model) {

        model.addAttribute("pageActive", "requests");

        Pageable pageable = PageRequest.of(page, size);

        Page<Building> buildings = buildingService
                .findByRequest(name, null,
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

    @PostMapping("/bindingObjectEdit")
    public ModelAndView bindingObjectEdit(@RequestParam(name = "buildingName[]", required = false) List<Building> buildingName,
                                          @RequestParam(name = "selectedUser[]", required = false) List<User> selectedUser,
                                          Model model) {

        for (int i = 0; i < buildingName.size(); i++) {
            buildingName.get(i).setUser(selectedUser.get(i));
            buildingService.save(buildingName.get(i));
            selectedUser.get(i).setBuilding(buildingName.get(i));
            userService.saveUser(selectedUser.get(i));

            return new ModelAndView("redirect:/setting/bindingObject");
        }

        return new ModelAndView("redirect:/setting/bindingObject");
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
        AboutCompany aboutCompany = aboutCompanyService.findAboutCompanyById(1L);
        model.addAttribute("aboutCompany", aboutCompany);


        return new ModelAndView("admin/editPageAboutCompany");
    }


    @PostMapping("/editPageAboutCompany")
    public ModelAndView editPageAboutCompany(@RequestParam(name = "urlBanner", required = false) MultipartFile urlBanner,
                                             @RequestParam(name = "textBanner", required = false) String textBanner,
                                             @RequestParam(name = "titleText", required = false) String titleText,
                                             @RequestParam(name = "textareaAboutCompany", required = false) String textareaAboutCompany,
                                             Model model)  {

        long aboutCompanyId = 1L;
        AboutCompany aboutCompany = aboutCompanyService.findAboutCompanyById(aboutCompanyId);

        if (aboutCompany == null) {
            aboutCompany = new AboutCompany();
            aboutCompany.setId(aboutCompanyId);
            aboutCompany.setBannerText(textBanner);
            aboutCompany.setTitle(titleText);
        } else {
            aboutCompany.setBannerText(textBanner);
            aboutCompany.setTitle(titleText);

        }
        if (!urlBanner.isEmpty()) {
            String oldUrlBanner = aboutCompany.getUrlBanner();
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
                aboutCompany.setUrlBanner("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        aboutCompanyService.saveAboutCompany(aboutCompany);
        return new ModelAndView("admin/editPageAboutCompany");
    }

}
