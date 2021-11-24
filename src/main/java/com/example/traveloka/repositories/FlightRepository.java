package com.example.traveloka.repositories;

import com.example.traveloka.daos.Flight;
import com.example.traveloka.daos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {
    Optional<Flight> findByIdFlight(Integer id);
    List<Flight> findAllByFromWhen(String fromWhen);
    List<Flight> findAllByFromWhere(String fromWhere);
    List<Flight> findAllByClassSeat(String classSeat);
    List<Flight> findAllByClassSeatAndFromWhereAndToWhere(String classSeat, String fromWhere,String toWhere);
    List<Flight> findAllByUsers(User user);
}
