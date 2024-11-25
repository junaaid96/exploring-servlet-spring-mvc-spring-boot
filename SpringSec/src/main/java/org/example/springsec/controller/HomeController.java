package org.example.springsec.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        return "This is home page. Session ID: " + request.getSession().getId();
    }
}
