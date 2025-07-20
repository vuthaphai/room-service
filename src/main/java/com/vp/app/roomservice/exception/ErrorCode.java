package com.vp.app.roomservice.exception;

public enum ErrorCode {
    ROOM_NOT_FOUND("ROOM_NOT_FOUND", "The requested room was not found."),
    INVALID_ROOM_ID("INVALID_ROOM_ID", "The provided room ID is invalid."),
    DATABASE_ERROR("DATABASE_ERROR", "An error occurred while accessing the database."),
    UNAUTHORIZED_ACCESS("UNAUTHORIZED_ACCESS", "You do not have permission to access this resource."),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "An unexpected error occurred. Please try again later."),
    CONSTRAIN_VIOLATION("CONSTRAIN_VIOLATION", "Constraint violation occurred."),
    SYSTEM_ERROR("SYSTEM_ERROR", "An unexpected system error occurred.");;


    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
