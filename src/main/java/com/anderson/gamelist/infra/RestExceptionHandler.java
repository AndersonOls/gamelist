package com.anderson.gamelist.infra;

import com.anderson.gamelist.exceptions.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends RuntimeException{
    @ExceptionHandler(GameNotFoundException.class)
    private ResponseEntity<String> gameNotFoundHandler(GameNotFoundException gameNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gameNotFoundException.getMessage());
    }
}

