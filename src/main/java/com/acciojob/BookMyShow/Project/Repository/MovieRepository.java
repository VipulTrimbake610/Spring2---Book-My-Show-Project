package com.acciojob.BookMyShow.Project.Repository;

import com.acciojob.BookMyShow.Project.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);

}
