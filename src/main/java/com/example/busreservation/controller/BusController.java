package com.example.busreservation.controller;

import com.example.busreservation.entity.Bus;
import com.example.busreservation.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable Long id) {
        return busService.getBusById(id);
    }

    @PostMapping
    public Bus createBus(@RequestBody Bus bus) {
        return busService.createBus(bus);
    }

    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        return busService.updateBus(id, bus);
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
    }
}
