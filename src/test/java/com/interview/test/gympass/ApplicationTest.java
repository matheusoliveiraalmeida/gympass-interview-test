package com.interview.test.gympass;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class ApplicationTest extends BaseTest {

    @Test
    public void testApplicationSuccess() throws IOException {
        Application.main(new String[] { getFileLog() });
    }

    @Test
    public void testApplicationInvalidFile() throws IOException {
        exceptionTest(NoSuchFileException.class, "teste");

        Application.main(new String[] { "teste" });
    }

    @Test
    public void testApplicationNoFile() throws IOException {
        exceptionTest(FileNotFoundException.class, "File not found.");

        String[] args = new String[0];

        Application.main(args);
    }

}
