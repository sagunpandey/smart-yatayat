package com.sagunpandey.smartyatayat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:4300")
                .allowedMethods("POST", "GET", "PUT", "DELETE", "UPDATE")
                .allowedHeaders("Content-Type")
                .allowCredentials(true)
                .maxAge(6000);
    }
}
