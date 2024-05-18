package com.acciojob.BookMyShow.Project.Responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
public class TicketResponse {
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private  String theaterName;
    private Integer totalAmount;
}
