package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.dto.HallDto;
import com.khamid.Online_Ticket.service.HallService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hall")
public class HallController {

    @Autowired
    HallService service;

    @Operation(summary = "Add new hall")
    @PostMapping("/add")
    private ResponseEntity<String> create(@RequestBody HallDto dto){
        return ResponseEntity.ok(service.createHall(dto));
    }
}
