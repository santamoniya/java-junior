package com.acme.edu.Message;

import com.acme.edu.Exceptions.NumberOverflowException;

public abstract class PrimitiveSmartMessage implements SmartMessage {

    protected long sum;
    protected int message;
    protected final String format = "primitive: ";
    protected int maxBorder;
    protected int minBorder;

    protected PrimitiveSmartMessage(int inputMessage) {
        this.message = inputMessage;
        this.sum = inputMessage;
    }

    @Override
    public abstract String consumeMessage(SmartMessage previousMessage) throws NumberOverflowException;

    boolean checkNumberOverflow(long previousSum) {
        if (sum > 0 && Integer.MAX_VALUE - sum < previousSum) {
            return true;
        }
        if (sum < 0 && Integer.MIN_VALUE - sum > previousSum) {
            return true;
        }
        return false;
    }

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
