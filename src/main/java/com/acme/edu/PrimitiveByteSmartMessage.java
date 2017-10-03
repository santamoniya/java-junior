package com.acme.edu;

public class PrimitiveByteSmartMessage extends PrimitiveSmartMessage {
    public PrimitiveByteSmartMessage(byte message) {
        super(message);
        maxBorder = Byte.MAX_VALUE;
        minBorder = Byte.MIN_VALUE;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) {
        if (previousMessage == null) return null;

        if (!(previousMessage instanceof PrimitiveByteSmartMessage)) {
            return previousMessage.makeFormatString();
        }
        long previousSum = ((PrimitiveByteSmartMessage) previousMessage).sum;
        sum += previousSum;
        return null;
    }
}
