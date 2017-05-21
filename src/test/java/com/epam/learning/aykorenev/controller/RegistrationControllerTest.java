package com.epam.learning.aykorenev.controller;

import com.epam.learning.aykorenev.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Anton_Korenev on 5/9/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = RegistrationController.class, secure = false)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PatientService patientService;

    @Test
    public void shouldSuccessfullySubmitFormRegistrationData() throws Exception {
               mockMvc.perform(post("/register/patient").
                       contentType(MediaType.APPLICATION_FORM_URLENCODED).
                       param("login","RedCrocodile2017").
                       param("password","Qwerty123321#$%^").
                       param("confirmPassword","Qwerty123321#$%^").
                       param("firstName","Red").
                       param("lastName","Crocodile").
                       param("age","44").
                       param("contactTelephoneNumber","89993332211").
                       param("email","RedCrocodile2017@mail.zm")).
               andExpect(redirectedUrl("/login"));
    }

    @Test
    public void shouldFailToRegisterWhenPasswordsDoNotMatch() throws Exception {
        mockMvc.perform(post("/register/patient").
                contentType(MediaType.APPLICATION_FORM_URLENCODED).
                param("login","RedCrocodile2017").
                param("password","Qwerty123321#$%^").
                param("confirmPassword","Qwer09y12331#%^").
                param("firstName","Red").
                param("lastName","Crocodile").
                param("age","44").
                param("contactTelephoneNumber","89993332211").
                param("email","RedCrocodile2017@mail.zm")).
                andExpect(view().name("registration")).
                andExpect(model().attributeErrorCount("patientDTO", 1)).
                andExpect(model().attributeHasFieldErrors("patientDTO", "password"));
    }
}