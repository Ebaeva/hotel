package com.tinqinacademy.hotel.rest.exception;

public class RoomNumberNotExist extends RuntimeException {
    public RoomNumberNotExist(String format) {
        super("Room Number Not Exist");
    }
}
