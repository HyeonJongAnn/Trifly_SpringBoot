//package com.bit.nc4_final_project.configuration;
//
//import com.bit.nc4_final_project.jwt.JwtAutheticationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfiguration {
//    private final JwtAutheticationFilter jwtAutheticationFilter;
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .cors(httpSecurityCorsConfigurer -> {
//
//                })
//                .csrf(AbstractHttpConfigurer::disable)
//                .httpBasic(AbstractHttpConfigurer::disable)
//                .sessionManagement(httpSecuritySessionManagementConfigurer -> {
//                    httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                })
//                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
//                    authorizationManagerRequestMatcherRegistry.requestMatchers("/").permitAll();
//                    authorizationManagerRequestMatcherRegistry.requestMatchers("/review/**").permitAll();
//                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
//                })
//                .addFilterAfter(jwtAutheticationFilter, CorsFilter.class)
//                .build();
//
//    }
//}
