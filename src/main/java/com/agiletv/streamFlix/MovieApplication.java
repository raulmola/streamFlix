package com.agiletv.streamFlix;

class MovieApplication implements MovieCreator {
    private final MovieRepository repository;

    MovieApplication(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(MovieCreatorDTO dto) {
        Movie movie = Movie.NameConstructor(
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