package com.indoleads.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message, Exception cause) {
        super(message, cause);
    }

}
