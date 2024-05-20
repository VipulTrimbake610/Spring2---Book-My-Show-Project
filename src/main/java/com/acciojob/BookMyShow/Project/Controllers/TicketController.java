package com.acciojob.BookMyShow.Project.Controllers;

import com.acciojob.BookMyShow.Project.Requests.BookTicketRequest;
import com.acciojob.BookMyShow.Project.Responses.TicketResponse;
import com.acciojob.BookMyShow.Project.Services.TicketService;
import com.acciojob.BookMyShow.Project.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        return ticketService.bookTicket(bookTicketRequest);
    }

    @GetMapping("generateTicket")
    public TicketResponse generateTicket(@RequestParam("ticketId") String ticketId){
        return ticketService.generateTicket(ticketId);
     }
}
