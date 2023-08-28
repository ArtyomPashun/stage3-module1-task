package com.mjc.school.service.exception;

public class ServerError extends BaseException {

    public ServerError() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    public ServerError(String message) {
        super(ErrorCode.INTERNAL_SERVER_ERROR, message);
    }

    public ServerError(String message, Throwable cause) {
        super(ErrorCode.INTERNAL_SERVER_ERROR, message, cause);
    }

    public ServerError(ErrorCode errorCode, Throwable cause) {
        super(ErrorCode.INTERNAL_SERVER_ERROR, cause);
    }
}
