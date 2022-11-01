package com.grade.tracker.shared.exception;

public class InternalException extends Exception{
    public InternalException(final String message) {
        super(message);
    }

    public InternalException(final String message,final Throwable cause) {
        super(message, cause);
    }
}
