package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.dto.MovieDto;
import com.khamid.Online_Ticket.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    private ResponseEntity<String> addNewMovie(@RequestBody MovieDto dto) {
        return ResponseEntity.ok(movieService.addMovie(dto));
    }
}
