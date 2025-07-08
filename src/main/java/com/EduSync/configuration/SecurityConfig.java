package com.EduSync.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Profile("!test")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .oauth2Client()
                .and()
                .oauth2Login()
                .tokenEndpoint()
                .and()
                .userInfoEndpoint();

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http
                .authorizeHttpRequests()
                .requestMatchers("/unauthenticated", "/oauth2/**", "/login/**").permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .logout()
                .logoutSuccessUrl("http://localhost:8080/realms/ldap-realm/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/");

        return http.build();
    }

    @Profile("test")
    @Bean
    public SecurityFilterChain testSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authz -> authz.anyRequest().permitAll()) // Allow all requests
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .httpBasic(basic -> basic.disable()) // Disable HTTP Basic
                .formLogin(form -> form.disable()); // Disable form login

        return httpSecurity.build();
    }
}
