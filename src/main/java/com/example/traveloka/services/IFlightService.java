package com.example.traveloka.services;

import com.example.traveloka.daos.Flight;

import java.util.Set;

public interface IFlightService {
    Set<Flight> findAllFlightByIdUser(Integer idUser, boolean status, boolean both);
}
