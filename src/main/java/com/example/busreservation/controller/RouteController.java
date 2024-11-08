package com.example.busreservation.controller;

import com.example.busreservation.entity.Route;
import com.example.busreservation.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id);
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeService.createRoute(route);
    }

    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable Long id, @RequestBody Route route) {
        return routeService.updateRoute(id, route);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
    }
}
