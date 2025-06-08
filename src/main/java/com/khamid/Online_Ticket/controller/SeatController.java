package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.entity.SeatEntity;
import com.khamid.Online_Ticket.service.SeatService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get all seats list")
    @GetMapping("/all")
    private ResponseEntity<List<SeatEntity>> getAllSeats() {
        return ResponseEntity.ok(service.getAllSeats());
    }

    @Operation(summary = "Get seat by id")
    @GetMapping("/byId/{id}")
    private ResponseEntity<Optional<SeatEntity>> getSeatById(@PathVariable("id") Long id) {
        return ResponseEntity. ok(service.getSeatById(id));
    }

    @Operation(summary = "Book seat")
    @PostMapping("/book")
    public ResponseEntity<String> bookSeat(@RequestParam Long seatId, @RequestParam Long hallId) {
        return ResponseEntity.ok(service.bookSeat(seatId, hallId));
    }

    @Operation(summary = "Cancel booking")
    @PostMapping("/cancel")
    public ResponseEntity<String> cancelSeat(@RequestParam Long seatId, @RequestParam Long hallId){
        return ResponseEntity.ok(service.cancelBooking(seatId, hallId));
    }
}

