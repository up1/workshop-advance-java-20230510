package org.example.badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessExceptionTest {

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

    @Test
    @DisplayName("Register without lastname")
    public void case02_exception() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        Exception e =  assertThrows(ArgumentNullException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            registerBusiness.register(null, speaker);
        });
        // Assert
        assertEquals("Last name is required.", e.getMessage());
    }

    @Test
    @DisplayName("Register without email")
    public void case03_exception() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        Exception e =  assertThrows(ArgumentNullException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            registerBusiness.register(null, speaker);
        });
        // Assert
        assertEquals("Email is required.", e.getMessage());
    }

    @Test
    @DisplayName("Register with invalid domain")
    public void case04_exception() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        Exception e =  assertThrows(DomainEmailInvalidException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            speaker.setEmail("xxxxxx");
            registerBusiness.register(null, speaker);
        });
        // Assert
        assertNotNull(e);
    }

    @Test
    @DisplayName("Register with @xxx.com")
    public void case06_exception() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        Exception e =  assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            speaker.setEmail("xxxx@xxx.com");
            registerBusiness.register(null, speaker);
        });
        // Assert
        assertEquals("Speaker doesn't meet our standard rules.", e.getMessage());
    }

    @Test
    @DisplayName("Register with valid domain")
    public void case05_exception() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        Exception e =  assertThrows(SaveSpeakerException.class, () -> {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            speaker.setEmail("xxxx@gmail.com");
            registerBusiness.register(null, speaker);
        });
        // Assert
        assertEquals("Can't save a speaker.", e.getMessage());
    }
}