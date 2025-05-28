package com.agiletv.streamFlix;

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

    @Autowired
    private MovieRepository movieRepository;

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
        // Assuming the repository has a method to find all movies
        List<Movie> movies = movieRepository.findAll();
        assertThat(movies).isNotEmpty();
        assertThat(movies.get(0).getTitle()).isEqualTo("Test Movie");
    }
}
