package com.pozwizd.royal_house.controller.user;

import com.pozwizd.royal_house.model.Requests;
import com.pozwizd.royal_house.model.StatusRequests;
import com.pozwizd.royal_house.service.RequestsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
public class CreateRequestController {

    private final RequestsService requestsService;



    @GetMapping("/request")
    public ModelAndView UserRequest(Model model) {
        return new ModelAndView("user/leaveRequest");
    }

    @PostMapping("/requestComplete")
    public ModelAndView CreateUserRequest(@RequestParam(name = "name") String name,
                                          @RequestParam(name = "phone") String phone,
                                          @RequestParam(name = "email") String email,
                                          @RequestParam(name = "textRequest", required = false) String textRequest,
                                          HttpServletRequest request) {

        Requests requests = new Requests();
        requests.setName(name);
        requests.setPhoneNumber(phone);
        requests.setEmail(email);
        requests.setDate(LocalDateTime.now());
        requests.setComment(textRequest);
        requests.setStatusRequests(StatusRequests.Новый);

        requestsService.saveRequests(requests);
        String referer = request.getHeader("Referer");
        return new ModelAndView("redirect:" + referer);
    }


}

