package com.khamid.Online_Ticket.mapper;

import com.khamid.Online_Ticket.dto.MovieDto;
import com.khamid.Online_Ticket.entity.MovieEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDto toDto(MovieEntity entity);
    MovieEntity toEntity(MovieDto dto);
}
