package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Enum.SeatType;
import com.acciojob.BookMyShow.Project.Repository.TheaterRepository;
import com.acciojob.BookMyShow.Project.Repository.TheaterSeatsRepository;
import com.acciojob.BookMyShow.Project.Requests.AddTheaterRequest;
import com.acciojob.BookMyShow.Project.Requests.AddTheaterSeatsRequest;
import com.acciojob.BookMyShow.Project.models.Theater;
import com.acciojob.BookMyShow.Project.models.TheaterSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;



    public String addTheater(AddTheaterRequest theaterRequest){
        Theater theater = Theater.builder().noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();

        theater = theaterRepository.save(theater);
        return "Theater has been saved to the Db with theater Id : "+theater.getTheaterId();
    }

    public String associateTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsRequest){
        int theaterId = addTheaterSeatsRequest.getTheaterId();
        int noOfClassicSeats = addTheaterSeatsRequest.getNoOfClassicSeats();  //6
        int noOfPremiumSeats = addTheaterSeatsRequest.getNoOfPremiumSeats();  //7

        Theater theater = theaterRepository.findById(theaterId).get();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();


        int noOfRowsOfClassicSeats = noOfClassicSeats / 5;   // 1
        int noOfSeatsInLastRow = noOfClassicSeats % 5;   //1
        int i;
        for(i=1;i<=noOfRowsOfClassicSeats;i++){
            for(int j=1;j<=5;j++){
                char ch = (char)('A'+j-1);
                String seatNo = ""+i+ch;

                TheaterSeat theaterSeat = new TheaterSeat().builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater)
                        .build();

                theaterSeatList.add(theaterSeat);
            }
        }
        for(int j=1;j<=noOfSeatsInLastRow;j++){
            char ch = (char)('A'+j-1);
            String seatNo = ""+i+ch;

            TheaterSeat theaterSeat = new TheaterSeat().builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
        }


        int noOfRowsOfPremiumSeats = noOfPremiumSeats / 5;
        noOfSeatsInLastRow = noOfPremiumSeats % 5;

        for(i=1;i<=noOfRowsOfPremiumSeats;i++){
            for(int j=1;j<=5;j++){
                char ch = (char)('A'+j-1);
                String seatNo = ""+i+ch;

                TheaterSeat theaterSeat = new TheaterSeat().builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theater(theater)
                        .build();

                theaterSeatList.add(theaterSeat);
            }
        }

        for(int j=1;j<=noOfSeatsInLastRow;j++){
            char ch = (char)('A'+j-1);
            String seatNo = ""+i+ch;

            TheaterSeat theaterSeat = new TheaterSeat().builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);
        theaterSeatsRepository.saveAll(theaterSeatList);
        return "The theater seats have been associated!";
    }
}
