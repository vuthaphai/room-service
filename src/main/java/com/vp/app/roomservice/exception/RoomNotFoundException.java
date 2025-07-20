package com.vp.app.roomservice.exception;

public class RoomNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RoomNotFoundException(String roomId) {
        super("Room not found with id: " + roomId);
    }

    public RoomNotFoundException(String roomId, Throwable cause) {
        super("Room not found with id: " + roomId, cause);
    }
}
