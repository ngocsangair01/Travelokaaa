package com.example.traveloka.repositories;

import com.example.traveloka.daos.ToAirport;
import com.example.traveloka.daos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToAirportRepository extends JpaRepository<ToAirport, Integer> {
     ToAirport findByIdAirport(Integer id);
     List<ToAirport> findAllByFromWhereAndToWhere(String fromWhere, String toWhere);
     List<ToAirport> findAllByUsers(User user);
}
