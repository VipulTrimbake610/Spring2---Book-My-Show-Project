package com.acciojob.BookMyShow.Project.Controllers;

import com.acciojob.BookMyShow.Project.Requests.AddTheaterRequest;
import com.acciojob.BookMyShow.Project.Requests.AddTheaterSeatsRequest;
import com.acciojob.BookMyShow.Project.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("add")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest theaterRequest){
        String response = theaterService.addTheater(theaterRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("associateSeats")
    public ResponseEntity associateSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest){
        String response = theaterService.associateTheaterSeats(addTheaterSeatsRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
