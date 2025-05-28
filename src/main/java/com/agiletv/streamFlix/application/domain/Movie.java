package com.agiletv.streamFlix.application.domain;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private final String title;
    private final String description;
    private final int releaseYear;
    private final String director;
    private final List<String> genres;
    private final int duration;
    private final String ageRating;
    private final String coverImageUrl;
    private final double averageRating;
    private final LocalDate addedDate;

    private Movie(String title, String description, int releaseYear, String director,
                  List<String> genres, int duration, String ageRating,
                  String coverImageUrl, double averageRating, LocalDate addedDate) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genres = genres;
        this.duration = duration;
        this.ageRating = ageRating;
        this.coverImageUrl = coverImageUrl;
        this.averageRating = averageRating;
        this.addedDate = addedDate;
    }

    public static Movie create(String title, String description, int releaseYear, String director,
                               List<String> genres, int duration, String ageRating,
                               String coverImageUrl, double averageRating, LocalDate addedDate) {
        return new Movie(title, description, releaseYear, director, genres, duration, ageRating, coverImageUrl, averageRating, addedDate);
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getReleaseYear() { return releaseYear; }
    public String getDirector() { return director; }
    public List<String> getGenres() { return genres; }
    public int getDuration() { return duration; }
    public String getAgeRating() { return ageRating; }
    public String getCoverImageUrl() { return coverImageUrl; }
    public double getAverageRating() { return averageRating; }
    public LocalDate getAddedDate() { return addedDate; }
}