//package com.dev.project_keycloack.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(
//                        authorize -> authorize
//                                .requestMatchers("/products").authenticated()
//                                .requestMatchers("/logout").authenticated()
//                                .anyRequest().permitAll()
//                )
//                .oauth2Login(Customizer.withDefaults())
//                .logout(logout ->
//                        logout.clearAuthentication(true)
//                                .logoutSuccessUrl("http://localhost:8080/realms/webmvcapp-realm/protocol/openid-connect/logout?redirect_uri=http://localhost:8081")
//                                .invalidateHttpSession(true)
//                );
//        return http.build();
//    }
//}