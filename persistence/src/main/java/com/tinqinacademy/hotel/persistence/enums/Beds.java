package com.tinqinacademy.hotel.persistence.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;


public enum Beds {
    SINGLE("single", 1),
    SMALL_DOUBLE("smallDouble", 2),
    DOUBLE("double", 2),
    QUEEN_SIZE("queenSize", 3),
    KING_SIZE("kingSize", 3),
    UNKNOWN("", 0);

    @Getter
    private final String code;
    @Getter
    private final Integer size;

    Beds(String name, Integer size) {
        this.code = name;
        this.size = size;
    }


    @JsonValue
    @Override
    public String toString() {
        return code;
    }
    @JsonCreator
    public Integer getCapacity(){return size;}

    @JsonCreator
    public static Beds getByCode(String name) {
        return Arrays.stream(Beds.values())
                .filter(bedType -> bedType.code.equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
