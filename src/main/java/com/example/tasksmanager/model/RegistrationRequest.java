package com.example.tasksmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class RegistrationRequest {

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String confirmPassword;
}
