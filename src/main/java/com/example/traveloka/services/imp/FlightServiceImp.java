package com.example.traveloka.services.imp;

import com.example.traveloka.daos.Flight;
import com.example.traveloka.services.IFlightService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Service
@CrossOrigin(origins = "*")
public class FlightServiceImp implements IFlightService {
    @Override
    public Set<Flight> findAllFlightByIdUser(Integer idUser, boolean status, boolean both) {
        return null;
    }
}
