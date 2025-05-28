package com.agiletv.streamFlix.application.ports.secundary;

import com.agiletv.streamFlix.application.domain.Movie;

public interface MovieRepository {
    void save(Movie movie);
}