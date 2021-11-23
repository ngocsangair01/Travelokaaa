package com.example.traveloka.repositories;

import com.example.traveloka.daos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
    Optional<User> findByIdUser(Integer id);
    User findByAccount(String account);
    User deleteUsersByIdUser(Integer id);
}
