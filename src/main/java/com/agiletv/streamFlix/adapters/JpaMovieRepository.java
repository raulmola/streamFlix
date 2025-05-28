package com.agiletv.streamFlix.adapters;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository<MovieEntity, Long> {
    MovieEntity findByTitle(String title);
}