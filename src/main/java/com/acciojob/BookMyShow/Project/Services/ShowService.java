package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Repository.MovieRepository;
import com.acciojob.BookMyShow.Project.Repository.ShowRepository;
import com.acciojob.BookMyShow.Project.Repository.ShowSeatRepository;
import com.acciojob.BookMyShow.Project.Repository.TheaterRepository;
import com.acciojob.BookMyShow.Project.Requests.AddShowRequest;
import com.acciojob.BookMyShow.Project.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(@RequestBody AddShowRequest addShowRequest){

        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        Theater theater = theaterRepository.findById(addShowRequest.getTheaterId()).get();

        Show show   = Show.builder().showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .movie(movie)
                .theater(theater)
                .build();

        show = showRepository.save(show);

        // Associate the corresponding show seats along with it.
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();
        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList)
        {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .isBooked(Boolean.FALSE)
                    .isFoodAttached(Boolean.FALSE)
                    .show(show)
                    .build();

            showSeatList.add(showSeat);
        }




        show.setShowSeatList(showSeatList);

        showSeatRepository.saveAll(showSeatList);


        return "The Show has been saved to the DB with Show Id : "+show.getShowId();
    }

}
