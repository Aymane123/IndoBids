package com.indoleads.exception;
/**
 * Wrapper for anything that goes wrong during formatting to an object
 */
public class FormatterException extends RuntimeException {
    public FormatterException(String message, Exception cause) {
        super(message, cause);
    }
}