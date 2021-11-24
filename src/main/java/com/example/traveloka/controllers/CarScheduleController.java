package com.example.traveloka.controllers;

import com.example.traveloka.base.BaseController;
import com.example.traveloka.repositories.FlightRepository;
import com.example.traveloka.repositories.ToAirportRepository;
import com.example.traveloka.repositories.UserRepository;
import com.example.traveloka.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carschedule")
@CrossOrigin(origins = "*")
public class CarScheduleController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private ToAirportRepository toAirportRepository;

    @PostMapping("/register/{idUser}/{idToAirport}")
    public ResponseEntity<?> createSchedule(@PathVariable("idUser")Integer idUser,
                                            @PathVariable("idToAirport")Integer idToAirport) {
        return ResponseEntity.status(201).body(userService.createCarScheduleByIdUserAndIdCar(idUser, idToAirport));
    }

    @DeleteMapping("/delete/{idUser}/{idToAirport}")
    public ResponseEntity<?> deleteSchedule(@PathVariable("idUser")Integer idUser,
                                            @PathVariable("idToAirport")Integer idToAirport){
        return ResponseEntity.status(201).body(userService.deleteCarScheduleByIdUserAndIdCar(idUser, idToAirport));
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<?> findScheduleByIdUser(@PathVariable("idUser")Integer idUser) {
        return ResponseEntity.status(201).body(new BaseController(201,"Danh sách các chuyến bay",toAirportRepository.findAllByUsers(userRepository.findById(idUser).get())));
    }
}
