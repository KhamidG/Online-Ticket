package com.khamid.Online_Ticket.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class MovieDto {
    private Long id;
    private String title;
    private String movieType;
    private Integer rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
