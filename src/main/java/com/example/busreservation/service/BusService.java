package com.example.busreservation.service;

import com.example.busreservation.entity.Bus;
import com.example.busreservation.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    // Get all buses
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Get bus by id
    public Bus getBusById(Long id) {
        Optional<Bus> bus = busRepository.findById(id);
        return bus.orElse(null);
    }

    // Create a new bus
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    // Update an existing bus
    public Bus updateBus(Long id, Bus bus) {
        if (busRepository.existsById(id)) {
            bus.setId(id);
            return busRepository.save(bus);
        }
        return null;
    }

    // Delete a bus
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }
}
