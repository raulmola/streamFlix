package com.agiletv.streamFlix;

import com.agiletv.streamFlix.application.domain.Movie;
import com.agiletv.streamFlix.application.ports.primary.MovieCreator;
import com.agiletv.streamFlix.application.ports.secundary.MovieRepository;
import com.agiletv.streamFlix.application.usecase.MovieApplication;
import com.agiletv.streamFlix.application.ports.primary.MovieCreatorCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MovieCreatorTest {

    static class FakeMovieRepository implements MovieRepository {
        Movie savedMovie = null;

        @Override
        public void save(Movie movie) {
            this.savedMovie = movie;
        }
    }

    @Test
    void shouldStoreMovie() {
        FakeMovieRepository fakeRepo = new FakeMovieRepository();
        MovieCreator creator = new MovieApplication(fakeRepo);

        MovieCreatorCommand dto = new MovieCreatorCommand(
                "Test Movie", "A test movie description", 2023, "Test Director",
                java.util.List.of("Action", "Adventure"), 120, "PG-13",
                "http://example.com/test-movie.jpg", 4.5, java.time.LocalDate.parse("2023-10-01")
        );

        creator.create(dto);

        assertNotNull(fakeRepo.savedMovie);
    }

    @Test
    void shouldStoreMovieWithCorrectData() {
        FakeMovieRepository fakeRepo = new FakeMovieRepository();
        MovieCreator creator = new MovieApplication(fakeRepo);

        MovieCreatorCommand dto = new MovieCreatorCommand(
                "Test Movie", "A test movie description", 2023, "Test Director",
                java.util.List.of("Action", "Adventure"), 120, "PG-13",
                "http://example.com/test-movie.jpg", 4.5, java.time.LocalDate.parse("2023-10-01")
        );

        creator.create(dto);

        assertNotNull(fakeRepo.savedMovie);
        assertEquals(dto.title(), fakeRepo.savedMovie.getTitle());
        assertEquals(dto.description(), fakeRepo.savedMovie.getDescription());
        assertEquals(dto.releaseYear(), fakeRepo.savedMovie.getReleaseYear());
        assertEquals(dto.director(), fakeRepo.savedMovie.getDirector());
        assertEquals(dto.genres(), fakeRepo.savedMovie.getGenres());
        assertEquals(dto.duration(), fakeRepo.savedMovie.getDuration());
        assertEquals(dto.ageRating(), fakeRepo.savedMovie.getAgeRating());
        assertEquals(dto.coverImageUrl(), fakeRepo.savedMovie.getCoverImageUrl());
        assertEquals(dto.averageRating(), fakeRepo.savedMovie.getAverageRating());
        assertEquals(dto.addedDate(), fakeRepo.savedMovie.getAddedDate());
    }
}