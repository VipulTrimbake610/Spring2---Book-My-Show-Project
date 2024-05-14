package com.acciojob.BookMyShow.Project.Repository;

import com.acciojob.BookMyShow.Project.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
