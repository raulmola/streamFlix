package com.agiletv.streamFlix.application.ports.primary;

import com.agiletv.streamFlix.application.MovieCreatorCommand;

public interface MovieCreator {
    void create(MovieCreatorCommand dto);
}
