package com.agiletv.streamFlix.application.usecase;

import com.agiletv.streamFlix.application.domain.Movie;
import com.agiletv.streamFlix.application.ports.primary.MovieCreator;
import com.agiletv.streamFlix.application.ports.primary.MovieCreatorCommand;
import com.agiletv.streamFlix.application.ports.secundary.MovieRepository;

public class MovieApplication implements MovieCreator {
    private final MovieRepository repository;

    public MovieApplication(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(MovieCreatorCommand dto) {
        Movie movie = Movie.create(
            dto.title(),
            dto.description(),
            dto.releaseYear(),
            dto.director(),
            dto.genres(),
            dto.duration(),
            dto.ageRating(),
            dto.coverImageUrl(),
            dto.averageRating(),
            dto.addedDate()
        );
        repository.save(movie);
    }
}