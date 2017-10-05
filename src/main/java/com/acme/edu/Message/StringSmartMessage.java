package com.acme.edu.Message;

public class StringSmartMessage implements SmartMessage {
    private int sameStringsCounter;
    private String message;
    private final String format = "string: ";

    public StringSmartMessage(String inputMessage) {
        sameStringsCounter = 1;
        message = inputMessage;
    }

    public String makeFormatString(){
        String output = format + message;
        if (sameStringsCounter > 1){
            output += " (x" + sameStringsCounter + ")";
        }
        sameStringsCounter = 1;
        return output;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) {
        if (previousMessage == null) return null;
        if (!(previousMessage instanceof StringSmartMessage )) {
            return previousMessage.makeFormatString();
        }

        boolean messagesEqual = message.equals(((StringSmartMessage) previousMessage).message);
        if (messagesEqual){
            int lastSameStringsCounter = ((StringSmartMessage) previousMessage).sameStringsCounter;
            sameStringsCounter = ++lastSameStringsCounter;
            return null;
        } else {
            return previousMessage.makeFormatString();
        }
    }
}
