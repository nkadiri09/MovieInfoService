package com.naren.career.movieinfoservice.controller;


import com.naren.career.movieinfoservice.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        String s = getRandomMovie();
        Movie movie = new Movie(s, movieId, "Desc: " + s + " is very good movie");
        log.info("movie from movie-info-service is:{}", movie);
        return movie;
    }

    @RequestMapping("/headers")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers){
        LOGGER.info("Headers info is: ", headers);
        Map<String, String> movies = headers;
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

    private String getRandomMovie(){
        String movies = "The Shawshank Redemption, The Godfather, The Dark Knight, Pulp Fiction, The Lord of the Rings: The Return of the King, Forrest Gump, Inception, Fight Club, The Matrix, The Empire Strikes Back, The Godfather: Part II, Schindler's List, The Lion King, Gladiator, The Silence of the Lambs, Se7en, The Green Mile, Interstellar, The Departed, The Prestige, Saving Private Ryan, The Usual Suspects, Schindler's List, Goodfellas, The Dark Knight Rises, Star Wars: A New Hope, The Social Network, The Shining, Braveheart, Parasite, Whiplash, Citizen Kane, Rear Window, Casablanca, The Big Lebowski, The Grand Budapest Hotel, Mad Max: Fury Road, 12 Angry Men, The Revenant, The Martian, Jaws, The Wizard of Oz, Apocalypse Now, Alien, Memento, Django Unchained, 2001: A Space Odyssey, A Clockwork Orange, The Terminator, Gone with the Wind, The Good, the Bad and the Ugly, A Beautiful Mind, The Great Escape, The Bridge on the River Kwai, The Breakfast Club, Batman Begins, The Pianist, Heat, The Thing, One Flew Over the Cuckoo's Nest, The Dark Knight Trilogy, American Beauty, The Princess Bride, The Fighter, The King's Speech, The Hobbit: An Unexpected Journey, The Matrix Reloaded, The Matrix Revolutions, The Bourne Identity, The Bourne Ultimatum, The Bourne Supremacy, The Shallows, The Hateful Eight, The Incredibles, The Secret Life of Walter Mitty, The Incredibles 2, Coco, Toy Story, Toy Story 2, Toy Story 3, The Lion King (1994), Her, The Pursuit of Happyness, La La Land, The Favourite, Moonlight, Call Me by Your Name, The Shape of Water, The Imitation Game, Spotlight, The Artist, La La Land, The Secret Life of Pets, WALL-E, Up, Finding Nemo, The Croods, Spirited Away, Your Name, The Tale of the Princess Kaguya, Akira, The Night of the Hunter, The Last Samurai, Good Will Hunting, Lost in Translation, Drive, The Departed, The Exorcist, The Iron Giant";
        String[] movieArray = movies.split(", ");
        List<String> list = Arrays.asList(movieArray);
        return list.get((int) (Math.random() * list.size()));
    }
}
