package com.epam.learning.aykorenev.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by k1per on 21.05.17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                    antMatchers("/","/registrationPage","/register/patient").permitAll()
                    .anyRequest().authenticated().
                and().
                formLogin()
                    .loginPage("/login").passwordParameter("password").usernameParameter("login").defaultSuccessUrl("/user")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           auth.jdbcAuthentication().dataSource(dataSource).
                   usersByUsernameQuery("select login, password, enabled FROM security_data where login=?").
                   authoritiesByUsernameQuery("select login, role FROM security_data where login=?");

    }
}
