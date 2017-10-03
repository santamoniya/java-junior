package com.acme.edu;

public interface SmartMessage {

    String consumeMessage(SmartMessage previousMessage);
    String makeFormatString();
}
