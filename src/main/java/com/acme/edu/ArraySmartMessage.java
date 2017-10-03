package com.acme.edu;

public class ArraySmartMessage implements SmartMessage {
    private int[] message;
    private final String format = "primitives array: ";

    public ArraySmartMessage(int... inputMessage) {
        this.message = inputMessage;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) {
        if (previousMessage == null) return null;
        if (!(previousMessage instanceof ArraySmartMessage )) {
            return previousMessage.makeFormatString();
        }
        return null;
    }

    @Override
    public String makeFormatString() {
        String output = format + "{";
        for (int i = 0; i < message.length - 1; i++) {
            output += message[i] + ", ";
        }
        output += message[message.length - 1] + "}";
        return output;
    }
}
