package com.acme.edu;


import com.acme.edu.Message.*;

public class Logger {

    private static final LoggerController loggerController = new LoggerController();

        public static void log(String message){
            SmartMessage smartMessage = new StringSmartMessage(message);
            loggerController.consumeMessage(smartMessage);
        }

        public static void log(int message) {
            SmartMessage smartMessage = new PrimitiveIntSmartMessage(message);
            loggerController.consumeMessage(smartMessage);
        }

        public static void log(byte message) {
            SmartMessage smartMessage = new PrimitiveByteSmartMessage(message);
            loggerController.consumeMessage(smartMessage);
        }

        public static void log(int... message) {
            SmartMessage smartMessage = new ArraySmartMessage(message);
            loggerController.consumeMessage(smartMessage);
        }

        public static void log(char message) {
            SmartMessage smartMessage = new CharSmartMessage(message);
            loggerController.consumeMessage(smartMessage);
        }

        public static void close() {
            Logger.loggerController.close();
        }
}