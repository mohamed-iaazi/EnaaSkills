package com.medo.authmicroservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@Tag(name = "Authentication " , description = "Authentication api  ")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @Operation(description = "login api ")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }


    @Operation(description = "Register api ")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> createAccount(@RequestBody  CreateUserDTO createUserDTO) {
    return authService.createAccount(createUserDTO);
    }

}
