package com.example.busreservation.repository;

import com.example.busreservation.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    // Custom query methods can be defined here
}
