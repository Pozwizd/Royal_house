package com.pozwizd.royal_house.config;

import com.pozwizd.royal_house.service.ServiceImp.UserServiceImp;
import com.pozwizd.royal_house.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig{
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/admin/**").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .formLogin(form -> form
//                        .defaultSuccessUrl("/", true)
//                        .usernameParameter("email")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/login?logout")
//                        .deleteCookies("JSESSIONID")
//                        .permitAll()
//                )
//                .build();
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}