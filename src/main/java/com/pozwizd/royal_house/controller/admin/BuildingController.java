package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.model.*;
import com.pozwizd.royal_house.service.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/admin/buildings")
@AllArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;
    private final InfographicBuildingService infographicBuildingService;
    private final InfographicInfrastructureService infographicInfrastructureService;
    private final SpecificationBuildingService specificationBuildingService;
    private final InfographicRoomService infographicRoomService;

    @GetMapping({"/", ""})
    public ModelAndView list(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String address,
                             @RequestParam(defaultValue = "4") int size,
                             Model model) {

        model.addAttribute("pageActive", "buildings");

        Pageable pageable = PageRequest.of(page, size);

        Page<Building> buildings;
        if (name != null || address != null) {
            buildings = buildingService.findByRequest(name, address, pageable);
        } else {
            buildings = buildingService.findAll(pageable);
        }

        long totalPages = buildings.getTotalPages();
        long totalElements = buildings.getTotalElements();

        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("buildings", buildings);
        model.addAttribute("currentPage", page);

        return new ModelAndView("admin/buildings");
    }


    @GetMapping("/get/{id}")
    public ModelAndView getBuildingId(@PathVariable("id") Long buildingId, Model model) {
        model.addAttribute("pageActive", "buildings");
        model.addAttribute("building", buildingService.findById(buildingId));
        return new ModelAndView("admin/buildingCard");
    }

    @GetMapping("/changeStatus/{id}")
    public String changeStatusRequestId(@PathVariable("id") Long buildingId, HttpServletRequest request, Model model) {


        Building building1 = buildingService.findById(buildingId);
        if (building1.getStatusBuilding().toString().equals("Отключен")) {
            building1.setStatusBuilding(StatusBuilding.Активен);
        } else {
            building1.setStatusBuilding(StatusBuilding.Отключен);
        }
        buildingService.update(building1);


        String referer = request.getHeader("Referer");
        return "redirect:" + referer;

    }

    @PostMapping("/edit-basic/{id}")
    public ModelAndView editBasicBuilding(@PathVariable String id,
                                          @RequestParam(name = "mainBanner", required = false) MultipartFile mainBanner,
                                          @RequestParam(name = "buildingName", required = false) String buildingName,
                                          @RequestParam(name = "statusBuilding", required = false) boolean statusBuilding,
                                          @RequestParam(name = "address", required = false) String address,
                                          @RequestParam(name = "imagesInfographic[]", required = false) List<MultipartFile> imagesInfographic,
                                          @RequestParam(name = "descriptionImageInfographic[]", required = false) List<String> descriptionImageInfographic,
                                          HttpServletRequest request,
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

            String oldMainBanner = building.getMainBanner();
            if (oldMainBanner != null && !mainBanner.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldMainBanner;
                File file = new File(filePath);
                file.delete();
            }

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

        List<InfographicPage> infographicPageList = new ArrayList<>();
        List<InfographicBuilding> infographicBuildings = new ArrayList<>();
        if (!Objects.equals(imagesInfographic.get(0).getOriginalFilename(), "") && !descriptionImageInfographic.isEmpty()) {
            // Переупаковка в другой массив
            int i = 0;
            for (MultipartFile imageInfographic : imagesInfographic) {
                if (!Objects.equals(imageInfographic.getOriginalFilename(), "") && !descriptionImageInfographic.get(i).isEmpty()) {
                    InfographicPage infographicPage = new InfographicPage();
                    infographicPage.setImage(imageInfographic);
                    infographicPage.setDescriptionImage(descriptionImageInfographic.get(i));
                    infographicPageList.add(infographicPage);
                    i++;
                }
            }
            // Проверка на наличие изображений в бд
            // Если на вход приходит хотябы 1 изображение, то удаляем из бд и папки images все изображения последовательно
            if (!infographicPageList.isEmpty()) {
                for (InfographicBuilding buildingInfographic : infographicBuildingService.findAllInfographicBuildingsByBuilding(Long.parseLong(id))) {
                    String filePath = Paths.get("").toFile().getAbsolutePath() + buildingInfographic.getUrlImage();
                    File file = new File(filePath);
                    file.delete();
                    infographicBuildingService.deleteInfographicBuilding(buildingInfographic.getId());
                }
            }

            for (InfographicPage infographicPage : infographicPageList) {
                InfographicBuilding infographicBuilding = new InfographicBuilding();
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + infographicPage.getImage().getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                try {
                    infographicPage.getImage().transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                infographicBuilding.setUrlImage("/images/" + fileName);
                infographicBuilding.setDescription(infographicPage.getDescriptionImage());
                infographicBuildings.add(infographicBuilding);
                infographicBuilding.setBuilding(building);
            }
        }

        building.setInfographicBuildings(infographicBuildings);
        infographicBuildingService.saveAll(infographicBuildings);
        buildingService.update(building);

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }


    @PostMapping("/edit-about-project/{id}")
    public ModelAndView editAboutProjectBuilding(@PathVariable String id,
                                                 @RequestParam(name = "urlSlide1", required = false) MultipartFile urlSlide1,
                                                 @RequestParam(name = "urlSlide2", required = false) MultipartFile urlSlide2,
                                                 @RequestParam(name = "urlSlide3", required = false) MultipartFile urlSlide3,
                                                 @RequestParam(name = "editorDataAboutProject", required = false) Object TextAboutProject,
                                                 HttpServletRequest request,
                                                 Model model) {

        Building building = buildingService.findById(Long.parseLong(id));

        if (!urlSlide1.isEmpty()) {
            String oldUrlSlide1 = building.getUrlSlide1();
            if (oldUrlSlide1 != null && !urlSlide1.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldUrlSlide1;
                File file = new File(filePath);
                file.delete();
            }

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
            String oldMainBanner = building.getUrlSlide2();
            if (oldMainBanner != null && !urlSlide2.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldMainBanner;
                File file = new File(filePath);
                file.delete();
            }

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
            String oldMainBanner = building.getUrlSlide3();
            if (oldMainBanner != null && !urlSlide3.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldMainBanner;
                File file = new File(filePath);
                file.delete();
            }

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


        building.setTextAbout(TextAboutProject.toString());
        buildingService.update(building);

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }

    @PostMapping("/edit-location/{id}")
    public ModelAndView editLocationBuilding(@PathVariable String id,
                                             @RequestParam(name = "editorDataLocation", required = true) String textLocation,
                                             @RequestParam(name = "LocationLongitudeBuilding", required = true) String longitude,
                                             @RequestParam(name = "LocationLatitudeBuilding", required = true) String latitude,
                                             HttpServletRequest request,
                                             Model model) {

        Building building = buildingService.findById(Long.parseLong(id));
        building.setLongitude(longitude);
        building.setLatitude(latitude);
        building.setTextLocation(textLocation);
        buildingService.update(building);

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }

    @PostMapping("/edit-infrastructure-building/{id}")
    public ModelAndView editInfrastructureBuilding(@PathVariable String id,
                                                   @RequestParam(name = "urlSlide1", required = false) MultipartFile urlSlide1,
                                                   @RequestParam(name = "urlSlide2", required = false) MultipartFile urlSlide2,
                                                   @RequestParam(name = "urlSlide3", required = false) MultipartFile urlSlide3,
                                                   @RequestParam(name = "editorDataInfrastructureBuilding", required = false) String TextInfrastructureBuilding,
                                                   @RequestParam(name = "imagesInfographicInfrastructure[]", required = false) List<MultipartFile> imagesInfographicInfrastructure,
                                                   @RequestParam(name = "descriptionImageInfographicInfrastructure[]", required = false) List<String> descriptionImageInfographicInfrastructure,
                                                   HttpServletRequest request,
                                                   Model model) {

        Building building = buildingService.findById(Long.parseLong(id));

        // Обработка картинок
        if (!urlSlide1.isEmpty()) {
            String oldUrlSlide1 = building.getInfrastructureBuilding().getUrlSlide1();
            if (oldUrlSlide1 != null && !urlSlide1.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldUrlSlide1;
                File file = new File(filePath);
                file.delete();
            }

            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide1.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide1.transferTo(dest);
                building.getInfrastructureBuilding().setUrlSlide1("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!urlSlide2.isEmpty()) {
            String oldMainBanner = building.getInfrastructureBuilding().getUrlSlide2();
            if (oldMainBanner != null && !urlSlide2.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldMainBanner;
                File file = new File(filePath);
                file.delete();
            }

            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide2.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide2.transferTo(dest);
                building.getInfrastructureBuilding().setUrlSlide2("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!urlSlide3.isEmpty()) {
            String oldMainBanner = building.getInfrastructureBuilding().getUrlSlide3();
            if (oldMainBanner != null && !urlSlide3.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldMainBanner;
                File file = new File(filePath);
                file.delete();
            }

            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide3.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide3.transferTo(dest);
                building.getInfrastructureBuilding().setUrlSlide3("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Обработка текста


        // Обработка инфографики

          /*
        1. Переупаковка в другой массив
        2. Проверка на наличие изображений в бд
        3. Если на вход приходит хотябы 1 изображение, то удаляем из бд и папки images все изображения последовательно
        4. После этого записываем новые

         */

        List<InfographicPage> infographicPageList = new ArrayList<>();
        List<InfographicInfrastructure> infographicInfrastructures = new ArrayList<>();

        // Переупаковка в другой массив
        int i = 0;
        for (MultipartFile imageInfographic : imagesInfographicInfrastructure) {
            if (!Objects.equals(imagesInfographicInfrastructure.get(i).getOriginalFilename(), "")
                    && !descriptionImageInfographicInfrastructure.get(i).isEmpty()) {
                if (!Objects.equals(imageInfographic.getOriginalFilename(), "") && !descriptionImageInfographicInfrastructure.get(i).isEmpty()) {
                    InfographicPage infographicPage = new InfographicPage();
                    infographicPage.setImage(imageInfographic);
                    infographicPage.setDescriptionImage(descriptionImageInfographicInfrastructure.get(i));
                    infographicPageList.add(infographicPage);
                }
            }
            i++;
        }
        // Проверка на наличие изображений в бд
        // Если на вход приходит хотябы 1 изображение, то удаляем из бд и папки images все изображения последовательно
        if (!infographicPageList.isEmpty()) {
            for (InfographicInfrastructure infographicInfrastructure : infographicInfrastructureService.findAllInfographicInfrastructures()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + infographicInfrastructure.getUrlImage();
                File file = new File(filePath);
                file.delete();
                infographicInfrastructureService.deleteInfographicInfrastructure(infographicInfrastructure.getId());
            }
        }

        // После этого записываем новые в бд и зановисив в новую коллекцию
        for (InfographicPage infographicPage : infographicPageList) {
            InfographicInfrastructure infographicInfrastructure = new InfographicInfrastructure();
            String uuidFile = UUID.randomUUID().toString();
            String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
            String fileName = uuidFile + "." + infographicPage.getImage().getOriginalFilename();
            String filePath = uploadDir + fileName;
            File dest = new File(filePath);
            try {
                infographicPage.getImage().transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            infographicInfrastructure.setUrlImage("/images/" + fileName);
            infographicInfrastructure.setDescription(infographicPage.getDescriptionImage());
            infographicInfrastructure.setInfrastructureBuilding(building.getInfrastructureBuilding());
            infographicInfrastructures.add(infographicInfrastructure);
            infographicInfrastructureService.saveInfographicInfrastructure(infographicInfrastructure);
        }
        building.getInfrastructureBuilding().setText(TextInfrastructureBuilding);
        // Обновляем значения
        building.getInfrastructureBuilding().setInfographicInfrastructures(infographicInfrastructures);
        buildingService.update(building);

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }

    @PostMapping("/edit-rooms-building/{id}")
    public ModelAndView editRoomsBuilding(@PathVariable String id,
                                          @RequestParam(name = "urlSlide1", required = false) MultipartFile urlSlide1,
                                          @RequestParam(name = "urlSlide2", required = false) MultipartFile urlSlide2,
                                          @RequestParam(name = "urlSlide3", required = false) MultipartFile urlSlide3,
                                          @RequestParam(name = "editorDataRoomsBuilding", required = false) String textRoomsBuilding,
                                          @RequestParam(name = "imagesRoomInfographic[]", required = false) List<MultipartFile> imagesRoomInfographic,
                                          @RequestParam(name = "descriptionImageRoomInfographic[]", required = false) List<String> descriptionImageRoomInfographic,
                                          HttpServletRequest request) {

        Building building = buildingService.findById(Long.parseLong(id));

        // Обработка картинок
        if (!urlSlide1.isEmpty()) {
            String oldUrlSlide1 = building.getRoomBuilding().getUrlSlide1();
            if (oldUrlSlide1 != null && !urlSlide1.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldUrlSlide1;
                File file = new File(filePath);
                file.delete();
            }

            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide1.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide1.transferTo(dest);
                building.getRoomBuilding().setUrlSlide1("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!urlSlide2.isEmpty()) {
            String oldMainBanner = building.getRoomBuilding().getUrlSlide2();
            if (oldMainBanner != null && !urlSlide2.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldMainBanner;
                File file = new File(filePath);
                file.delete();
            }

            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide2.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide2.transferTo(dest);
                building.getRoomBuilding().setUrlSlide2("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!urlSlide3.isEmpty()) {
            String oldMainBanner = building.getRoomBuilding().getUrlSlide3();
            if (oldMainBanner != null && !urlSlide3.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldMainBanner;
                File file = new File(filePath);
                file.delete();
            }

            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + urlSlide3.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                urlSlide3.transferTo(dest);
                building.getRoomBuilding().setUrlSlide3("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Обработка текста

        building.getRoomBuilding().setText(textRoomsBuilding);

        // Обработка инфографики

          /*
        1. Переупаковка в другой массив
        2. Проверка на наличие изображений в бд
        3. Если на вход приходит хотябы 1 изображение, то удаляем из бд и папки images все изображения последовательно
        4. После этого записываем новые
         */

        List<InfographicPage> infographicPageList = new ArrayList<>();
        List<InfographicRoom> infographicRooms = new ArrayList<>();

        // Переупаковка в другой массив
        int i = 0;
        for (MultipartFile imageInfographic : imagesRoomInfographic) {
            if (!Objects.equals(imagesRoomInfographic.get(i).getOriginalFilename(), "") && !descriptionImageRoomInfographic.get(i).isEmpty()) {
                if (!Objects.equals(imageInfographic.getOriginalFilename(), "") && !descriptionImageRoomInfographic.get(i).isEmpty()) {
                    InfographicPage infographicPage = new InfographicPage();
                    infographicPage.setImage(imageInfographic);
                    infographicPage.setDescriptionImage(descriptionImageRoomInfographic.get(i));
                    infographicPageList.add(infographicPage);
                }
            }
            i++;
        }
        // Проверка на наличие изображений в бд
        // Если на вход приходит хотябы 1 изображение, то удаляем из бд и папки images все изображения последовательно
        if (!infographicPageList.isEmpty()) {
            for (InfographicRoom infographicRoom : infographicRoomService.findAllInfographicRooms()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + infographicRoom.getUrlImage();
                File file = new File(filePath);
                file.delete();
                infographicRoomService.deleteInfographicRoom(infographicRoom.getId());
            }
        }

        // После этого записываем новые в бд и зановисив в новую коллекцию
        for (InfographicPage infographicPage : infographicPageList) {
            InfographicRoom infographicRoom = new InfographicRoom();
            String uuidFile = UUID.randomUUID().toString();
            String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
            String fileName = uuidFile + "." + infographicPage.getImage().getOriginalFilename();
            String filePath = uploadDir + fileName;
            File dest = new File(filePath);
            try {
                infographicPage.getImage().transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            infographicRoom.setUrlImage("/images/" + fileName);
            infographicRoom.setDescription(infographicPage.getDescriptionImage());
            infographicRoom.setRoomBuilding(building.getRoomBuilding());
            infographicRoomService.saveInfographicRoom(infographicRoom);
            infographicRooms.add(infographicRoom);
        }

        // Обновляем значения
        building.getRoomBuilding().setInfographicRooms(infographicRooms);
        buildingService.update(building);

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }


    @PostMapping("/edit-panorama/{id}")
    public ModelAndView editPanoramaBuilding(@PathVariable String id,
                                             @RequestParam(name = "panoramaBuilding", required = false) MultipartFile panoramaBuilding,
                                             HttpServletRequest request) {

        Building building = buildingService.findById(Long.parseLong(id));

        if (!panoramaBuilding.isEmpty()) {
            String oldUrlPanorama = building.getUrlPanorama();
            if (oldUrlPanorama != null && !panoramaBuilding.isEmpty()) {
                String filePath = Paths.get("").toFile().getAbsolutePath() + oldUrlPanorama;
                File file = new File(filePath);
                file.delete();
            }

            try {
                String uuidFile = UUID.randomUUID().toString();
                String uploadDir = Paths.get("images").toFile().getAbsolutePath() + "/";
                String fileName = uuidFile + "." + panoramaBuilding.getOriginalFilename();
                String filePath = uploadDir + fileName;
                File dest = new File(filePath);
                panoramaBuilding.transferTo(dest);
                building.setUrlPanorama("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buildingService.update(building);
        }

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }

    @PostMapping("/edit-specification/{id}")
    public ModelAndView editSpecificationBuilding(@PathVariable String id,
                                                  @RequestParam(name = "editorDataSpecificationBuilding[]", required = false) List<String> specificationBuildingsText,
                                                  HttpServletRequest request) {

        Building building = buildingService.findById(Long.parseLong(id));

        specificationBuildingService.deleteAllSpecificationBuildings();
        building.setSpecificationBuildings(new ArrayList<>());

        if (specificationBuildingsText != null && !specificationBuildingsText.isEmpty()) {
            for (int i = 0; i < specificationBuildingsText.size(); i++) {
                SpecificationBuilding specificationBuilding = new SpecificationBuilding();
                specificationBuilding.setId((long) i + 1);
                specificationBuilding.setText(specificationBuildingsText.get(i));
                specificationBuilding.setBuilding(building);
                building.getSpecificationBuildings().add(specificationBuilding);
                specificationBuildingService.saveSpecificationBuilding(specificationBuilding);
            }
        }

        buildingService.update(building);

        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }
}

