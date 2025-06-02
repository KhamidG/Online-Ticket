package com.khamid.Online_Ticket.service;

import com.khamid.Online_Ticket.dto.MovieDto;
import com.khamid.Online_Ticket.entity.MovieEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    String addMovie(MovieDto dto);

    List<MovieEntity> getAllMovies();

    MovieDto findMovieByTitle(String title);
}
