package com.pozwizd.royal_house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class RoyalHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoyalHouseApplication.class, args);
    }
}
