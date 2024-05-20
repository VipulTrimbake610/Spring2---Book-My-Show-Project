package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Enum.SeatType;
import com.acciojob.BookMyShow.Project.Repository.ShowRepository;
import com.acciojob.BookMyShow.Project.Repository.ShowSeatRepository;
import com.acciojob.BookMyShow.Project.Repository.TicketRepository;
import com.acciojob.BookMyShow.Project.Repository.UserRepository;
import com.acciojob.BookMyShow.Project.Requests.BookTicketRequest;
import com.acciojob.BookMyShow.Project.Responses.TicketResponse;
import com.acciojob.BookMyShow.Project.models.Show;
import com.acciojob.BookMyShow.Project.models.ShowSeat;
import com.acciojob.BookMyShow.Project.models.Ticket;
import com.acciojob.BookMyShow.Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowService showService;

    public String bookTicket(BookTicketRequest bookTicketRequest){

        User user = userRepository.findById(bookTicketRequest.getUserId()).get();
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();
//        Show show = showService.getShow(bookTicketRequest.getShowId());
        Integer totalAmount = 0;
        List<ShowSeat> showSeatList = show.getShowSeatList();
        for (ShowSeat showSeat : showSeatList){
            String seatNo  = showSeat.getSeatNo();
            if(bookTicketRequest.getRequestedSeats().contains(seatNo)){
                showSeat.setIsBooked(Boolean.TRUE);
                if(showSeat.getSeatType().equals(SeatType.CLASSIC)){
                    totalAmount += 100;
                }else{
                    totalAmount += 150;
                }
            }
        }

        Ticket ticket = Ticket.builder()
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .movieName(show.getMovie().getMovieName())
                .theaterName(show.getTheater().getName())
                .totalAmount(totalAmount)
                .bookedSeats(bookTicketRequest.getRequestedSeats().toString())
                .show(show)
                .user(user)
                .build();

        showSeatRepository.saveAll(showSeatList);
        ticket = ticketRepository.save(ticket);

        return ticket.getTicketId();
    }

    public TicketResponse generateTicket(String ticketId){
        Ticket ticket = ticketRepository.findById(ticketId).get();

        TicketResponse ticketResponse = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .movieName(ticket.getMovieName())
                .showDate(ticket.getShowDate())
                .showTime(ticket.getShowTime())
                .theaterName(ticket.getTheaterName())
                .totalAmount(ticket.getTotalAmount())
                .build();

        return ticketResponse;
    }
}
