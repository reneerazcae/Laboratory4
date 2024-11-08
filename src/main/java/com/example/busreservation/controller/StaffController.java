package com.example.busreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {


    @GetMapping("/staff/reservations")
    public String manageReservations() {
        return "staff/reservations"; // Staff page for managing reservations
    }


    @GetMapping("/staff/payments")
    public String viewPayments() {
        return "staff/payments"; // Staff page for viewing payments
    }
}
