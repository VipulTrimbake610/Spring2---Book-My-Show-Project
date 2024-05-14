package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Repository.TheaterRepository;
import com.acciojob.BookMyShow.Project.Requests.AddTheaterRequest;
import com.acciojob.BookMyShow.Project.models.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest theaterRequest){
        Theater theater = Theater.builder().noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the Db with theater Id : "+theater.getTheaterId();
    }
}
