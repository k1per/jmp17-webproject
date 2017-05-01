package com.epam.learning.aykorenev.controller;

import com.epam.learning.aykorenev.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Anton_Korenev on 5/1/2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping
    public Patient helloWorld(){
        return new Patient(1L, "Red", "Crocodile");
    }
}
