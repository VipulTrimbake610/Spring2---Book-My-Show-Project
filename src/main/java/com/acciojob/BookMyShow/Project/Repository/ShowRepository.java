package com.acciojob.BookMyShow.Project.Repository;

import com.acciojob.BookMyShow.Project.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
