package com.swtestacademy;

import io.qameta.allure.TmsLink;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class TestNGProject extends Base {

    @TmsLink("1")
    @Test
    public void validLogin() {
        assertTrue(true);
    }

    @TmsLink("13")
    @Test
    public void invalidLogin() {
        assertTrue(false);
    }

    @TmsLink("65")
    @Test
    public void brokenTest() throws Exception {
        throw new SkipException("aaaa");
    }
}
