package com.example.tasksmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(toH2Console()).permitAll()
                        .requestMatchers("/groups/**").permitAll()
                        .anyRequest().authenticated())
                .headers(headers -> headers.frameOptions().sameOrigin())
                .build();
    }
}
