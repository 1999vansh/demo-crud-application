package com.vansh.crudDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//Class for implementing Spring Security for our application
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

//    @Override
//    // Method to define user or list of user that are allowed for Authentication
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER")
//                .and()
//                .withUser("vansh")
//                .password("vansh123")
//                .roles("ADMIN");
//    }
//
//    // Method to define how Password will be stored
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    //Method to define which user can access which API (Authorization)
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
////                .antMatchers("/courses/").hasRole("USER")
////                .antMatchers("/courses/{id}").hasAnyRole("USER","ADMIN")
////                .antMatchers("/courses/{id}").permitAll()
//                .antMatchers("/courses/**").permitAll()
//                .and().formLogin();
//    }
}
