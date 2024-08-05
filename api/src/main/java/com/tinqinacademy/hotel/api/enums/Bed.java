package com.tinqinacademy.hotel.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

public enum Bed {
    SINGLE("single"),
    SMALL_DOUBLE("smallDouble"),
    DOUBLE("double"),
    QUEEN_SIZE("queenSize"),
    KING_SIZE("kingSize"),
    UNKNOWN("");

    @Getter
    final String code;
    Bed(String name) {
        this.code = name;
    }

    @JsonValue
    @Override
    public String toString(){
        return code;
    }
    @JsonCreator
    public static Bed getByCode(String name){
        return Arrays.stream(Bed.values())
                .filter(bedType -> bedType.code.equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
