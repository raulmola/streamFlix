package com.agiletv.streamFlix;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private int releaseYear;
    private String director;
    private List<String> genres;
    private int duration;
    private String ageRating;
    private String coverImageUrl;
    private double averageRating;
    private LocalDate addedDate;

    public Movie() {
        // Default constructor
    }

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

    public static Movie NameConstructor(String title, String description, int releaseYear, String director,
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