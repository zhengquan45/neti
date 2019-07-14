package com.zhq.neti.exception;

/**
 * @author zhengquan
 * @date 2017/10/26
 */
public class PermissionException extends RuntimeException {
    protected PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException() {
        super();
    }
}
