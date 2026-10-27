package com.example.fitness.security;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
 private final JwtService jwt; private final CustomUserDetailsService uds;
 public JwtFilter(JwtService jwt,CustomUserDetailsService uds){this.jwt=jwt;this.uds=uds;}
 protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws ServletException,IOException{
  String h=req.getHeader("Authorization");
  if(h!=null&&h.startsWith("Bearer ")){
   String t=h.substring(7);
   if(jwt.valid(t)&&SecurityContextHolder.getContext().getAuthentication()==null){
    UserDetails u=uds.loadUserByUsername(jwt.email(t));
    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(u,null,u.getAuthorities()));
   }
  }
  chain.doFilter(req,res);
 }
}