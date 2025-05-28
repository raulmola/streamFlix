package com.agiletv.streamFlix;

class MovieApplication implements MovieCreator {
    private final MovieRepository repository;

    MovieApplication(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(MovieCreatorDTO dto) {
        Movie movie = new Movie();
        repository.save(movie);
    }
}