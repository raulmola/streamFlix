package com.agiletv.streamFlix;

import com.agiletv.streamFlix.adapters.secundary.JpaMovieRepository;
import com.agiletv.streamFlix.adapters.secundary.MovieEntity;
import com.agiletv.streamFlix.application.domain.Movie;
import com.agiletv.streamFlix.application.ports.secundary.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
class MovieRepositoryIntegrationTest {

    @BeforeEach
    void setUp() {
        jpaMovieRepository.deleteAll(); // Limpia la base de datos
    }

    @AfterEach
    void tearDown() {
        jpaMovieRepository.deleteAll(); // Limpia la base de datos
    }

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private JpaMovieRepository jpaMovieRepository;

    @Test
    void shouldPersistMovieInDatabase() {
        // Arrange
        Movie movie = Movie.create(
                "Test Movie",
                "A test movie description",
                2023,
                "Test Director",
                List.of("Action", "Adventure"),
                120,
                "PG-13",
                "http://example.com/test-movie.jpg",
                4.5,
                LocalDate.parse("2023-10-01")
        );

        // Act
        movieRepository.save(movie);

        // Assert
        MovieEntity persistedMovie = jpaMovieRepository.findByTitle("Test Movie");
        assertThat(persistedMovie).isNotNull();
        assertThat(persistedMovie.getTitle()).isEqualTo("Test Movie");
    }
}
