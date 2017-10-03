package com.acme.edu;

public class CharSmartMessage implements SmartMessage {

    private final String format = "char: ";
    private char message;

    public CharSmartMessage(char inputMessage) {
        message = inputMessage;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) {
        if (previousMessage == null) return null;
        if (!(previousMessage instanceof CharSmartMessage )) {
            return previousMessage.makeFormatString();
        }
        return null;
    }

    @Override
    public String makeFormatString() {
        return format + message;
    }
}
