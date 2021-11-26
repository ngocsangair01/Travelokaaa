package com.example.traveloka.controllers;

import com.example.traveloka.daos.Flight;
import com.example.traveloka.daos.ToAirport;
import com.example.traveloka.dtos.FindCarDTO;
import com.example.traveloka.dtos.ToAirportDTO;
import com.example.traveloka.exceptions.NotFoundException;
import com.example.traveloka.repositories.ToAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/toairport")
@CrossOrigin(origins = "*")
public class ToAirportController {
    @Autowired
    private ToAirportRepository toAirportRepository;

    @GetMapping
    public ResponseEntity<?> findAllToAirport() {
        return ResponseEntity.status(200).body(toAirportRepository.findAll());
    }
    @GetMapping("/{idToAirport}")
    public ResponseEntity<?> findToAirportById(@PathVariable("idToAirport")Integer idToAirport) {
        Optional<ToAirport> toAirport = toAirportRepository.findById(idToAirport);
        if (toAirport.isEmpty()) {
            throw new NotFoundException("Không tìm thấy xe nào ");
        }
        return ResponseEntity.status(200).body(toAirport.get());
    }
    @PostMapping("/createtoairport")
    public ResponseEntity<?> createToAirport(@RequestBody ToAirportDTO toAirportDTO) {
        ToAirport toAirport = new ToAirport();
        toAirport.setFromWhere(toAirportDTO.getFromWhere());
        toAirport.setToWhere(toAirportDTO.getToWhere());
        toAirport.setFromWhen(toAirportDTO.getFromWhen());
        toAirport.setToWhen(toAirportDTO.getToWhen());
        toAirport.setNumberOfSeat(toAirportDTO.getNumberOfSeat());
        toAirport.setAvatarCar(toAirportDTO.getAvatarCar());
        ToAirport newToAirport = toAirportRepository.save(toAirport);
        return ResponseEntity.status(201).body(newToAirport);
    }
    @DeleteMapping("/{idToAirport}")
    public ResponseEntity<?> deleteToAirport(@PathVariable(name = "idToAirport")Integer idToAirport) {
        Optional<ToAirport> toAirport = toAirportRepository.findById(idToAirport);
        if (toAirport.isEmpty()) {
            throw new NotFoundException("Không có xe nào ");
        }
        toAirportRepository.deleteById(idToAirport);
        return ResponseEntity.status(200).body("xoá thành công");
    }
    @PostMapping("/findtoairport")
    public ResponseEntity<?> findTheWayToAirport(@RequestBody FindCarDTO findCarDTO) {
        List<ToAirport> toAirports = toAirportRepository.findAllByFromWhereAndToWhere(findCarDTO.getFromWhere(), findCarDTO.getToWhere());
        if (toAirports == null) {
            throw new NotFoundException("Không tìm thấy xe đến sân bay");
        }
        return ResponseEntity.status(201).body(toAirports);
    }
    
}
