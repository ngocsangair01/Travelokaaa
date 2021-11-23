package com.example.traveloka.services;

public interface IUserService {
    String createFlightScheduleByIdUserAndIdFlight(Integer idUser, Integer idFlight);
    String deleteFlightScheduleByIdUserAndIdFlight(Integer idUser, Integer idFlight);
    String createCarScheduleByIdUserAndIdCar(Integer idUser, Integer idToAirport);
    String deleteCarScheduleByIdUserAndIdCar(Integer idUser, Integer idToAirport);
}
