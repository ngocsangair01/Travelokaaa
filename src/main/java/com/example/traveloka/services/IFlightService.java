package com.example.traveloka.services;

import com.example.traveloka.daos.Flight;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@CrossOrigin(origins = "*")
public interface IFlightService {
    Set<Flight> findAllFlightByIdUser(Integer idUser, boolean status, boolean both);
}
