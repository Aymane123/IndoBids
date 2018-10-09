package com.indoleads.exception;

public class FileInputException extends RuntimeException{
    public FileInputException(String message, Exception cause) {
        super(message, cause);
    }
}
