package com.epam.learning.aykorenev.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Anton_Korenev on 5/9/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = MainPageController.class, secure = false)
public class MainPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnHomeView() throws Exception {
        mockMvc.perform(get("/")).
                andExpect(view().name("index"));
    }
}