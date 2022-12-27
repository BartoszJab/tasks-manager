package com.example.tasksmanager.controller;

import com.example.tasksmanager.model.RegistrationRequest;
import com.example.tasksmanager.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
