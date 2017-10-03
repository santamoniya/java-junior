package com.acme.edu;

public class LoggerController {

    private SmartMessage previousMessage = null;
    private Saver saver = new ConsoleSaver();

    public void setPreviousMessage(SmartMessage previousMessage) {
        this.previousMessage = previousMessage;
    }

    void consumeMessage(SmartMessage inputMessage) {
        String formattedMessage = inputMessage.consumeMessage(previousMessage);
        if (formattedMessage != null) {
            saver.save(formattedMessage);
        }
        setPreviousMessage(inputMessage);
    }

    void close() {
        String formattedMessage = previousMessage.makeFormatString();
        saver.save(formattedMessage);
        setPreviousMessage(null);
    }
}
