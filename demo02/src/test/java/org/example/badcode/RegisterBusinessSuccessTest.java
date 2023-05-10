package org.example.badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StubSpeakerRepository implements SpeakerRepository {

    @Override
    public Integer saveSpeaker(Speaker speaker) {
        return 1000;
    }
}

public class RegisterBusinessSuccessTest {

    @Test
    @DisplayName("Register success with id = 5")
    public void register_success(){
        // Arrange
        SpeakerRepository stub = new StubSpeakerRepository();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Somkiat");
        speaker.setLastName("Pui");
        speaker.setEmail("xxxx@gmail.com");

        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        int actualResult = registerBusiness.register(stub, speaker);
        // Assert
        assertEquals(1000, actualResult);

    }

}