package com.example.busreservation.service;

import com.example.busreservation.entity.Route;
import com.example.busreservation.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    // Get all routes
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    // Get route by id
    public Route getRouteById(Long id) {
        Optional<Route> route = routeRepository.findById(id);
        return route.orElse(null);
    }

    // Create a new route
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    // Update an existing route
    public Route updateRoute(Long id, Route route) {
        if (routeRepository.existsById(id)) {
            route.setId(id);
            return routeRepository.save(route);
        }
        return null;
    }

    // Delete a route
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
