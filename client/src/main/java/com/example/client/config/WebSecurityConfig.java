package com.example.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login.loginPage("/oauth2/authorization/oidc-client"))
                .oauth2Client(withDefaults());
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/home", "/statistics", "/error", "/statistics/test").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(LogoutConfigurer::permitAll);
//
//        return http.build();
//    }
}
