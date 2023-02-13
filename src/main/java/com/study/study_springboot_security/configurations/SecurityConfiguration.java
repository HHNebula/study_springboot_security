package com.study.study_springboot_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // _csrf protection disabled
        httpSecurity.csrf().disable();

        // 권한에 대한 부분 : url & roles : user url & roles : 이 URL 은 이 Role 이야
        httpSecurity.authorizeRequests()
                // .antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                // .antMatchers("/").authenticated() // 로그인 여부만 판단.
                // .antMatchers("/admin").access("hasRole('ROLE_ADMIN')") // 권한 판단
                .antMatchers("/user").authenticated() // Admin 만 로그인 해야 함!
                .antMatchers("/manager/*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") // Manager + Admin
                                                                                                      // 권한
                .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')") // Admin 권한 만
                .anyRequest().permitAll(); // 설정한 URL 이외는 접근 가능.

        // 로그인에 대한 부분 : 로그인 루틴
        httpSecurity.formLogin().loginPage("/loginForm")
                .failureUrl("/loginForm?fail=true")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/");

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder encoderPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}