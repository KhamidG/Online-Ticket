package com.khamid.Online_Ticket.service;

import com.khamid.Online_Ticket.dto.HallDto;
import com.khamid.Online_Ticket.entity.HallEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallService {
    String createHall(HallDto dto);
    List<HallEntity> getAllHalls();
}
