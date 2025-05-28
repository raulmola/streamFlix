package com.agiletv.streamFlix.application;

import java.time.LocalDate;
import java.util.List;

public record MovieCreatorCommand(
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
) {
}
