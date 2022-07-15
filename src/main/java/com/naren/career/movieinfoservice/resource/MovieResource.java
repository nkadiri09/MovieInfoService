package com.naren.career.movieinfoservice.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    private static final Logger LOGGER= LoggerFactory.getLogger(MovieResource.class);

    @RequestMapping("/{movieId}")
    public Movie getMovieList(@PathVariable("movieId") String movieId){
        LOGGER.info("In getMovieList for:{} ", movieId);
        Map<String, String> movies = new HashMap<>();
        movies.put("100", "IronMan");
        movies.put("101", "IronMan2");
        movies.put("102", "Thor");
        movies.put("103", "Avengers");
        return new Movie(movies.get(movieId), movieId, "Desc: "+movies.get(movieId)+" is very good movie");
    }
}
