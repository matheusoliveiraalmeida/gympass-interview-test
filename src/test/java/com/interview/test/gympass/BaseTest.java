package com.interview.test.gympass;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BaseTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    void exceptionTest(Class<? extends Throwable> exception, String message) {
        expectedEx.expect(exception);
        expectedEx.expectMessage(message);
    }

    String getFileLog() {
        String projectDir = System.getProperty("user.dir");
        return projectDir + "/target/classes/corrida_kart.log";
    }

}
