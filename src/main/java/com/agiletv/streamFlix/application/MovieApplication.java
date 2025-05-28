package com.agiletv.streamFlix.application;

public class MovieApplication implements MovieCreator {
    private final MovieRepository repository;

    public MovieApplication(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(MovieCreatorDTO dto) {
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