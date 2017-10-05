package com.acme.edu.Message;

import com.acme.edu.Exceptions.NumberOverflowException;

public interface SmartMessage {

    String consumeMessage(SmartMessage previousMessage) throws NumberOverflowException;
    String makeFormatString();
}
