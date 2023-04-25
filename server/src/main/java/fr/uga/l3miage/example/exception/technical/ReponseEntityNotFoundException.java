package fr.uga.l3miage.example.exception.technical;

import lombok.Getter;

/**
 * Exception technique
 */
@Getter
public class ReponseEntityNotFoundException extends Exception {

    private final String description;

    public ReponseEntityNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }

    public ReponseEntityNotFoundException(String message, String description, Throwable cause) {
        super(message, cause);
        this.description = description;
    }
}
