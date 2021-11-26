package com.example.traveloka.controllers;

import com.example.traveloka.base.BaseController;
import com.example.traveloka.base.ResponseFlight;
import com.example.traveloka.daos.Flight;
import com.example.traveloka.dtos.FindFlightDTO;
import com.example.traveloka.dtos.FlightDTO;
import com.example.traveloka.exceptions.DuplicateException;
import com.example.traveloka.exceptions.NotFoundException;
import com.example.traveloka.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public ResponseEntity<?> findAllFlight() {
        return ResponseEntity.status(200).body(flightRepository.findAll());
    }
    @GetMapping("/{idFlight}")
    public ResponseEntity<?> findFlightById(@PathVariable("idFlight")Integer idFlight) {
        Optional<Flight> flight = flightRepository.findByIdFlight(idFlight);
        if (flight.isEmpty()) {
            throw new NotFoundException("Không có chuyến bay nào ");
        }
        return ResponseEntity.status(200).body(new ResponseFlight(200,"Các chuyến bay hiện có",flight.get()));
    }

    @PostMapping("/createflight")
    public ResponseEntity<?> createFlight(@RequestBody FlightDTO flightDTO) {
//        Flight oldFlight = flightRepository.findByFromWhen(flightDTO.getFromWhen());
        Flight flight = new Flight();
        flight.setFromWhere(flightDTO.getFromWhere());
        flight.setToWhere(flightDTO.getToWhere());
        flight.setFromWhen(flightDTO.getFromWhen());
        flight.setToWhen(flightDTO.getToWhen());
        flight.setClassSeat(flightDTO.getClassSeat());
        flight.setPrice(flightDTO.getPrice());
        Flight newFlight = flightRepository.save(flight);
        return ResponseEntity.status(201).body(new ResponseFlight(200,"Tạo chuyến bay thành công",newFlight));
    }
    @DeleteMapping("/{idFlight}")
    public ResponseEntity<?> deleteFlightById(@PathVariable(name = "idFlight")Integer idFlight) {
        Optional<Flight> flight = flightRepository.findByIdFlight(idFlight);
        if (flight.isEmpty()) {
            throw new NotFoundException("Chuyến bay không tồn tại ");
        }
        flightRepository.deleteById(idFlight);
        return ResponseEntity.status(200).body(new ResponseFlight(200,"xoá thành công",flight.get()));
    }

    @GetMapping("/fromwhen")
    public ResponseEntity<?> findAllFlightByFromWhen(@RequestParam("fromWhen")String fromWhen){
        List<Flight> flights = flightRepository.findAllByFromWhen(fromWhen);
        if (flights == null) {
            throw new NotFoundException("Không có chuyến bay nào ");
        }
        return ResponseEntity.status(201).body(flights);
    }

    @GetMapping("/fromwhere")
    public ResponseEntity<?> findAllFlightByFromWhere(@RequestParam("fromWhere")String fromWhere){
        List<Flight> flights = flightRepository.findAllByFromWhere(fromWhere);
        if (flights == null) {
            throw new NotFoundException("Không có chuyến bay nào ");
        }
        return ResponseEntity.status(201).body(new BaseController(200, "Lấy danh sách chuyến bay thành công", flights));
    }

    @GetMapping("/classseat")
    public ResponseEntity<?> findAllFlightByClassSeat(@RequestParam("classSeat")String classSeat){
        List<Flight> flights = flightRepository.findAllByClassSeat(classSeat);
        if (flights == null) {
            throw new NotFoundException("Chuyến bay không tồn tại");
        }
        return ResponseEntity.status(201).body(flights);
    }
    @PostMapping("/findtravel")  //requestBody CHuyenBAyDTO dto {fromWehre, towhere, classSeat}
    public ResponseEntity<?> findAllFlightByAnyThings(@RequestBody FindFlightDTO dto) {
        List<Flight> flights = flightRepository.findAllByClassSeatAndFromWhereAndToWhere(dto.getClassSeat(),dto.getFromWhere(),dto.getToWhere()); //dtpget
        if (flights.size() == 0) {
            throw new NotFoundException("Không tìm thấy chuyến bay");
        }
        return ResponseEntity.status(201).body(new BaseController(200,"Các chuyến bay thoả mãn",flights));
    }

}
