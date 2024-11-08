package com.example.busreservation.service;

import com.example.busreservation.entity.Passenger;
import com.example.busreservation.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    // Get all passengers
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // Get passenger by id
    public Passenger getPassengerById(Long id) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        return passenger.orElse(null);
    }

    // Create a new passenger
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // Update an existing passenger
    public Passenger updatePassenger(Long id, Passenger passenger) {
        if (passengerRepository.existsById(id)) {
            passenger.setId(id);
            return passengerRepository.save(passenger);
        }
        return null;
    }

    // Delete a passenger
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
