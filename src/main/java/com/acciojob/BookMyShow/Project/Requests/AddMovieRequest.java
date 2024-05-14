package com.acciojob.BookMyShow.Project.Requests;

import com.acciojob.BookMyShow.Project.Enum.Language;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;
    private Double duration;
    private LocalDate releaseDate;
    private Language language;
    private Double rating;
}
