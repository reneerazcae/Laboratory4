package com.example.busreservation.repository;

import com.example.busreservation.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    // Custom query methods can be defined here
}
