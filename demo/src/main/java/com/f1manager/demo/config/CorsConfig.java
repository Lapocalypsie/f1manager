package com.f1manager.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    /**
     * Configures and returns a {@link CorsFilter} bean that allows cross-origin
     * requests.
     * This configuration is particularly useful for enabling CORS in a Spring Boot
     * application.
     *
     * <p>
     * The CORS configuration allows requests from the specified origin,
     * permits any header, and allows all HTTP methods.
     * </p>
     *
     * @return a {@link CorsFilter} configured with the specified CORS settings.
     */
    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}