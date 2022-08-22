package com.inoptra.employeedepartmentdemo.exceptions;

import com.inoptra.employeedepartmentdemo.models.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorModel> handleDepartmentNotFoundException(RuntimeException ex) {
        return new ResponseEntity<>(getErrorModel(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorModel> handleEmployeeNotFoundException(RuntimeException ex) {
        return new ResponseEntity<>(getErrorModel(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        String msg = "Oops! Something went wring we are looking into it!";
        return new ResponseEntity<>(getErrorModel(HttpStatus.INTERNAL_SERVER_ERROR, msg),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorModel getErrorModel(HttpStatus httpStatus, String message) {
        return ErrorModel.builder().timeStamp(LocalDateTime.now()).errorCode(httpStatus.value()).userMessage(message)
                         .build();
    }
}
