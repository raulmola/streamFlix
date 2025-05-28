package com.agiletv.streamFlix.adapters.primary.controller;

import java.time.LocalDate;
import java.util.List;

public record MovieCreatorApiDto(
    String title,
    String description,
    int releaseYear,
    String director,
    List<String> genres,
    int duration,
    String ageRating,
    String coverImageUrl,
    double averageRating,
    LocalDate addedDate
) {}