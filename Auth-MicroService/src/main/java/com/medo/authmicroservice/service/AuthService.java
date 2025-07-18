package com.medo.authmicroservice.service;

import com.medo.authmicroservice.dto.AuthRequest;
import com.medo.authmicroservice.dto.AuthResponse;
import com.medo.authmicroservice.dto.CreateUserDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    public ResponseEntity<AuthResponse> createAccount(CreateUserDTO userDTO);
    public ResponseEntity<AuthResponse>  login(AuthRequest authRequest);

}
