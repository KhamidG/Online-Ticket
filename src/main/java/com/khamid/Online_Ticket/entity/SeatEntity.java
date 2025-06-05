package com.khamid.Online_Ticket.entity;

import com.khamid.Online_Ticket.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "seat_entity")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer row;

    @Column
    private Integer columns;

    @Column
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "hall_id")
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
        return columns;
    }

    public void setColumn(Integer column) {
        this.columns = column;
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
