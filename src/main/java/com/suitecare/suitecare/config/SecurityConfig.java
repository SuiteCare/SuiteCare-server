package com.suitecare.suitecare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/api/v1/login").permitAll()
                                .requestMatchers("/api/v1/member").permitAll()
                                .requestMatchers("/api/v1/patient").permitAll()
                                .anyRequest().authenticated()
                );
        return http.build();
    }
}
