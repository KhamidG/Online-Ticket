package com.khamid.Online_Ticket.repository;

import com.khamid.Online_Ticket.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<AuthEntity, Long> {
    Optional<AuthEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
