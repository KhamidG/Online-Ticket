package com.khamid.Online_Ticket.serviceImpl;

import com.khamid.Online_Ticket.dto.AuthDto;
import com.khamid.Online_Ticket.dto.HallDto;
import com.khamid.Online_Ticket.entity.AuthEntity;
import com.khamid.Online_Ticket.entity.HallEntity;
import com.khamid.Online_Ticket.entity.SeatEntity;
import com.khamid.Online_Ticket.repository.HallRepository;
import com.khamid.Online_Ticket.repository.SeatRepository;
import com.khamid.Online_Ticket.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {
    @Autowired
    HallRepository repository;

    @Autowired
    SeatRepository seatRepository;

    @Override
    public String createHall(HallDto dto) {
        HallEntity entity = new HallEntity();
        entity.setName(dto.getName().toLowerCase());
        entity.setRows(dto.getRows());
        entity.setColumns(dto.getColumns());
        entity.setSeatCount(dto.getSeatCount());
        repository.save(entity);

        for (int row = 1; row <= entity.getRows(); row++) {
            for (int column = 1; column <= entity.getColumns(); column++) {
                SeatEntity seat = new SeatEntity();
                seat.setRow(row);
                seat.setColumn(column);
                seat.setHall(entity);
                seatRepository.save(seat);
            }
        }

        dto.setId(entity.getId());
        return "Successfully create new Hall!";
    }

    @Override
    public List<HallEntity> getAllHalls() {
        return repository.findAll();
    }
}
