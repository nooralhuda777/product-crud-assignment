package com.example.product_crud_assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/products/**")
                .authenticated()
                
                .anyRequest()
                .permitAll())
            .formLogin(org.springframework.security.config.Customizer.withDefaults()) ;
          //  .httpBasic(org.springframework.security.config.Customizer.withDefaults());

            
        return http.build();
    }
    
    //Configure in-memory authentication with ADMIN and USER roles

     @Bean
     public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    
       InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
       manager.createUser(User.withUsername("admin")
       .password(encoder.encode("password"))
       .roles("ADMIN")
       .build());  

       manager.createUser(User.withUsername("user")
       .password(encoder.encode("password"))
       .roles("USER")
       .build());
       return manager;
     }
  
}