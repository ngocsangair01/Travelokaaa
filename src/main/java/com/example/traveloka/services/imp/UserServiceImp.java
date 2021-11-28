package com.example.traveloka.services.imp;

import com.example.traveloka.daos.Flight;
import com.example.traveloka.daos.ToAirport;
import com.example.traveloka.daos.User;
import com.example.traveloka.repositories.FlightRepository;
import com.example.traveloka.repositories.ToAirportRepository;
import com.example.traveloka.repositories.UserRepository;
import com.example.traveloka.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@Service
@CrossOrigin(origins = "*")
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    ToAirportRepository toAirportRepository;

    @Override
    public String createFlightScheduleByIdUserAndIdFlight(Integer idUser, Integer idFlight) {
        try {
            Flight flight = flightRepository.getById(idFlight);
            User user = userRepository.getById(idUser);

            Set<Flight> flights = user.getFlights();
            flights.add(flight);

            Set<User> users = flight.getUsers();
            flights.add(flight);

            flight.setUsers(users);
            user.setFlights(flights);

            userRepository.save(user);
            flightRepository.save(flight);
        } catch (Exception e) {
            return "Đăng kí bay không thành công";
        }
        return "Đăng kí chuyến bay thành công";
    }

    @Override
    public String deleteFlightScheduleByIdUserAndIdFlight(Integer idUser, Integer idFlight) {
        try{
            Flight flight = flightRepository.findByIdFlight(idFlight).get();
            User user = userRepository.findByIdUser(idUser).get();
            System.out.println(flight);
            System.out.println(user);

            List<Flight> flights = new ArrayList<>(user.getFlights());
            List<User> users = new ArrayList<>(flight.getUsers());


            for(int i=0; i<flights.size(); i++) {
                if(flights.get(i).getIdFlight() == flight.getIdFlight()) {
                    flights.remove(i);
                    break;
                }
            }
            for(int i=0; i<users.size(); i++) {
                if(users.get(i).getIdUser() == user.getIdUser()) {
                    users.remove(i);
                    break;
                }
            }

            Set<User> setU = new HashSet<>(users);
            Set<Flight> setF = new HashSet<>(flights);

            user.setFlights(setF);
            flight.setUsers(setU);

            userRepository.save(user);
            flightRepository.save(flight);
        } catch (Exception e) {
            return "Huỷ không thành công ";
        }
        return "Huỷ thành công ";
    }

    @Override
    public String createCarScheduleByIdUserAndIdCar(Integer idUser, Integer idToAirport) {
        try {
            ToAirport toAirport = toAirportRepository.getById(idToAirport);
            User user = userRepository.getById(idUser);

            Set<ToAirport> toAirports = user.getToAirports();
            toAirports.add(toAirport);

            Set<User> users = toAirport.getUsers();
            toAirports.add(toAirport);

            toAirport.setUsers(users);
            user.setToAirports(toAirports);

            userRepository.save(user);
            toAirportRepository.save(toAirport);
        } catch (Exception e) {
            return "Đăng kí xe đến sân bay thành công";
        }
        return "Đăng kí xe đến sân bay không thành công";
    }

    @Override
    public String deleteCarScheduleByIdUserAndIdCar(Integer idUser, Integer idToAirport) {
        try{
            ToAirport toAirport = toAirportRepository.findById(idToAirport).get();
            User user = userRepository.findByIdUser(idUser).get();

            List<ToAirport> toAirports = new ArrayList<>(user.getToAirports());
            List<User> users = new ArrayList<>(toAirport.getUsers());


            for(int i=0; i<toAirports.size(); i++) {
                if(toAirports.get(i).getIdAirport() == toAirport.getIdAirport()) {
                    toAirports.remove(i);
                    break;
                }
            }
            for(int i=0; i<users.size(); i++) {
                if(users.get(i).getIdUser() == user.getIdUser()) {
                    users.remove(i);
                    break;
                }
            }

            Set<User> setU = new HashSet<>(users);
            Set<ToAirport> setT = new HashSet<>(toAirports);

            user.setToAirports(setT);
            toAirport.setUsers(setU);

            userRepository.save(user);
            toAirportRepository.save(toAirport);
        } catch (Exception e) {
            return "Huỷ không thành công ";
        }
        return "Huỷ thành công ";
    }
//@Override
//    public String deleteFlightScheduleByIdUserAndIdFlight(Integer idUser, Integer idFlight) {
//        try{
//            Flight flight = flightRepository.findByIdFlight(idFlight).get();
//            User user = userRepository.findByIdUser(idUser).get();
//            System.out.println(flight);
//            Set<Flight> flights = user.getFlights();
//            Iterator iterator = flights.iterator();
//            Set<Flight> flightSet = new HashSet<>();
//            while (iterator.hasNext()){
//                Flight flight1 = (Flight) iterator.next();
//                if (flight.equals(flight1)){
//                    flightSet.add(flight1);
//
//                }
//                System.out.println(flight1);
//            }
//
//            Set<User> users = flight.getUsers();
//            Iterator iterator1 = users.iterator();
//            Set<User> flightSet1 = new HashSet<>();
//            while (iterator1.hasNext()){
//                User user1 = (User) iterator1.next();
//                if (!user.equals(user1)){
//                    flightSet1.add(user);
//                }
//            }
//
//            user.setFlights(flightSet);
//            flight.setUsers(flightSet1);
////            Set<Flight> demo = new HashSet<>();
////            demo.add(new Flight(10,"Bắc Giang","Bắc Ninh","14h00","14h01","thường",10000000));
////            user.setFlights(demo);
//            userRepository.save(user);
//            flightRepository.save(flight);
//        } catch (Exception e) {
//            return "Huỷ không thành công ";
//        }
//        return "Huỷ thành công ";
//    }

}
