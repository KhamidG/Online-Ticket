package com.khamid.Online_Ticket.repository;

import com.khamid.Online_Ticket.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
}
