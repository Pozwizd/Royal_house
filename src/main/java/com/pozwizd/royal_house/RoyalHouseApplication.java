package com.pozwizd.royal_house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
@SpringBootApplication
public class RoyalHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoyalHouseApplication.class, args);
    }


}
