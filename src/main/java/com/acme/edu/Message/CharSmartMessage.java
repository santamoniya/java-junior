package com.acme.edu.Message;

public class CharSmartMessage implements SmartMessage {

    private final String format = "char: ";
    private char message;

    public CharSmartMessage(char inputMessage) {
        this.message = inputMessage;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) {
        if (previousMessage == null) return null;
        return previousMessage.makeFormatString();
    }

    @Override
    public String makeFormatString() {
        return format + message;
    }
}
