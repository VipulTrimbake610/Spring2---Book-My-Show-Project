package com.acciojob.BookMyShow.Project.Repository;

import com.acciojob.BookMyShow.Project.models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeat, Integer> {
}
