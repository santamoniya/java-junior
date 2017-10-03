package com.acme.edu;

public abstract class PrimitiveSmartMessage implements SmartMessage {

    protected long sum;
    protected int message;
    protected final String format = "primitive: ";
    protected int maxBorder;
    protected int minBorder;

    protected PrimitiveSmartMessage(int inputMessage) {
        message = inputMessage;
        sum = inputMessage;
    }

    @Override
    public abstract String consumeMessage(SmartMessage previousMessage);

    @Override
    public String makeFormatString() {
        String output = "";
        if (sum > 0) {
            while (sum > maxBorder) {
               output += "\n" + maxBorder;
               sum -= maxBorder;
            }
        } else {
            while (sum < minBorder) {
                output += "\n" + minBorder;
                sum -= minBorder;
            }
        }

        return format + sum + output;
    }
}
