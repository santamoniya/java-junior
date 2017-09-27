package com.acme.edu;

public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";

    public static void log(int message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }
}