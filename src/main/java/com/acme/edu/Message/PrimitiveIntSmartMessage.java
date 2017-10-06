package com.acme.edu.Message;

import com.acme.edu.Exceptions.NumberOverflowException;

public class PrimitiveIntSmartMessage extends PrimitiveSmartMessage {

    public PrimitiveIntSmartMessage(int message) {
        super(message);
        this.maxBorder = Integer.MAX_VALUE;
        this.minBorder = Integer.MIN_VALUE;
    }

    @Override
    public String consumeMessage(SmartMessage previousMessage) throws NumberOverflowException {
        if (previousMessage == null) return null;

        if (!(previousMessage instanceof PrimitiveIntSmartMessage)) {
            return previousMessage.makeFormatString();
        }
        long previousSum = ((PrimitiveIntSmartMessage) previousMessage).sum;
        if (checkNumberOverflow(previousSum) ) {
            sum = 0;
            throw new NumberOverflowException("Long overflow");
        }
        sum += previousSum;
        return null;
    }

}
