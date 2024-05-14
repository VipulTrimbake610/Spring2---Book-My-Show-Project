package com.acciojob.BookMyShow.Project.Controllers;

import com.acciojob.BookMyShow.Project.Services.MovieService;
import com.acciojob.BookMyShow.Project.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String result = movieService.addMovie(movie);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
