package com.khamid.Online_Ticket.serviceImpl;

import com.khamid.Online_Ticket.dto.MovieDto;
import com.khamid.Online_Ticket.entity.MovieEntity;
import com.khamid.Online_Ticket.exps.BadException;
import com.khamid.Online_Ticket.mapper.MovieMapper;
import com.khamid.Online_Ticket.repository.MovieRepository;
import com.khamid.Online_Ticket.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository repository;
    @Autowired
    MovieMapper mapper;

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
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto findMovieByTitle(String title) {
        MovieEntity movie = repository.findByTitle(title)
                .orElseThrow(() -> new BadException("Movie not found"));

        return mapper.toDto(movie);
    }
}
