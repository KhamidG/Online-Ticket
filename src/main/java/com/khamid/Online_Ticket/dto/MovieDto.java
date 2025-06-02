package com.khamid.Online_Ticket.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MovieDto {
    private Long id;
    private String title;
    private String movieType;
    private Integer rate;
}
