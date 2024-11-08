package com.example.busreservation.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        if (authentication == null) {
            return "redirect:/login";
        }

        String role = ((User) authentication.getPrincipal()).getAuthorities().toString();

        if (role.contains("ADMIN")) {
            return "adminDashboard";  // Redirect to Admin Dashboard view
        } else if (role.contains("STAFF")) {
            return "staffDashboard";  // Redirect to Staff Dashboard view
        } else if (role.contains("CLIENT")) {
            return "clientDashboard"; // Redirect to Client Dashboard view
        } else {
            return "accessDenied"; // A default access denied page
        }
    }
}
