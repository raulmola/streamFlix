package com.agiletv.streamFlix;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlMovieRepository implements MovieRepository {


    private final JpaMovieRepository jpaMovieRepository;

    public MySqlMovieRepository(JpaMovieRepository jpaMovieRepository) {
        this.jpaMovieRepository = jpaMovieRepository;
    }

    @Override
    public void save(Movie movie) {
//        jpaMovieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return List.of();
    }
}
