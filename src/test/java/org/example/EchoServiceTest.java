package org.example;

import org.example.stubs.TestInputStream;
import org.example.stubs.TestOutputStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class EchoServiceTest {

    @Test
    public void givenValidRequestAndResponse_whenEcho_theTrueIsResponse() throws IOException {

        // Given:
        EchoService echoService = new EchoService();
        String request = "Hello World!";
        TestOutputStream outputStream = new TestOutputStream();
        InputStream inputStream = new TestInputStream(request);

        // When:
        boolean response = echoService.sendEchoMessage(request, outputStream, inputStream);

        // Then:
        String messageSent = outputStream.getMessageSent();

        assertEquals(request, messageSent);

        assertTrue(response);
    }

    @Test
    public void givenValidRequestAndWrongResponse_whenEcho_theFalseIsResponse() throws IOException {
        // Given:
        EchoService echoService = new EchoService();
        String request = "Hello World!";

        TestOutputStream outputStream = new TestOutputStream();
        InputStream inputStream = new TestInputStream("Otra cosa");

        // When:
        boolean response = echoService.sendEchoMessage(request, outputStream, inputStream);

        // Then:
        String messageSent = outputStream.getMessageSent();

        assertEquals(request, messageSent);

        assertFalse(response);
    }
}
