package com.suitecare.suitecare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/api/v1/login").permitAll()
                                .requestMatchers("/api/v1/member").permitAll()
                                .requestMatchers("/api/v1/mypage").permitAll()
                                .requestMatchers("/api/v1/changepw").permitAll()
                                .requestMatchers("/api/v1/modify").permitAll()
                                .requestMatchers("/api/v1/patient").permitAll()
                                .requestMatchers("/api/v1/mate/profile").permitAll()
                                .requestMatchers("/api/v1/patient/**").permitAll()
                                .requestMatchers("/api/v1/patientDetail/**").permitAll()
                                .requestMatchers("/api/v1/search/reservation").permitAll()
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                .requestMatchers("/api/v1/reservation/**").permitAll()
                                .requestMatchers("/api/v1/apply").permitAll()
                                .requestMatchers("/api/v1/pendingReservation").permitAll()
                                .requestMatchers("/api/v1/applicant-list").permitAll()
                                .requestMatchers("/api/v1/reservationInfo").permitAll()
                                .anyRequest().authenticated()
                );
        return http.build();
    }
}
