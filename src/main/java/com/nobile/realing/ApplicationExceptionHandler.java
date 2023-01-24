package com.nobile.realing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nobile.realing.exception.ErrorDetails;
import com.nobile.realing.exception.custom.EntityNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> errorStatusMessage(List<String> errors, HttpStatus status) {
        ErrorDetails errorDetails = new ErrorDetails(
                status,errors);
        return new ResponseEntity<Object>(
                errorDetails, new HttpHeaders(), errorDetails.getStatus());
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex) {
        return errorStatusMessage(Arrays.asList(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        return errorStatusMessage(errorList,HttpStatus.BAD_REQUEST);
    }

}
