package com.integrador.back.backintegrador.exception;


import com.integrador.back.backintegrador.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ConfigHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleEnteredDataNotFound(HttpServletRequest request,
                                                       NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildResponse(e.getMessage(), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(HttpServletRequest request, BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(buildResponse(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(UnautorizedException.class)
    public ResponseEntity<?> handleUnautorized(BadRequestException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(buildResponse(e.getMessage(), HttpStatus.UNAUTHORIZED));
    }

    private ErrorResponse buildResponse(String message, HttpStatus httpStatus) {
        return new ErrorResponse(message, httpStatus.value());
    }

}
