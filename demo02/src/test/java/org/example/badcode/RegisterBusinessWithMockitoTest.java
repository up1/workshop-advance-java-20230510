package org.example.badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegisterBusinessWithMockitoTest {
    @Mock
    private SpeakerRepository speakerRepository;

    @Test
    @DisplayName("Register success with id = 5")
    public void register_success(){
        // Arrange
        Speaker speaker = new Speaker();
        speaker.setFirstName("Somkiat");
        speaker.setLastName("Pui");
        speaker.setEmail("xxxx@gmail.com");
        when(speakerRepository.saveSpeaker(speaker)).thenReturn(1000);
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        int actualResult = registerBusiness.register(speakerRepository, speaker);
        // Assert
        assertEquals(1000, actualResult);
    }

    @Test
    @DisplayName("Register success with id = 5")
    public void register_success_with_spy(){
        // Arrange
        Speaker speaker = new Speaker();
        speaker.setFirstName("Somkiat");
        speaker.setLastName("Pui");
        speaker.setEmail("xxxx@gmail.com");
        when(speakerRepository.saveSpeaker(speaker)).thenReturn(0);
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        registerBusiness.register(speakerRepository, speaker);
        // Assert
        verify(speakerRepository).saveSpeaker(speaker);
        verify(speakerRepository, times(1)).saveSpeaker(speaker);
    }

}