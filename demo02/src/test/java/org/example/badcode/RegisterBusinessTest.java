package org.example.badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    @Test
    @DisplayName("Register without firstname")
    public void case01_exception_manual() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        try {
            registerBusiness.register(null, new Speaker());
            fail();
        }catch (Exception e) {
            assertEquals("First name is required.", e.getMessage());
        }
    }

    @Test
    @DisplayName("Register without firstname with junit 5")
    public void case01_exception_junit5() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        Exception e =  assertThrows(ArgumentNullException.class, () -> {
            registerBusiness.register(null, new Speaker());
        });
        // Assert
        assertEquals("First name is required.", e.getMessage());
    }
}