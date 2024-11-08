package com.example.busreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

//    @GetMapping("/home")
//    public String Buses() {
//        return "home"; // Admin-specific page for bus management
//    }

    @GetMapping("/admin/buses")
    public String manageBuses() {
        return "admin/buses"; // Admin-specific page for bus management
    }

    @GetMapping("/admin/routes")
    public String manageRoutes() {
        return "admin/routes"; // Admin-specific page for route management
    }

    @GetMapping("/admin/reservations")
    public String manageReservations() {
        return "admin/reservations"; // Admin-specific page for managing reservations
    }

    @GetMapping("/admin/payments")
    public String managePayments() {
        return "admin/payments"; // Admin-specific page for managing payments
    }
}
