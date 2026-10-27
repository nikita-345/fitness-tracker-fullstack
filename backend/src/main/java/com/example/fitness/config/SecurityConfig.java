package com.example.fitness.config;
import com.example.fitness.security.JwtFilter;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean AuthenticationProvider provider(UserDetailsService uds,PasswordEncoder pe){var p=new DaoAuthenticationProvider();p.setUserDetailsService(uds);p.setPasswordEncoder(pe);return p;}
 @Bean AuthenticationManager manager(AuthenticationConfiguration c)throws Exception{return c.getAuthenticationManager();}
 @Bean SecurityFilterChain chain(HttpSecurity h,JwtFilter f)throws Exception{
  h.csrf(c->c.disable()).cors(c->{}).sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   .authorizeHttpRequests(a->a.requestMatchers("/api/auth/**","/swagger-ui/**","/v3/api-docs/**").permitAll().anyRequest().authenticated())
   .addFilterBefore(f,UsernamePasswordAuthenticationFilter.class);
  return h.build();
 }
}