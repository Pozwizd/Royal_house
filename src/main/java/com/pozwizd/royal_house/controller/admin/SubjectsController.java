package com.pozwizd.royal_house.controller.admin;

import com.pozwizd.royal_house.model.Subjects;
import com.pozwizd.royal_house.service.SubjectsService;
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
@RequestMapping("/admin/subjects")
public class SubjectsController {

    private final SubjectsService subjectsService;

    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }


    @GetMapping({"/", ""})
    public ModelAndView list(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(required = false) Long id,
                             @RequestParam(required = false) String PropertyType,
                             @RequestParam(required = false) Integer Rooms,

                             @RequestParam(defaultValue = "4") int size,
                             Model model) {

        model.addAttribute("pageActive", "subjects");

        Pageable pageable = PageRequest.of(page, size);
        Page<Subjects> subjects = subjectsService.findByRequest(id,
                PropertyType,
                Rooms, pageable);


        long totalPages = subjects.getTotalPages();
        long totalElements = subjects.getTotalElements();

        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("subjectsList", subjects);
        model.addAttribute("currentPage", page);

        return new ModelAndView("admin/subjects");
    }

    @GetMapping("/get/{id}")
    public ModelAndView getSubject(@PathVariable("id") Long subjectsId, Model model) {

        model.addAttribute("pageActive", "subjects");

        model.addAttribute("subjects", subjectsService.getSubjects(subjectsId));
        return new ModelAndView("admin/subjectsCard");
    }

    @GetMapping("/delete/{id}")
    public String deleteRequestId(@PathVariable("id") Long subjectsId) {
        subjectsService.deleteSubjects(subjectsId);
        return "redirect:/subjects";
    }
}
