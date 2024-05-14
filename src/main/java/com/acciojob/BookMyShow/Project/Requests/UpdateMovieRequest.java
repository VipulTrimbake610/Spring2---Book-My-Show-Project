package com.acciojob.BookMyShow.Project.Requests;

import com.acciojob.BookMyShow.Project.Enum.Language;
import lombok.Data;

@Data
public class UpdateMovieRequest {
    private String movieName;
    private Language newLanguage;
    private Double newRating;
}
