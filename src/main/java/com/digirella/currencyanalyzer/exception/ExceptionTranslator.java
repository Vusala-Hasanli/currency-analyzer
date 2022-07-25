package com.digirella.currencyanalyzer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage illegalArgumentException(IllegalArgumentException ex) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
    }

    @ExceptionHandler(value = RestClientException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage restClientException(RestClientException ex) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
    }
}
