package com.naren.career.movieinfoservice.controller;


import com.naren.career.movieinfoservice.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/movies")
@Slf4j
public class MovieController {

    private static final Logger LOGGER= LoggerFactory.getLogger(MovieController.class);

    @RequestMapping("/{movieId}")
    public Movie getMovieList(@PathVariable("movieId") String movieId){
        LOGGER.info("In getMovieList for:{} ", movieId);
        Map<String, String> movies = new HashMap<>();
        movies.put("100", "IronMan");
        movies.put("101", "IronMan2");
        movies.put("102", "Thor");
        movies.put("103", "Avengers");
        Movie movie = new Movie(movies.get(movieId), movieId, "Desc: " + movies.get(movieId) + " is very good movie");
        log.info("movie from movie-info-service is:{}", movie);
        return movie;
    }

    @RequestMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers){
        LOGGER.info("Headers info is: ", headers);
        Map<String, String> movies = headers;
/*        movies.put("100", "IronMan");
        movies.put("101", "IronMan2");
        movies.put("102", "Thor");
        movies.put("103", "Avengers");*/
        System.out.println(" Headers are: "+headers);
        return headers;
    }

    @PostMapping("/example/request")
    public ResponseEntity<Movie> requestEntityExample(RequestEntity<Movie> requestEntity) {
        log.info("RequestEntity Headers {}", requestEntity.getHeaders());
        log.info("RequestEntity method {}", requestEntity.getMethod());
        log.info("RequestEntity URL {}", requestEntity.getUrl());
        log.info("RequestEntity Type {}", requestEntity.getType());
        log.info("RequestEntity body {}", requestEntity.getBody());
        return ResponseEntity.ok(requestEntity.getBody());
    }
}
