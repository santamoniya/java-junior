package com.acme.edu;

public class PrimitiveIntSmartMessage extends PrimitiveSmartMessage {

    public PrimitiveIntSmartMessage(int message) {
        super(message);
        this.maxBorder = Integer.MAX_VALUE;
        this.minBorder = Integer.MIN_VALUE;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) {
        if (previousMessage == null) return null;

        if (!(previousMessage instanceof PrimitiveIntSmartMessage)) {
            return previousMessage.makeFormatString();
        }
        long previousSum = ((PrimitiveIntSmartMessage) previousMessage).sum;
        sum += previousSum;
        return null;
    }

}
