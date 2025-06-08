package com.khamid.Online_Ticket.serviceImpl;

import com.khamid.Online_Ticket.entity.AuthEntity;
import com.khamid.Online_Ticket.entity.HallEntity;
import com.khamid.Online_Ticket.entity.SeatEntity;
import com.khamid.Online_Ticket.enums.BookingStatus;
import com.khamid.Online_Ticket.exps.BadException;
import com.khamid.Online_Ticket.repository.HallRepository;
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

    @Override
    public String bookSeat(Long seatId, Long hallId) {
        if (!isBooking(seatId, hallId)) {
            throw new BadException("Seat or Hall id is not found");
        }

        return "Successfully booking seat.";
    }

    public boolean isBooking(Long seatId, Long hallId){
        Optional<SeatEntity> optionalSeat = repository.findById(seatId);
        if (optionalSeat.isEmpty()) {
            return false;
        }

        SeatEntity seat = optionalSeat.get();
        if (!seat.getHall().getId().equals(hallId)) {
            return false;
        }

        if (seat.getStatus() == BookingStatus.FREE) {
            seat.setStatus(BookingStatus.IS_BOOKING);
            repository.save(seat);
            return true;
        }

        return false;
    }

    @Override
    public String cancelBooking(Long id, Long hallId) {
        if (!cancelBookingConcept(id, hallId)){
            throw new BadException("Seat is not found");
        }

        return "Your book is successfully canceled.";
    }

    public boolean cancelBookingConcept(Long seatId, Long hallId) {
        Optional<SeatEntity> optionalSeat = repository.findById(seatId);
        if (optionalSeat.isEmpty()){
            return false;
        }

        SeatEntity entity = optionalSeat.get();
        if (!entity.getHall().getId().equals(hallId)){
            return false;
        }

        if(entity.getStatus().equals(BookingStatus.IS_BOOKING)){
            entity.setStatus(BookingStatus.FREE);
            repository.save(entity);
            return true;
        }

        return false;
    }
}
