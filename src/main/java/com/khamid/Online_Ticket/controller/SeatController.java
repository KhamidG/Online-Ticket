package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.entity.SeatEntity;
import com.khamid.Online_Ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seat")
public class SeatController {
    @Autowired
    SeatService service;

    @GetMapping("/all")
    private ResponseEntity<List<SeatEntity>> getAllSeats() {
        return ResponseEntity.ok(service.getAllSeats());
    }


    @GetMapping("/byId/{id}")
    private ResponseEntity<Optional<SeatEntity>> getSeatById(@PathVariable("id") Long id) {
        return ResponseEntity. ok(service.getSeatById(id));
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookSeat(@RequestParam Long seatId, @RequestParam Long hallId) {
        String result = service.bookSeat(seatId, hallId);
        return ResponseEntity.ok(result);
    }
}

