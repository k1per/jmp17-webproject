package com.epam.learning.aykorenev.controller;

import com.epam.learning.aykorenev.model.dto.PatientDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anton_Korenev on 5/1/2017.
 */
@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/registrationPage")
    public String registration(Model model){
        model.addAttribute("patientDTO", new PatientDTO());
        return "registration";}
}
