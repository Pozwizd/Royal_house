package com.pozwizd.royal_house.controller.user;

import com.pozwizd.royal_house.model.SecondaryMarket;
import com.pozwizd.royal_house.model.Subjects;
import com.pozwizd.royal_house.service.SecondaryMarketService;
import com.pozwizd.royal_house.service.SubjectsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class SubjectsUserController {

    private SecondaryMarketService secondaryMarketService;
    private SubjectsService subjectsService;

    @GetMapping("/secondaryMarket")
    public ModelAndView SecondaryMarket(Model model) {

        List<SecondaryMarket> secondaryMarkets = secondaryMarketService.getAllSecondaryMarkets();

        List<Subjects> subjects = subjectsService.findAllSubjects();

        model.addAttribute("subjects", subjects);
        model.addAttribute("secondaryMarkets", secondaryMarkets);

        return new ModelAndView("user/secondaryMarket");
    }


    @GetMapping("/subjects/{id}")
    public ModelAndView getSubject(Model model, @PathVariable String id) {

        model.addAttribute("subject", subjectsService.getSubjects(Long.parseLong(id)));

        return new ModelAndView("user/subjectCard");
    }



}
