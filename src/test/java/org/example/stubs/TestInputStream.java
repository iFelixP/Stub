package org.example.stubs;

import java.io.IOException;
import java.io.InputStream;

public class TestInputStream extends InputStream {

    private final String messageToResponde;

    public TestInputStream(String messageToRespond) {
        this.messageToResponde = messageToRespond;
    }
    
    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public byte[] readAllBytes() throws IOException {
        return messageToResponde.getBytes();
    }
}
