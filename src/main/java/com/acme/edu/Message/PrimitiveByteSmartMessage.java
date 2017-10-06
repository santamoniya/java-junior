package com.acme.edu.Message;

import com.acme.edu.Exceptions.NumberOverflowException;

public class PrimitiveByteSmartMessage extends PrimitiveSmartMessage {
    public PrimitiveByteSmartMessage(byte message) {
        super(message);
        this.maxBorder = Byte.MAX_VALUE;
        this.minBorder = Byte.MIN_VALUE;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) throws NumberOverflowException {
        if (previousMessage == null) return null;

        if (!(previousMessage instanceof PrimitiveByteSmartMessage)) {
            return previousMessage.makeFormatString();
        }
        long previousSum = ((PrimitiveByteSmartMessage) previousMessage).sum;
        if (checkNumberOverflow(previousSum) ) {
            sum = 0;
            throw new NumberOverflowException("Long overflow");
        }
        sum += previousSum;
        return null;
    }
}
