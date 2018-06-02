package com.cheney.satisfy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "未登录")
public class UnLoginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnLoginException() {
    }

    public UnLoginException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UnLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnLoginException(String message) {
        super(message);
    }

    public UnLoginException(Throwable cause) {
        super(cause);
    }

}
