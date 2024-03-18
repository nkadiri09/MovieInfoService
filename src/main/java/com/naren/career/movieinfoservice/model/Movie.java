package com.naren.career.movieinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private String name;
    private String movieId;
    private String desc;
}