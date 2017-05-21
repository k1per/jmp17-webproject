package com.epam.learning.aykorenev.controller;

import com.epam.learning.aykorenev.model.dto.PatientDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Anton_Korenev on 5/1/2017.
 */
@Controller
public class MainPageController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/registrationPage")
    public String registration(Model model){
        model.addAttribute("patientDTO", new PatientDTO());
        return "registration";}

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    public String user(){
        return "user-page";
    }
}
