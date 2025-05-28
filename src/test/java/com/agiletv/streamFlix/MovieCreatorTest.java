package com.agiletv.streamFlix;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MovieCreatorTest {

    static class FakeMovieRepository implements MovieRepository {
        Movie savedMovie = null;

        @Override
        public void save(Movie movie) {
            this.savedMovie = movie;
        }

        @Override
        public List<Movie> findAll() {
            return List.of();
        }
    }

    @Test
    void shouldStoreMovie() {
        FakeMovieRepository fakeRepo = new FakeMovieRepository();
        MovieCreator creator = new MovieApplication(fakeRepo);

        MovieCreatorDTO dto = new MovieCreatorDTO(
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

        MovieCreatorDTO dto = new MovieCreatorDTO(
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