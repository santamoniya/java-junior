package com.acme.edu;

import com.acme.edu.Exceptions.NumberOverflowException;
import com.acme.edu.Message.SmartMessage;
import com.acme.edu.Saver.ConsoleSaver;
import com.acme.edu.Saver.Saver;

public class LoggerController {

    private SmartMessage previousMessage = null;
    private Saver saver = new ConsoleSaver();

    private void setPreviousMessage(SmartMessage previousMessage) {
        this.previousMessage = previousMessage;
    }

    void consumeMessage(SmartMessage inputMessage) {
        try {
            String formattedMessage = inputMessage.consumeMessage(previousMessage);
            if (formattedMessage != null) {
                saver.save(formattedMessage);
            }
        } catch (NumberOverflowException e) {
            System.out.println(e.getMessage());
        }
        setPreviousMessage(inputMessage);
    }

    void close() {
        String formattedMessage = previousMessage.makeFormatString();
        if (formattedMessage != null) {
            saver.save(formattedMessage);
        }
        setPreviousMessage(null);
    }
}
