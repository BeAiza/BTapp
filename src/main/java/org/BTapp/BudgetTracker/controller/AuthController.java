package org.BTapp.BudgetTracker.controller;

import org.BTapp.BudgetTracker.model.data.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Validate user credentials
        // ...

        // Generate JWT token
        String token = jwtTokenUtil.generateToken(loginRequest.getUsername());
        return token;
    }
}