package com.example.traveloka.utils;

import com.example.traveloka.daos.Flight;
import com.example.traveloka.daos.ToAirport;
import com.example.traveloka.daos.User;
import com.example.traveloka.dtos.FlightDTO;
import com.example.traveloka.dtos.ToAirportDTO;
import com.example.traveloka.dtos.UserDTO;

public class ConvertObject {
    public static void fromUserDTOToUser(UserDTO userDTO, User user){
        if(userDTO.getAccount() != null) {
            user.setAccount(userDTO.getAccount());
        }
        if(userDTO.getPassword() != null) {
            user.setPassword(userDTO.getPassword());
        }
        if(userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if(userDTO.getAge() != null) {
            user.setAge(userDTO.getAge());
        }
        if(userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if(userDTO.getAddress() != null) {
            user.setAddress(userDTO.getAddress());
        }
        if(userDTO.getSex() != null) {
            user.setSex(userDTO.getSex());
        }
        if(userDTO.getBirthday() != null) {
            user.setBirthday(userDTO.getBirthday());
        }
    }
    public static void fromFLightDTOTOoFlight(FlightDTO flightDTO, Flight flight) {
        if (flightDTO.getFromWhere() != null) {
            flight.setFromWhere(flightDTO.getFromWhere());
        }
        if (flightDTO.getToWhere() != null) {
            flight.setToWhere(flightDTO.getToWhere());
        }
        if (flightDTO.getFromWhen() != null) {
            flight.setFromWhen(flightDTO.getFromWhen());
        }
        if (flightDTO.getToWhen() != null) {
            flight.setToWhen(flightDTO.getToWhen());
        }
        if (flightDTO.getClassSeat() != null) {
            flight.setClassSeat(flightDTO.getClassSeat());
        }
        if (flightDTO.getPrice() != null) {
            flight.setPrice(flightDTO.getPrice());
        }
    }
    public static void fromToAirportDTOToToAirport(ToAirportDTO toAirportDTO, ToAirport toAirport) {
        if (toAirportDTO.getFromWhere() != null) {
            toAirport.setFromWhere(toAirportDTO.getFromWhere());
        }
        if (toAirportDTO.getToWhere() != null) {
            toAirport.setToWhere(toAirportDTO.getToWhere());
        }
        if (toAirportDTO.getFromWhen() != null) {
            toAirport.setFromWhen(toAirportDTO.getFromWhen());
        }
        if (toAirportDTO.getToWhen() != null) {
            toAirport.setToWhen(toAirportDTO.getToWhen());
        }
        if (toAirportDTO.getNumberOfSeat() != null) {
            toAirport.setNumberOfSeat(toAirportDTO.getNumberOfSeat());
        }
        if (toAirportDTO.getAvatarCar() != null) {
            toAirport.setAvatarCar(toAirportDTO.getAvatarCar());
        }
    }
}
