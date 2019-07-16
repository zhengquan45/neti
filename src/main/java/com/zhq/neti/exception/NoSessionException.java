package com.zhq.neti.exception;

public class NoSessionException extends RuntimeException {
    public NoSessionException() {
        super();
    }

    public NoSessionException(String message) {
        super(message);
    }

    public NoSessionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSessionException(Throwable cause) {
        super(cause);
    }

    protected NoSessionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
