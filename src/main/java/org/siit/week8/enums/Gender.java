package org.siit.week8.enums;

public enum Gender {
    MALE(0),
    FEMALE(1);

    private final int dbValue;

    Gender(int dbValue) {
        this.dbValue = dbValue;
    }

    public static Gender fromNumber(int dbValue) {
        if (dbValue == MALE.dbValue) {
            return MALE;
        }
        return FEMALE;
    }

}
