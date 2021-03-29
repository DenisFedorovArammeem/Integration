package com.swtestacademy;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;
import io.qameta.allure.TmsLink;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Unit test for simple App.
 */
public class TestNGProject extends Base {

    @TmsLink("1")
    @Test
    public void validLogin() {
        Assert.assertTrue(true);
    }

    @TmsLink("13")
    @Test
    public void invalidLogin() {
        Assert.assertTrue(false);
    }

    @TmsLink("65")
    @Test
    public void brokenTest() throws Exception {
        throw new SkipException("aaaa");
    }
}
