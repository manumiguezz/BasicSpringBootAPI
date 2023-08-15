package com.manumiguezz.crudapplication.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager UserDetailsManager() {

        UserDetails ramiro = User.builder()
                .username("ramiro")
                .password("{noop}examplepass")
                .roles("EMPLOYEE")
                .build();

        UserDetails matias = User.builder()
                .username("matias")
                .password("{noop}examplepass")
                .roles("EMPLOYEE", "TL")
                .build();

        UserDetails alejo = User.builder()
                .username("alejo")
                .password("{noop}examplepass")
                .roles("EMPLOYEE", "TL", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ramiro, matias, alejo);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("TL")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("TL")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
