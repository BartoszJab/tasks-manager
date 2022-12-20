package com.example.tasksmanager.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            return "Not found error";
        } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "Internal server error";
        } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
            return "Unauthorized";
        } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
            return "Bad request";
        } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
            return "Forbidden";
        }

        return statusCode.toString();
    }
}
