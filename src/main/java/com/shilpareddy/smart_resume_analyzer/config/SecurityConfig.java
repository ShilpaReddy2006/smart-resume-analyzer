package com.shilpareddy.smart_resume_analyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 

    http
        .csrf(csrf -> csrf.disable())

        .authorizeHttpRequests(auth -> auth
            // Swagger MUST be fully open
            .requestMatchers(
                "/swagger-ui/**",
                "/swagger-ui.html",
                "/swagger-ui/index.html",
                "/v3/api-docs/**",
                "/v3/api-docs",
                "/health"
            ).permitAll()

            // your APIs (optional secure)
            .requestMatchers("/auth/**").permitAll()

            .anyRequest().authenticated()
        )

        // IMPORTANT for Swagger + REST APIs
        .formLogin(form -> form.disable())
        .httpBasic(httpBasic -> httpBasic.disable());

    return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



