package com.khamid.Online_Ticket.serviceImpl;

import com.khamid.Online_Ticket.entity.SeatEntity;
import com.khamid.Online_Ticket.repository.SeatRepository;
import com.khamid.Online_Ticket.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository repository;

    @Override
    public List<SeatEntity> getAllSeats() {
        return repository.findAll();
    }

    @Override
    public Optional<SeatEntity> getSeatById(Long id) {
        return repository.findById(id);
    }
}
