package org.example.badcode;

public class SpeakerDoesntMeetRequirementsException extends RuntimeException {
    public SpeakerDoesntMeetRequirementsException(String message) {
        super(message);
    }
}
