package com.example.traveloka.controllers;

import com.example.traveloka.repositories.FlightRepository;
import com.example.traveloka.repositories.UserRepository;
import com.example.traveloka.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carschedule")
public class CarScheduleController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @PostMapping("/register/{idUser}/{idFlight}")
    public ResponseEntity<?> createSchedule(@PathVariable("idUser")Integer idUser,
                                            @PathVariable("idToAirport")Integer idToAirport) {
        return ResponseEntity.status(201).body(userService.createCarScheduleByIdUserAndIdCar(idUser, idToAirport));
    }

    @DeleteMapping("/delete/{idUser}/{idFlight}")
    public ResponseEntity<?> deleteSchedule(@PathVariable("idUser")Integer idUser,
                                            @PathVariable("idToAirport")Integer idToAirport){
        return ResponseEntity.status(201).body(userService.deleteCarScheduleByIdUserAndIdCar(idUser, idToAirport));
    }
}
