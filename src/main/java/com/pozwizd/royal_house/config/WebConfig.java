package com.pozwizd.royal_house.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter());
    }

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter("dd.MM.yyyy - HH:mm");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/**");


        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:/" + Paths.get("images").toFile().getAbsolutePath() + "/")
        ;
    }
}