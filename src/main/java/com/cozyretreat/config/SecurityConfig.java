package com.cozyretreat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JWTResponseFilter jwtResponseFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
    {
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtResponseFilter, AuthorizationFilter.class);
        http.authorizeHttpRequests()
                .requestMatchers("/app/user/login", "/app/user/add", "/app/property/listings/*").permitAll()
                .anyRequest().authenticated();
        return http.build();
    }
}
