package org.chg.springsecurity_layered.user.infrastructure;

import org.chg.springsecurity_layered.user.application.UserFacade;
import org.chg.springsecurity_layered.user.domain.UserInfoReader;
import org.chg.springsecurity_layered.user.presentation.UserAuth;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;


import java.util.Map;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    private final HandlerMappingIntrospector handlerMappingIntrospector;

    public SecurityConfig(HandlerMappingIntrospector handlerMappingIntrospector) {
        this.handlerMappingIntrospector = handlerMappingIntrospector;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers(new MvcRequestMatcher(handlerMappingIntrospector, "/*")).permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(withDefaults())
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .csrf(csrf -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/user/**")))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserFacade UserFacade){
        return username -> UserFacade
                .findById(username)
                .map(user -> UserAuth.builder()
                        .username(user.getUserId())
                        .password(user.getPassword())
                        .build()
                )
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다. - username : " + username));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCrypt 인코더 사용
    }
}