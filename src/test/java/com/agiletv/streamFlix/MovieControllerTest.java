package com.agiletv.streamFlix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser(username="user", roles={"USER"})
  void createMovieWithoutAdminRoleShouldReturnUnauthorized() throws Exception {
    mockMvc.perform(post("/api/movies")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                  "title": "Test Movie",
                  "description": "A test movie description",
                  "releaseYear": 2023,
                  "director": "Test Director",
                  "genres": ["Action", "Adventure"],
                  "duration": 120,
                  "ageRating": "PG-13",
                  "coverImageUrl": "http://example.com/test-movie.jpg",
                  "averageRating": 4.5,
                  "addedDate": "2023-10-01"
                }
                """))
        .andExpect(status().isUnauthorized());
  }

  @Test
  @WithMockUser(username = "admin", roles = {"ADMIN"})
  void createMovieWithAdminRoleShouldReturnCreated() throws Exception {
      mockMvc.perform(post("/api/movies")
              .contentType(MediaType.APPLICATION_JSON)
              .content("""
                  {
                    "title": "Test Movie",
                    "description": "A test movie description",
                    "releaseYear": 2023,
                    "director": "Test Director",
                    "genres": ["Action", "Adventure"],
                    "duration": 120,
                    "ageRating": "PG-13",
                    "coverImageUrl": "http://example.com/test-movie.jpg",
                    "averageRating": 4.5,
                    "addedDate": "2023-10-01"
                  }
                  """))
          .andExpect(status().isCreated());
  }
}