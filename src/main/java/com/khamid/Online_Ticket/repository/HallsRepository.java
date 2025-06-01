package com.khamid.Online_Ticket.repository;

import com.khamid.Online_Ticket.entity.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallsRepository extends JpaRepository<HallEntity, Long> {
}
