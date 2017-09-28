package com.acme.edu;

public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";


    public static void log(int message) {
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        print(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        print(STRING_PREFIX + message);
    }

    private static void print(String x) {
        System.out.println(x);
    }


}