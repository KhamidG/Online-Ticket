package com.khamid.Online_Ticket.service;

import com.khamid.Online_Ticket.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    String addMovie(MovieDto dto);

    List<MovieDto> getAllMovies();

    MovieDto findMovieByName(MovieDto dto);
}
