package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.dto.MovieDto;
import com.khamid.Online_Ticket.entity.MovieEntity;
import com.khamid.Online_Ticket.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Operation(summary = "Add new Movie")
    @PostMapping("/add")
    public ResponseEntity<String> addNewMovie(@RequestBody MovieDto dto) {
        return ResponseEntity.ok(movieService.addMovie(dto));
    }

    @Operation(summary = "Show all movies")
    @GetMapping("/all")
    public ResponseEntity<List<MovieEntity>> allMoviesList() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @Operation(summary = "Find by movie title")
    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<MovieDto> findMovieByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieService.findMovieByTitle(title));
    }
}
