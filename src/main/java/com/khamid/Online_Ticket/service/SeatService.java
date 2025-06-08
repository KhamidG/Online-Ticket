package com.khamid.Online_Ticket.service;

import com.khamid.Online_Ticket.entity.SeatEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SeatService {
    List<SeatEntity> getAllSeats();

    Optional<SeatEntity> getSeatById(Long id);

    String bookSeat(Long seatId, Long hallId);
}
