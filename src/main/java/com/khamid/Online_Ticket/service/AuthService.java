package com.khamid.Online_Ticket.service;

import com.khamid.Online_Ticket.dto.AuthDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String registerUser(AuthDto authDto);
    String loginUser(AuthDto authDto);
    String changeRole(AuthDto authDto);
    String changePassword(AuthDto authDto);
}