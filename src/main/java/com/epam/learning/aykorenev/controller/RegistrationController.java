package com.epam.learning.aykorenev.controller;

import com.epam.learning.aykorenev.model.dto.PatientDTO;
import com.epam.learning.aykorenev.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Anton_Korenev on 5/9/2017.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    private PatientService patientService;

    public RegistrationController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patient")
    public String registerPatient(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO,
                                  BindingResult bindingResult){
        if(!patientDTO.getPassword().equals(patientDTO.getConfirmPassword())){
            bindingResult.rejectValue("password", "validation.password.notSame");
        }
        if (bindingResult.hasErrors()) {
            logger.info("Received patient to register has not proceed validation ", patientDTO);
            return "registration";
        }
        logger.info("Received patient to register {} ", patientDTO);
        patientService.createNewPatient(patientDTO);
        return "redirect:/login";
    }
}
