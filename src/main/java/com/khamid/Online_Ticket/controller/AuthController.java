package com.khamid.Online_Ticket.controller;

import com.khamid.Online_Ticket.dto.AuthDto;
import com.khamid.Online_Ticket.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Register new User")
    @PostMapping("/reg")
    public ResponseEntity<String> reg(@RequestBody AuthDto dto) {
        return ResponseEntity.ok(authService.registerUser(dto));
    }

//    @Operation(summary = "Logging to system")
//    @PostMapping("/log")
//    public ResponseEntity<String> log(@RequestBody AuthDto dto) {
//        return ResponseEntity.ok(authService.loginUser(dto));
//    }

    @Operation(summary = "Change role to ADMIN")
    @PostMapping("/changeRole")
    public ResponseEntity<String> changeRole(@RequestBody AuthDto dto) {
        return ResponseEntity.ok(authService.changeRole(dto));
    }

    @Operation(summary = "Change password")
    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody AuthDto dto) {
        return ResponseEntity.ok(authService.changePassword(dto));
    }

}
