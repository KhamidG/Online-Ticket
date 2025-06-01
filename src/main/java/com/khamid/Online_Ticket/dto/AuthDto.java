package com.khamid.Online_Ticket.dto;

import com.khamid.Online_Ticket.enums.UserRole;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private UserRole userRole;
    private String adminPassword;
}
