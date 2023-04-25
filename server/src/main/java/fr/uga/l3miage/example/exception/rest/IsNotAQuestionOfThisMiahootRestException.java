package fr.uga.l3miage.example.exception.rest;

import fr.uga.l3miage.example.error.ErrorCode;
import org.springframework.http.HttpStatus;

public class IsNotAQuestionOfThisMiahootRestException extends RuntimeException{
    public IsNotAQuestionOfThisMiahootRestException(String message) {
        super(message);
    }

    public IsNotAQuestionOfThisMiahootRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    public ErrorCode getErrorCode(){return ErrorCode.IS_NOT_A_QUESTION_OF_THIS_MIAHOOT; }

}