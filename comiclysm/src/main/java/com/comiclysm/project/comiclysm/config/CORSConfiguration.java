package com.comiclysm.project.comiclysm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer(){

        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                // Allowing Cross Origin communication with Angular client
                registry.addMapping("*").allowedOrigins("http://localhost:1200").allowedMethods("GET, POST");

            }
        };
    }

}
