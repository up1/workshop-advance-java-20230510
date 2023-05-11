package com.example.day02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Success with api /hello/say")
    public void success_case01() {
        // Act
        MessageResponse result
                = restTemplate.getForObject("/hello/say", MessageResponse.class);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Hello Spring Boot", result.getMessage());
    }

    @Test
    @DisplayName("Success with api /hello/say + entity")
    public void success_case02() {
        // Act
        ResponseEntity<MessageResponse> result
                = restTemplate.getForEntity("/hello/say", MessageResponse.class);
        // Assert
        assertEquals(200, result.getStatusCode().value());
        assertEquals(1, result.getBody().getId());
        assertEquals("Hello Spring Boot", result.getBody().getMessage());
    }

}