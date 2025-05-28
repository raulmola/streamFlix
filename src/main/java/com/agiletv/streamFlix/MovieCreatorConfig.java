package com.agiletv.streamFlix;

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
