package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.model.*;
import com.pozwizd.royal_house.service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/setting")
public class SettingController {

    private final PasswordEncoder passwordEncoder;

    private final BuildingService buildingService;
    private final InfographicBuildingService infographicBuildingService;
    private final InfographicInfrastructureService infographicInfrastructureService;
    private final SpecificationBuildingService specificationBuildingService;
    private final InfrastructureBuildingService infrastructureBuildingService;
    private final InfographicRoomService infographicRoomService;
    private final AboutCompanyService aboutCompanyService;
    private final UserService userService;
    private final ServiceBannerService serviceBannerService;
    private final SecondaryMarketService secondaryMarketService;
    private final AdditionalEmailService additionalEmailService;

    @GetMapping("/contact")
    public ModelAndView contact(Authentication authentication, Model model) {

        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);

        return new ModelAndView("admin/contact");
    }

    @PostMapping("/contactEdit")
    public ModelAndView contactEdit(@RequestParam(name = "userId", required = false) Long userId,
                                    @RequestParam(name = "phoneNumber", required = false) String phoneNumber,
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

        Optional<User> user = userService.selectUserById(userId);
        User originalUser = user.get();

        if (phoneNumber != null) {
            originalUser.setPhoneNumber(phoneNumber);
        }
        if (viber != null) {
            originalUser.setViber(viber);
        }
        if (telegram != null) {
            originalUser.setTelegram(telegram);
        }
        if (email != null) {
            originalUser.setEmail(email);
        }
        if (instagram != null) {
            originalUser.setInstagram(instagram);
        }
        if (facebook != null) {
            originalUser.setFacebook(facebook);
        }
        if (address != null) {
            originalUser.setAddress(address);
        }
        if (additionalAddress != null) {
            List<AdditionalEmail> additionalEmails = new ArrayList<>();
            additionalEmailService.deleteAllByUser(originalUser);
            for (String additionalEmail : additionalAddress) {
                AdditionalEmail additionalEmail1 = new AdditionalEmail();
                additionalEmail1.setEmail(additionalEmail);
                additionalEmail1.setUser(originalUser);
                additionalEmails.add(additionalEmail1);
                additionalEmailService.saveAdditionalEmail(additionalEmail1);

            }
            originalUser.setAdditionalEmails(additionalEmails);
        } else {
            additionalEmailService.deleteAllByUser(originalUser);
            originalUser.setAdditionalEmails(null);
        }


        if (passwordEncoder.matches(passwordEncoder.encode(oldPassword), originalUser.getPassword())) {
            if (newPassword.equals(repeatNewPassword)) {
                String encodedPassword = passwordEncoder.encode(newPassword);
                originalUser.setPassword(encodedPassword);
            }
        }

        userService.updateUser(originalUser);

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

        model.addAttribute("users", userService.selectAllUsers());

        return new ModelAndView("admin/bindingObject");
    }

    @PostMapping("/bindingObjectEdit")
    public ModelAndView bindingObjectEdit(@ModelAttribute("selectedUser") ArrayList<User> selectedUser, Model model
            ) {

        List<Building> allBuilding = buildingService.findAll();

        for (int i = 0; i < allBuilding.size(); i++) {
            Optional<User> user = userService.selectUserById((long) i);
            Building building = allBuilding.get(i);
            building.setUser(user.get());
            buildingService.update(building);
        }


        return new ModelAndView("redirect:/setting/bindingObject");
    }


    @GetMapping("/secondaryMarket")
    public ModelAndView secondaryMarket(Model model) {

        List<SecondaryMarket> secondaryMarket = secondaryMarketService.getAllSecondaryMarkets();
        model.addAttribute("secondaryMarkets", secondaryMarket);

        return new ModelAndView("admin/secondaryMarket");
    }

    @PostMapping("/editSecondaryMarket")
    public ModelAndView editSecondaryMarket(@RequestParam(name = "urlImage[]", required = true) List<MultipartFile> urlImage,
                                            @RequestParam(name = "text[]", required = true) List<String> text,
                                            @RequestParam(name = "url[]", required = true) List<String> urlList) {

        for (int i = 0; i < urlImage.size(); i++) {
            SecondaryMarket secondaryMarket = secondaryMarketService.getSecondaryMarket(i + 1L);
            if (secondaryMarket == null) {
                secondaryMarket = new SecondaryMarket();
                secondaryMarket.setId(i + 1L);
                secondaryMarket.setText(text.get(i));
                secondaryMarket.setUrl(urlList.get(i));
            } else {
                secondaryMarket.setText(text.get(i));
                secondaryMarket.setUrl(urlList.get(i));
            }

            if (!urlImage.get(i).isEmpty()) {
                String oldUrlImage = secondaryMarket.getUrlImage();
                if (oldUrlImage != null && !urlImage.get(i).isEmpty()) {
                    String filePath = Paths.get("").toFile().getAbsolutePath() + oldUrlImage;
                    File file = new File(filePath);
                    file.delete();
                }

                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlImage.get(i).getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                try {
                    urlImage.get(i).transferTo(dest);
                    secondaryMarket.setUrlImage("/images/" + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            secondaryMarketService.updateSecondaryMarket(secondaryMarket);
        }


        return new ModelAndView("redirect:/setting/secondaryMarket");
    }

    @GetMapping("/pageService")
    public ModelAndView pageService(Model  model) {

        ServiceBanner serviceBanner = serviceBannerService.getServiceBanner(1L);
        model.addAttribute("serviceBanner", serviceBanner);

        return new ModelAndView("admin/editPageService");
    }


    @PostMapping("/editPageService")
    public ModelAndView editPageService(@RequestParam(name = "urlBanner", required = false) MultipartFile urlBanner,
                                        @RequestParam(name = "textBanner", required = false) String textBanner,
                                        @RequestParam(name = "titleText", required = false) String titleText,
                                        Model model) {



        long serviceBannerId = 1L;
        ServiceBanner serviceBanner = serviceBannerService.getServiceBanner(serviceBannerId);

        if (serviceBanner == null) {
            serviceBanner = new ServiceBanner();
            serviceBanner.setId(serviceBannerId);
            serviceBanner.setText(textBanner);
            serviceBanner.setTitle(titleText);
        } else {
            serviceBanner.setText(textBanner);
            serviceBanner.setTitle(titleText);
        }
        if (!urlBanner.isEmpty()) {
            String oldUrlBanner = serviceBanner.getUrlImage();
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
                serviceBanner.setUrlImage("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        serviceBannerService.updateServiceBanner(serviceBanner);

        return new ModelAndView("redirect:/setting/pageService");
    }

    @GetMapping("/pageAboutCompany")
    public ModelAndView PageAboutCompany(Model model) {
        AboutCompany aboutCompany = aboutCompanyService.findAboutCompanyById(1L);
        model.addAttribute("aboutCompany", aboutCompany);


        return new ModelAndView("admin/editPageAboutCompany");
    }


    @PostMapping("/editPageAboutCompany")
    public ModelAndView editPageAboutCompany(@RequestParam(name = "urlBanner", required = false) MultipartFile urlBanner,
                                             @RequestParam(name = "textBanner", required = false) String textBanner,
                                             @RequestParam(name = "titleText", required = false) String titleText,
                                             @RequestParam(name = "editorDataInfrastructureBuilding", required = false) String textareaAboutCompany,
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
            aboutCompany.setText(textareaAboutCompany);
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


        aboutCompanyService.updateAboutCompany(aboutCompany);
        return new ModelAndView("redirect:/setting/pageAboutCompany");
    }

}
