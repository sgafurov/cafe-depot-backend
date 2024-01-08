package com.cafe_depot.cafe_depot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfiguration {
//     protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         // Allow POST and PUT requests without authentication
//         // http.csrf(csrf -> csrf.disable())
//         http.csrf(AbstractHttpConfigurer::disable)
//                 .authorizeHttpRequests(requests -> requests.anyRequest()
//                         .permitAll());
//         // .requestMatchers("/api/**").permitAll());
//         return http.build();
//     }
// }


