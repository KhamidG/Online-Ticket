package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.dto.AuthDto;
import com.khamid.Online_Ticket.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/reg")
    public ResponseEntity<String> reg(@RequestBody AuthDto dto) {
        return ResponseEntity.ok(authService.registerUser(dto));
    }

    @PostMapping("/log")
    public ResponseEntity<String> log(@RequestBody AuthDto dto) {
        return ResponseEntity.ok(authService.loginUser(dto));
    }

    @PostMapping("/changeRole")
    public ResponseEntity<String> changeRole(@RequestBody AuthDto dto) {
        return ResponseEntity.ok(authService.changeRole(dto));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody AuthDto dto) {
        return ResponseEntity.ok(authService.changePassword(dto));
    }

}
