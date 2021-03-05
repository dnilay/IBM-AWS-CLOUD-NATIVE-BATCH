package com.example;

public enum Day {
    SUNDAY("Day is Sunday"),
    MONDAY("Day Is Monday"),
    TUESDAY("Day Is Tuesday"),
    THURSDAY("Day Is Thursday"),
    FRIDAY("Day Is Friday"),
    SATURDAY("Day Is Saturday");

    private final String day;

    private Day(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
