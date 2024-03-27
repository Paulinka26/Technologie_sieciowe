package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableMhetodSecurity
public class SecurityConfig {
    @Value("${jwr.token.key}")
    private String key;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     return http
             .sessionManagement(httpSecuritySessionManagementConfigurer ->
                     httpSecuritySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .addFilterBefore(new JWTTTokenFilter(key),
                         UsernamePasswordAuthenticationFilter.class)
             .authorizeHttpRequests( authorizationManagerRequestMatcherRegistry ->
                     authorizationManagerRequestMatcherRegistry
                             .requestMatchers("/login").permitAll()
                             .requestMatchers("/getAllBooks").hasRole("USER")
             //TUTAJ DALSZE KONFIG
                             )
             //W KONFIGURACJI NIE UŻYWAMY PREFIKSU ROLE
             .build();

             }

}
