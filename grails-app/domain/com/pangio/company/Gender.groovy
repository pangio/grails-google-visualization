package com.pangio.company

public enum Gender {

    MALE,
    FEMALE;

    public static Gender getRandom() {
        return values()[(int) (Math.random() * values().size())];
    }

}