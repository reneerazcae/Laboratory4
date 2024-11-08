package com.example.busreservation.service;

import com.example.busreservation.entity.Reservation;
import com.example.busreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Get reservation by id
    public Reservation getReservationById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    // Create a new reservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Update an existing reservation
    public Reservation updateReservation(Long id, Reservation reservation) {
        if (reservationRepository.existsById(id)) {
            reservation.setId(id);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    // Delete a reservation
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
