package com.epam.learning.aykorenev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anton_Korenev on 5/1/2017.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }
}
