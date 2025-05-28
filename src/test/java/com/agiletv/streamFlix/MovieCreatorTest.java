package com.agiletv.streamFlix;

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

        MovieCreatorDTO dto = new MovieCreatorDTO(
                "Test Movie", "A test movie description", 2023, "Test Director",
                java.util.List.of("Action", "Adventure"), 120, "PG-13",
                "http://example.com/test-movie.jpg", 4.5, java.time.LocalDate.parse("2023-10-01")
        );

        creator.create(dto);

        assertNotNull(fakeRepo.savedMovie);
    }
}