package com.medo.authmicroservice.service.impl;

import com.medo.authmicroservice.dto.AuthRequest;
import com.medo.authmicroservice.dto.AuthResponse;
import com.medo.authmicroservice.dto.CreateUserDTO;
import com.medo.authmicroservice.model.User;
import com.medo.authmicroservice.repository.AuthRepository;
import com.medo.authmicroservice.security.JwtService;
import com.medo.authmicroservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public ResponseEntity<AuthResponse> createAccount(CreateUserDTO request) {
        if (authRepository.existsByUsername(request.getUsername()) || authRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(new AuthResponse("user already exist ", null, null));
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        authRepository.save(user);

        String jwt = jwtService.generateJwtToken(request.getEmail());

        return ResponseEntity.ok(AuthResponse.builder()
                .token(jwt)
                .username(request.getUsername())
                .message("Created account successfully")
                .build()
        );
    }

    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateJwtToken(authRequest.getEmail());
        User user = authRepository.findByEmail(authRequest.getEmail()).orElseThrow();


        return ResponseEntity.ok(AuthResponse.builder()
                .token(jwt)
                .username(user.getUsername())
                .message("login successfully")
                .build());
    }
}
