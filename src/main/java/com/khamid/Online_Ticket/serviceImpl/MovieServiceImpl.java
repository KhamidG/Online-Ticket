package com.khamid.Online_Ticket.serviceImpl;

import com.khamid.Online_Ticket.dto.MovieDto;
import com.khamid.Online_Ticket.entity.MovieEntity;
import com.khamid.Online_Ticket.exps.BadException;
import com.khamid.Online_Ticket.repository.MovieRepository;
import com.khamid.Online_Ticket.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository repository;

    @Override
    public String addMovie(MovieDto dto) {
        MovieEntity entity = new MovieEntity();

        entity.setTitle(dto.getTitle());
        entity.setMovieType(dto.getMovieType());
        entity.setRate(dto.getRate());

        repository.save(entity);
        dto.setId(entity.getId());
        
        return "Successfully added";
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return List.of();
    }

    @Override
    public MovieDto findMovieByName(MovieDto dto) {
        return null;
    }
}
