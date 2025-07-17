package com.medo.authmicroservice.service;

import org.springframework.http.ResponseEntity;

public interface AuthService {
    public ResponseEntity<AuthResponse> createAccount(CreateUserDTO userDTO);
    public ResponseEntity<AuthResponse>  login(AuthRequest authRequest);

}
