package com.example.traveloka.controllers;

import com.example.traveloka.base.BaseController;
import com.example.traveloka.daos.User;
import com.example.traveloka.repositories.FlightRepository;
import com.example.traveloka.repositories.UserRepository;
import com.example.traveloka.services.IFlightService;
import com.example.traveloka.services.IUserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flightschedule")
@CrossOrigin(origins = "*")
public class FlightScheduleController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFlightService flightService;

    @PostMapping("/register/{idUser}/{idFlight}")
    public ResponseEntity<?> createSchedule(@PathVariable("idUser")Integer idUser,
                                            @PathVariable("idFlight")Integer idFlight) {
        return ResponseEntity.status(201).body(userService.createFlightScheduleByIdUserAndIdFlight(idUser, idFlight));
    }
    @DeleteMapping("/delete/{idUser}/{idFlight}")
    public ResponseEntity<?> deleteSchedule(@PathVariable("idUser")Integer idUser,
                                            @PathVariable("idFlight")Integer idFlight) {
        return ResponseEntity.status(201).body(userService.deleteFlightScheduleByIdUserAndIdFlight(idUser, idFlight));
    }
    @GetMapping("/{idUser}")
    public ResponseEntity<?> findScheduleByIdUser(@PathVariable("idUser")Integer idUser) {
        return ResponseEntity.status(201).body(new BaseController(201,"Danh sách các chuyến bay",flightRepository.findAllByUsers(userRepository.findById(idUser).get())));
    }
}
