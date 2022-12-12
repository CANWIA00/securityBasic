package com.canwia.securitybasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/v1/hello").hasRole("USER")
                .requestMatchers(HttpMethod.POST,"/v1/hello").hasRole("ADMIN")
                .and()
                .csrf().disable() // enabled csrf tokens
                .formLogin().disable(); //enabled html form

        return http.build();
    }
}
