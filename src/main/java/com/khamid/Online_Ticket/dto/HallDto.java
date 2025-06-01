package com.khamid.Online_Ticket.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HallDto {
    private Long id;
    private String name;
    private int seatCount;
    private int rows;
    private int columns;

    public int getSeatCount() {
        return rows * columns;
    }
}
