package com.agiletv.streamFlix.adapters.secundary;

import com.agiletv.streamFlix.application.domain.Movie;
import com.agiletv.streamFlix.application.ports.secundary.MovieRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlMovieRepository implements MovieRepository {

    private final JpaMovieRepository jpaMovieRepository;

    public MySqlMovieRepository(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }

    @Override
    public void save(Movie movie) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setDescription(movie.getDescription());
        movieEntity.setReleaseYear(movie.getReleaseYear());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setGenres(movie.getGenres());
        movieEntity.setDuration(movie.getDuration());
        movieEntity.setAgeRating(movie.getAgeRating());
        movieEntity.setCoverImageUrl(movie.getCoverImageUrl());
        movieEntity.setAverageRating(movie.getAverageRating());
        movieEntity.setAddedDate(movie.getAddedDate());

        jpaMovieRepository.save(movieEntity);
    }
}