package com.agiletv.streamFlix.config;

import com.agiletv.streamFlix.application.MovieApplication;
import com.agiletv.streamFlix.application.MovieCreator;
import com.agiletv.streamFlix.application.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieCreatorConfig {

    private final MovieRepository movieRepository;

    public MovieCreatorConfig(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Bean
    public MovieCreator movieCreator() {
        return new MovieApplication(movieRepository);
    }
}
