package com.agiletv.streamFlix;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovieRepository extends JpaRepository<Movie, Long> {
}