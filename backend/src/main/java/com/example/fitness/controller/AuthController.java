package com.example.fitness.controller;
import com.example.fitness.dto.*;
import com.example.fitness.entity.*;
import com.example.fitness.repository.UserRepository;
import com.example.fitness.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") @CrossOrigin(origins="http://localhost:5173")
public class AuthController {
 private final UserRepository repo; private final PasswordEncoder encoder; private final AuthenticationManager auth; private final JwtService jwt;
 public AuthController(UserRepository r,PasswordEncoder e,AuthenticationManager a,JwtService j){repo=r;encoder=e;auth=a;jwt=j;}
 @PostMapping("/register") public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest r){
  if(repo.existsByEmail(r.email())) return ResponseEntity.badRequest().body("Email already registered");
  var u=repo.save(User.builder().name(r.name()).email(r.email()).password(encoder.encode(r.password())).role(Role.USER).build());
  return ResponseEntity.ok(new AuthResponse(jwt.generate(u.getEmail()),u.getName(),u.getEmail()));
 }
 @PostMapping("/login") public AuthResponse login(@Valid @RequestBody AuthRequest r){
  auth.authenticate(new UsernamePasswordAuthenticationToken(r.email(),r.password()));
  var u=repo.findByEmail(r.email()).orElseThrow();
  return new AuthResponse(jwt.generate(u.getEmail()),u.getName(),u.getEmail());
 }
}