package com.acme.edu;


public class Logger {

    private static SmartMessage smartMessage;
    private static final LoggerController loggerController = new LoggerController();

    public static void log(String message) {
        Logger.smartMessage = new StringSmartMessage(message);
        Logger.loggerController.consumeMessage(Logger.smartMessage);
    }

    public static void log(int message) {
        Logger.smartMessage = new PrimitiveIntSmartMessage(message);
        Logger.loggerController.consumeMessage(Logger.smartMessage);
    }

    public static void log(byte message) {
        Logger.smartMessage = new PrimitiveByteSmartMessage(message);
        Logger.loggerController.consumeMessage(Logger.smartMessage);
    }

    public static void log(int... message) {
        Logger.smartMessage = new ArraySmartMessage(message);
        Logger.loggerController.consumeMessage(Logger.smartMessage);
    }

    public static void log(char message) {
        Logger.smartMessage = new CharSmartMessage(message);
        Logger.loggerController.consumeMessage(Logger.smartMessage);
    }

    public static void close() {
        Logger.loggerController.close();
    }
}