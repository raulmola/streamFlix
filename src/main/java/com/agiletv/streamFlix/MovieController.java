package com.agiletv.streamFlix;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

  @PostMapping
  public ResponseEntity<Void> createMovie() {
    throw new UnsupportedOperationException("This endpoint is not implemented yet.");
  }
}
