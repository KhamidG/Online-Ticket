package com.khamid.Online_Ticket.dto;

import com.khamid.Online_Ticket.entity.HallEntity;
import com.khamid.Online_Ticket.enums.BookingStatus;

public class SeatDto {
    private Long id;
    private Integer row;
    private Integer column;
    private BookingStatus status;
    private HallEntity hall;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public HallEntity getHall() {
        return hall;
    }

    public void setHall(HallEntity hall) {
        this.hall = hall;
    }
}
