package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Repository.MovieRepository;
import com.acciojob.BookMyShow.Project.Requests.AddMovieRequest;
import com.acciojob.BookMyShow.Project.Requests.UpdateMovieRequest;
import com.acciojob.BookMyShow.Project.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(AddMovieRequest movieRequest){

        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDuration(movieRequest.getDuration());
        movie.setMovieName(movieRequest.getMovieName());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setRating(movieRequest.getRating());
        movie.setReleaseData(movieRequest.getReleaseDate());

        movie = movieRepository.save(movie);
        return "Movie has been added to the DB with movie id : "+movie.getMovieId();

    }

    public String updateMovieAttributes(UpdateMovieRequest movieRequest){
        Movie movie = movieRepository.findMovieByMovieName(movieRequest.getMovieName());
        movie.setLanguage(movieRequest.getNewLanguage());
        movie.setRating(movieRequest.getNewRating());

        movieRepository.save(movie);

        return "Movie attribute have been updated!";
    }
}
