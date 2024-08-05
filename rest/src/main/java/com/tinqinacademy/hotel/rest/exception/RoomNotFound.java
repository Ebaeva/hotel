package com.tinqinacademy.hotel.rest.exception;

public class RoomNotFound extends RuntimeException{
    public RoomNotFound(String message){
        super(message);
    }
}
