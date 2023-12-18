package com.example.social.media.platform.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Define a bean for JwtFilter to be used in the Spring context
    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter(jwtTokenProvider);
    }

    /**
     * Configure method to add JwtFilter in the Spring Security filter chain.
     * This method is called by Spring Security during the configuration process.
     * It ensures that the JwtFilter is applied before the UsernamePasswordAuthenticationFilter.
     *
     * @param http The HttpSecurity object to configure
     * @throws Exception Thrown if an error occurs during configuration
     */
    public void configure(HttpSecurity http) throws Exception {
        // Add JwtFilter before UsernamePasswordAuthenticationFilter in the filter chain
        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}


