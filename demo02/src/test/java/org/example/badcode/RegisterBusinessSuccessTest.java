package org.example.badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StubSpeakerRepository implements SpeakerRepository {
    private Integer id;

    public void initData(int expectedId) {
        this.id = expectedId;
    }
    @Override
    public Integer saveSpeaker(Speaker speaker) {
        return this.id;
    }
}

public class RegisterBusinessSuccessTest {

    @Test
    @DisplayName("Register success with id = 5")
    public void register_success(){
        // Arrange
        StubSpeakerRepository stub = new StubSpeakerRepository();
        stub.initData(11);

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

    @Test
    @DisplayName("Register failure !!")
    public void register_failure(){
        // Arrange
        SpeakerRepository stub = new StubSpeakerExceptionRepository();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Somkiat");
        speaker.setLastName("Pui");
        speaker.setEmail("xxxx@gmail.com");

        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        assertThrows(SaveSpeakerException.class, ()-> {
            registerBusiness.register(stub, speaker);
        });
    }

}

class StubSpeakerExceptionRepository implements SpeakerRepository {
    @Override
    public Integer saveSpeaker(Speaker speaker) {
        throw new RuntimeException("Can not save to database");
    }
}