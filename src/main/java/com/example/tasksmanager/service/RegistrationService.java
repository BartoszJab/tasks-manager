package com.example.tasksmanager.service;

import com.example.tasksmanager.model.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final JpaUserDetailsService userDetailsService;

    public String register(RegistrationRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();

        if (username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            throw new IllegalStateException("Fields must not be empty");
        }

        if (!password.equals(confirmPassword)) {
            throw new IllegalStateException("Password does not match confirm password");
        }

        return userDetailsService.registerUser(request).getUsername() + " created successfully";
    }
}
