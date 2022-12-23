package com.example.tasksmanager.controller;

import com.example.tasksmanager.dto.UserDto;
import com.example.tasksmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    List<UserDto> getUsers() {
        return userService.getUsers().stream().map(u -> UserDto.builder()
                .id(u.getId())
                .username(u.getUsername())
                .build()
        ).collect(Collectors.toList());
    }
}
