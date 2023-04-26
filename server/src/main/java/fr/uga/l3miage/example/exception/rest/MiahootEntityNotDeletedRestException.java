package fr.uga.l3miage.example.exception.rest;

import fr.uga.l3miage.example.error.MiahootErrorCode;
import org.springframework.http.HttpStatus;

public class MiahootEntityNotDeletedRestException extends RuntimeException {
    public MiahootEntityNotDeletedRestException(String message) {
        super(message);
    }

    public MiahootEntityNotDeletedRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getHttpStatus() {return HttpStatus.NOT_FOUND;}

    public MiahootErrorCode getErrorCode(){return MiahootErrorCode.MIAHOOT_ENTITY_NOT_DELETED_ERROR;}
}

