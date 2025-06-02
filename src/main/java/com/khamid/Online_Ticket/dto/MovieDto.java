package com.khamid.Online_Ticket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {
    private Long id;
    private String title;
    private String movieType;
    private Integer rate;
}
