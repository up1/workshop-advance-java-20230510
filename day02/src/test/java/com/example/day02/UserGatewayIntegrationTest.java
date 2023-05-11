package com.example.day02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserGatewayIntegrationTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    @DisplayName("Success to call /users/1")
    public void call_real_api() {
        // Act
        UserResponse result = userGateway.getUnitById(1);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Leanne Graham", result.getName());
    }

}