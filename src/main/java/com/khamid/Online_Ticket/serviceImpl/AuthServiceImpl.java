package com.khamid.Online_Ticket.serviceImpl;

import com.khamid.Online_Ticket.dto.AuthDto;
import com.khamid.Online_Ticket.entity.AuthEntity;
import com.khamid.Online_Ticket.enums.UserRole;
import com.khamid.Online_Ticket.exps.BadException;
import com.khamid.Online_Ticket.repository.ProfileRepository;
import com.khamid.Online_Ticket.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    BCryptPasswordEncoder bc;

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public String registerUser(AuthDto authDto) {
        if (profileRepository.existsByEmail(authDto.getEmail())) {
            throw new BadException("Email already registered.");
        }
        AuthEntity authEntity = new AuthEntity();
        authEntity.setFullName(authDto.getFullName());
        authEntity.setEmail(authDto.getEmail());
        authEntity.setPassword(bc.encode(authDto.getPassword()));
        authEntity.setCreatedAt(LocalDateTime.now());
        authEntity.setRole(UserRole.ROLE_USER);

        profileRepository.save(authEntity);
        authDto.setId(authEntity.getId());
        log.info("User registered: {}", authDto.getEmail());

        return "Successfully registered";
    }

    @Override
    public String loginUser(AuthDto authDto) {
        if (!login(authDto.getEmail(), authDto.getPassword())) {
            throw new BadException("Password is wrong");
        }
        log.info("User logged: {}", authDto.getEmail());
        return "Successfully logged in.";
    }

    public boolean login(String email, String password) {
        AuthEntity entity = profileRepository.findByEmail(email)
                .orElseThrow(() -> new BadException("User not found."));

        return bc.matches(password, entity.getPassword());
    }

    @Override
    public String changeRole(AuthDto authDto) {
        Optional<AuthEntity> optionalUser = profileRepository.findByEmail(authDto.getEmail());

        if (optionalUser.isEmpty()) {
            return "Invalid email";
        }
        AuthEntity user = optionalUser.get();
        if (!user.getPassword().equals(authDto.getPassword())) {
            return "Invalid user password";
        }
        if (!authDto.getAdminPassword().equals("admin001")) {
            throw new BadException("Wrong admin password");
        }
        user.setRole(UserRole.ROLE_ADMIN);
        profileRepository.save(user);

        return "Successfully changed role to ADMIN";
    }

    @Override
    public String changePassword(AuthDto authDto) {
        Optional<AuthEntity> optionalUser = profileRepository.findByEmail(authDto.getEmail());

        if (optionalUser.isEmpty()) {
            throw new BadException("Invalid email.");
        }

        AuthEntity userEntity = optionalUser.get();
        userEntity.setPassword(bc.encode(authDto.getPassword()));
        profileRepository.save(userEntity);

        return "Successfully change password. ";
    }
}
