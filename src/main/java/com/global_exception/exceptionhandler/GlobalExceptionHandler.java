package com.global_exception.exceptionhandler;

import com.global_exception.entity.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(studentNotFoundException.getMessage());
    }

    @ExceptionHandler(StudentAlreadyExists.class)
    ResponseEntity<?> studentAlreadyExistsException(StudentAlreadyExists studentAlreadyExists) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(studentAlreadyExists.getMessage());
    }

    @ExceptionHandler(StudentDoesNotExist.class)
    ResponseEntity<?> studentNotExist(StudentDoesNotExist studentDoesNotExist) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(studentDoesNotExist.getMessage());
    }


}
