package com.agiletv.streamFlix.application.ports.secundary;

import com.agiletv.streamFlix.application.Movie;

public interface MovieRepository {
    void save(Movie movie);
}