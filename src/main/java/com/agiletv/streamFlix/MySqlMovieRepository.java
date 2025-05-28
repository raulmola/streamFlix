package com.agiletv.streamFlix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlMovieRepository implements MovieRepository {

    @Autowired
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

    @Override
    public List<Movie> findAll() {
        return jpaMovieRepository.findAll().stream().map(entity -> {
            return Movie.create(
                entity.getTitle(),
                entity.getDescription(),
                entity.getReleaseYear(),
                entity.getDirector(),
                entity.getGenres(),
                entity.getDuration(),
                entity.getAgeRating(),
                entity.getCoverImageUrl(),
                entity.getAverageRating(),
                entity.getAddedDate()
            );
        }).toList();
    }
}