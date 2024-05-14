package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Repository.MovieRepository;
import com.acciojob.BookMyShow.Project.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        movie = movieRepository.save(movie);
        return "Movie has been added to the DB with movie id : "+movie.getMovieId();

    }
}
