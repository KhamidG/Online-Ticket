package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.dto.HallDto;
import com.khamid.Online_Ticket.entity.HallEntity;
import com.khamid.Online_Ticket.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hall")
public class HallController {
    @Autowired
    HallService service;

    @PostMapping("/add")
    private ResponseEntity<String> addNewHall(@RequestBody HallDto dto) {
        return ResponseEntity.ok(service.createHall(dto));
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<HallEntity>> getAllHalls() {
        return ResponseEntity.ok(service.getAllHalls());
    }
}
