package com.mvc.demo.exception.handler;

import com.mvc.demo.exception.StudentAlreadyExistsException;
import com.mvc.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class,
            StudentAlreadyExistsException.class})
    public ResponseEntity<String> methodArgumentExceptionHandling(
            Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<String> studentNotFound(StudentNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


}
