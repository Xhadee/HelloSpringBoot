package sn.edu.ugb.ipsl.git.HelloSpringBoot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sn.edu.ugb.ipsl.git.HelloSpringBoot.filters.IpslAuthFilters;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class IpslSecurityConfig {

    @Autowired
    private IpslAuthFilters ipslAuthFilters;

    @Bean

    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        authorizeRequest->
                                authorizeRequest
                                        .requestMatchers("/auth/**").permitAll()
                                        .requestMatchers("/departements").hasRole("ADMIN")
                                        .anyRequest().authenticated()
                )
                //independance des requetes
                .sessionManagement(sessionManagement->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(ipslAuthFilters, UsernamePasswordAuthenticationFilter.class);
               return http.build();
    }
}
