package com.tinqinacademy.hotel.rest.exception;

public class RoomAlreadyExist extends RuntimeException{
    public RoomAlreadyExist(String message) {
        super(message);
    }
}
