package com.sprinter.demo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        log.error("Se ha producido la siguiente excepcion: " + ex.getMessage());
        ErrorMessage message = ErrorMessage.builder().code(HttpStatus.NOT_FOUND.value()).
                date(new Date()).message(ex.getMessage()).description(request.getDescription(false)).build();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        log.error("Se ha producido la siguiente excepcion: " + ex.getMessage());
        ErrorMessage message = ErrorMessage.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).
                date(new Date()).message(ex.getMessage()).description(request.getDescription(false)).build();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Se ha producido la siguiente excepcion: " + ex.getMessage());
        ErrorMessage errorMessage = ErrorMessage.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).
                date(new Date()).message(ex.getMessage()).description(request.getDescription(false)).build();
        //          new ErrorMessage(new Date(), "Validation Failed",
        //        ex.getBindingResult().toString());
        return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
