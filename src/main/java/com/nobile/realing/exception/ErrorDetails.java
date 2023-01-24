package com.nobile.realing.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ErrorDetails {
    private HttpStatus status;
    private List<String> errors;

    public ErrorDetails(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ErrorDetails(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        errors = Arrays.asList(error);
    }
}