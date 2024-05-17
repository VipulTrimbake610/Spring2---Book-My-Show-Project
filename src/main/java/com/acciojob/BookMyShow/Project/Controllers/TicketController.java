package com.acciojob.BookMyShow.Project.Controllers;

import com.acciojob.BookMyShow.Project.Requests.BookTicketRequest;
import com.acciojob.BookMyShow.Project.models.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @PostMapping("bookTicket")
    public Ticket bookTicket(@RequestBody BookTicketRequest bookTicketRequest){

    }
}
