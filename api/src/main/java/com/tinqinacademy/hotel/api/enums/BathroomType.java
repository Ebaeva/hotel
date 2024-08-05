package com.tinqinacademy.hotel.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BathroomType {
    SHARED("shared"),
    PRIVATE("private"),
    UNKNOWN("");

    private final String code;

    BathroomType(String name) {
        this.code = name;
    }

    @Override
    @JsonValue
    public String toString(){
        return code;
    }
    @JsonCreator
    public static BathroomType getByCode(String name){
        return Arrays
                .stream(BathroomType.values())
                .filter(bathroomType -> bathroomType.code.equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }


}
