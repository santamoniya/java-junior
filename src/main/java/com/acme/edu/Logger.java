package com.acme.edu;


public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String ARRAY_PREFIX ="primitives array: ";
    private static int currentSumm = 0;
    private static String currentString = "";
    private static int maxValueCounter = 0;
    private static int minValueCounter = 0;
    private static final byte
                            START_STATE = 0,
                            INT_STATE = 1,
                            BYTE_STATE = 2,
                            STRING_STATE = 3,
                            CHAR_STATE = 4,
                            ARRAY_STATE = 5,
                            FINAL_STATE = 6;

    private static byte
                        state = START_STATE,
                        previous_state = START_STATE;

    public static void log(int... array) {
        state = ARRAY_STATE;

        if (printNeeded()) {
            checkPrint();
        }
        printArray(array);
        previous_state = state;
    }

    public static void log(int message) {
        state = INT_STATE;

        if (printNeeded()) {
            checkPrint();
        }
        currentSumm +=  returnValidValueInt(message);
        previous_state = state;
    }

    public static void log(byte message) {
        state = BYTE_STATE;

        if (printNeeded() ) {
            checkPrint();
        }
        currentSumm +=  returnValidValueByte(message);
        previous_state = state;
    }

    public static void log(char message) {
        state = CHAR_STATE;

        print(CHAR_PREFIX + message);
        previous_state = state;
    }

    public static void log(String message) {
        state = STRING_STATE;

        boolean stringsNotEqual = !message.equals(currentString);
        if (printNeeded() || stringsNotEqual) {
            checkPrint();
        }
        currentSumm++;
        currentString = message;
        previous_state = state;
    }

    public static void close() {
        state = FINAL_STATE;
        checkPrint();
        previous_state = state = START_STATE;
    }

    private static boolean printNeeded() {
        return state != previous_state && previous_state != START_STATE;
    }

    private static void checkPrint() {
        switch (previous_state) {
            case INT_STATE:
                printInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
                break;
            case STRING_STATE:
                printString();
                break;
            case BYTE_STATE:
                printInt(Byte.MIN_VALUE, Byte.MAX_VALUE);
        }
    }

    private static void printInt(int min_value, int max_value) {
        print(PRIMITIVE_PREFIX + currentSumm);
        if(maxValueCounter > 0) {
            for (int i = 0; i < maxValueCounter; i++) {
                System.out.println(max_value);
            }
            maxValueCounter = 0;
        }
        if (minValueCounter > 0) {
            for (int i = 0; i < minValueCounter ; i++) {
                System.out.println(min_value);
            }
            minValueCounter = 0;
        }
        currentSumm = 0;
    }

    private static void printString() {
        System.out.print(STRING_PREFIX + currentString);
        if (currentSumm > 1) {
            System.out.print(" (x" + currentSumm + ")");
        }
        System.out.println();
        currentSumm = 0;
    }

    private static void printArray(int... array) {
        System.out.print(ARRAY_PREFIX + "{");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "}");
    }

    private static void print(String x) {
        System.out.println(x);
    }

    private static int returnValidValueInt(int message) {
        return returnValidValue(message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static byte returnValidValueByte(byte message) {
        return (byte) returnValidValue(message, Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    private static int returnValidValue(int message, int max_border, int min_border){
        if(message >= 0){
            return checkIntOverflowMax(message, max_border);
        } else {
            return checkIntOverflowMin(message, min_border);
        }
    }

    private static int checkIntOverflowMax(int message, int max_border){
        if(currentSumm < max_border - message){
            return message;
        }
        else {
            maxValueCounter++;
            return max_border - message;
        }
    }

    private static int checkIntOverflowMin(int message, int min_border){
        if(currentSumm > min_border + message){
            return message;
        }
        else {
            minValueCounter++;
            return min_border + message;
        }
    }
}