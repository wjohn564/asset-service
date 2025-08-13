package com.equipreserve.asset_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    // Class to configure cors
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Cors will be read only so this will suffice
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET");
    }
}
