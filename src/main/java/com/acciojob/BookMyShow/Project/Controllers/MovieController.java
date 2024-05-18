package com.acciojob.BookMyShow.Project.Controllers;

import com.acciojob.BookMyShow.Project.Requests.AddMovieRequest;
import com.acciojob.BookMyShow.Project.Requests.UpdateMovieRequest;
import com.acciojob.BookMyShow.Project.Services.MovieService;
import com.acciojob.BookMyShow.Project.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest movieRequest){
        String result = movieService.addMovie(movieRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateMovieAttributes(@RequestBody UpdateMovieRequest updateMovieRequest){
        String result = movieService.updateMovieAttributes(updateMovieRequest);
        return new ResponseEntity(result,HttpStatus.OK);
    }

}
