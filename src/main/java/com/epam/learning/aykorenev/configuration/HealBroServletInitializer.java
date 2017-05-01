package com.epam.learning.aykorenev.configuration;

import com.epam.learning.aykorenev.HealBroApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Anton_Korenev on 5/1/2017.
 */
public class HealBroServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HealBroApplication.class);
    }
}
