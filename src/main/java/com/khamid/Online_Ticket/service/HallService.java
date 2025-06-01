package com.khamid.Online_Ticket.service;

import com.khamid.Online_Ticket.dto.HallDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallService {
    String createHall(HallDto dto);

    List<HallDto> getAllHalls();

    HallDto getHallById(Long id);

    void deleteHall(Long id);
}
