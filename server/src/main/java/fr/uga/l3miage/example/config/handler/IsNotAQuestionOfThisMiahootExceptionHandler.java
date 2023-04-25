package fr.uga.l3miage.example.config.handler;

import fr.uga.l3miage.example.error.ErrorResponse;
import fr.uga.l3miage.example.error.IsNotAQuestionOfThisMiahootErrorResponse;
import fr.uga.l3miage.example.error.TestIntIsZeroErrorResponse;
import fr.uga.l3miage.example.error.TestNotFoundErrorResponse;
import fr.uga.l3miage.example.exception.rest.IsNotAQuestionOfThisMiahootRestException;
import fr.uga.l3miage.example.exception.rest.TestEntityNotFoundRestException;
import fr.uga.l3miage.example.exception.rest.TestIntIsZeroRestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ConditionalOnWebApplication
@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
public class IsNotAQuestionOfThisMiahootExceptionHandler {

    @ExceptionHandler(IsNotAQuestionOfThisMiahootRestException.class)
    public ResponseEntity<ErrorResponse> handle(HttpServletRequest httpServletRequest, Exception exception){
        IsNotAQuestionOfThisMiahootRestException ex = (IsNotAQuestionOfThisMiahootRestException) exception;
        final IsNotAQuestionOfThisMiahootErrorResponse response = IsNotAQuestionOfThisMiahootErrorResponse.builder()
                .uri(httpServletRequest.getRequestURI())
                .httpStatus(ex.getHttpStatus())
                .errorMessage(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build();
        log.warn(ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }

}