package com.example.busreservation.securityconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/", "/home", "/css/**", "/js/**").permitAll()  // Allow login and static resources
                .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/staff/**").hasRole("STAFF")
                .requestMatchers(HttpMethod.GET, "/client/**").hasRole("CLIENT")
//                .requestMatchers(HttpMethod.GET, "/api/buses/**").hasAnyRole("ADMIN", "STAFF", "CLIENT")
//                .requestMatchers(HttpMethod.GET, "/api/routes/**").hasAnyRole("ADMIN", "STAFF", "CLIENT")
//                .requestMatchers(HttpMethod.POST, "/api/buses/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.PUT, "/api/buses/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/api/buses/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.POST, "/api/routes/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.PUT, "/api/routes/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/api/routes/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/api/reservations/**").hasAnyRole("ADMIN", "STAFF", "CLIENT")
//                .requestMatchers(HttpMethod.POST, "/api/reservations/**").hasAnyRole("ADMIN", "CLIENT")
//                .requestMatchers(HttpMethod.PUT, "/api/reservations/**").hasAnyRole("ADMIN", "CLIENT")
//                .requestMatchers(HttpMethod.DELETE, "/api/reservations/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/api/payments/**").hasAnyRole("ADMIN", "STAFF", "CLIENT")
//                .requestMatchers(HttpMethod.POST, "/api/payments/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.PUT, "/api/payments/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/api/payments/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()  // Custom login page
//                .loginPage("/home") // Custom login page
                .loginProcessingUrl("/login") // Endpoint for processing login
                .defaultSuccessUrl("/home", true) // Redirect after login success                .permitAll()
                .and()
                .httpBasic();  // Enable HTTP Basic Authentication for API calls (optional)

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                if (username.equals("admin")) {
                    return User.withUsername("admin")
                            .password(passwordEncoder().encode("admin123"))
                            .roles("ADMIN")
                            .build();
                } else if (username.equals("staff")) {
                    return User.withUsername("staff")
                            .password(passwordEncoder().encode("staff123"))
                            .roles("STAFF")
                            .build();
                } else if (username.equals("client")) {
                    return User.withUsername("client")
                            .password(passwordEncoder().encode("client123"))
                            .roles("CLIENT")
                            .build();
                } else {
                    throw new UsernameNotFoundException("User not found: " + username);
                }
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt password encoder
    }
}
