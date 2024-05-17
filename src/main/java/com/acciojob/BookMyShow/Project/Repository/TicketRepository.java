package com.acciojob.BookMyShow.Project.Repository;

import com.acciojob.BookMyShow.Project.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
