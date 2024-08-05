package com.tinqinacademy.hotel.persistence.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BathroomTypes {
    SHARED("shared"),
    PRIVATE("private"),
    UNKNOWN("unknown");

    private String code;

    BathroomTypes(String name) {
        this.code = name;
    }

    @Override
    @JsonValue
    public String toString(){
        return code;
    }
    @JsonCreator
    public static BathroomTypes getByCode(String name){
        return Arrays
                .stream(BathroomTypes.values())
                .filter(bathroomType -> bathroomType.code.equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }


}
