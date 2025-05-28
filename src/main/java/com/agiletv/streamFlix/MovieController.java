package com.agiletv.streamFlix;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieCreator movieCreator;

    public MovieController(MovieCreator movieCreator) {
        this.movieCreator = movieCreator;
    }

    @PostMapping
    public ResponseEntity<Void> createMovie(@RequestBody MovieCreatorApiDto movieCreatorApiDto) {
        MovieCreatorDTO movieCreatorDTO = new MovieCreatorDTO(
            movieCreatorApiDto.title(),
            movieCreatorApiDto.description(),
            movieCreatorApiDto.releaseYear(),
            movieCreatorApiDto.director(),
            movieCreatorApiDto.genres(),
            movieCreatorApiDto.duration(),
            movieCreatorApiDto.ageRating(),
            movieCreatorApiDto.coverImageUrl(),
            movieCreatorApiDto.averageRating(),
            movieCreatorApiDto.addedDate()
        );

        movieCreator.create(movieCreatorDTO);
        return ResponseEntity.status(201).build();
    }
}

