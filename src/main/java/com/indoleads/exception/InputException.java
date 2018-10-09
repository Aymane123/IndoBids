package com.indoleads.exception;

/**
 * Wrapper for anything that goes wrong during conversions to Domain Entitiies
 */
public class InputException extends RuntimeException {
    public InputException(String message, Exception cause) {
        super(message, cause);
    }
}
