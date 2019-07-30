package com.zhq.neti.exception;

public class NotFoundConverterException extends RuntimeException {
    public NotFoundConverterException() {
        super();
    }

    public NotFoundConverterException(String message) {
        super(message);
    }

    public NotFoundConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundConverterException(Throwable cause) {
        super(cause);
    }

    protected NotFoundConverterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}