package com.example.busreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/client/reservations")
    public String makeReservation() {
        return "client/reservations"; // Client page to make reservations
    }

    @GetMapping("/client/my-reservations")
    public String viewMyReservations() {
        return "client/my-reservations"; // Client page to view their reservations
    }

    @GetMapping("/client/payments")
    public String viewPayments() {
        return "client/payments"; // Client page to view their payments
    }
}
