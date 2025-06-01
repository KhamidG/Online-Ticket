package com.khamid.Online_Ticket.serviceImpl;

import com.khamid.Online_Ticket.dto.HallDto;
import com.khamid.Online_Ticket.entity.HallEntity;
import com.khamid.Online_Ticket.repository.HallsRepository;
import com.khamid.Online_Ticket.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    @Autowired
    HallsRepository hallsRepository;

    @Override
    public String createHall(HallDto dto) {
        HallEntity entity = new HallEntity();
        entity.setName(dto.getName());
        entity.setRows(dto.getRows());
        entity.setColumns(dto.getColumns());
        entity.setSeatCount(dto.getSeatCount());

        hallsRepository.save(entity);
        dto.setId(dto.getId());

        return "Successfully created new hall";
    }

    @Override
    public List<HallDto> getAllHalls() {
        return List.of();
    }

    @Override
    public HallDto getHallById(Long id) {
        return null;
    }

    @Override
    public void deleteHall(Long id) {

    }
}
