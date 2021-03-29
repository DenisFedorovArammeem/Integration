package com.swtestacademy;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;
import io.qameta.allure.TmsLink;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.List;

public class TestRailIntegration {

    TestRail testRail;
    Run run;


    @BeforeMethod
    public void beforeTest(ITestContext ctx, Method method) {
        TmsLink tmsLink = method.getAnnotation(TmsLink.class);
        ctx.setAttribute("caseId", tmsLink.value());
    }

    @BeforeSuite
    public void createSuite() {
        testRail = TestRail.builder("https://em6yxnfsmo.testrail.io", "denis.f@qamadness.com", "YSPbJiBPJENd3qL5XxsT").build();
        run = testRail.runs().add(1, new Run().setSuiteId(1).setName("Integration Suite " + Instant.now().getEpochSecond())).execute();
    }

    @AfterMethod
    public void afterTest(ITestResult result, ITestContext ctx) {
        int status;
        List<ResultField> customResultFields = testRail.resultFields().list().execute();
        if (result.isSuccess()) {
            status = 1;
        } else if (result.getStatus() == 3) {
            status = 2;
        } else {
            status = 5;
        }

        int caseId = Integer.parseInt((String) ctx.getAttribute("caseId"));
        testRail.results().addForCase(run.getId(), caseId, new Result().setStatusId(status), customResultFields).execute();
    }

    @AfterClass
    public void closeRun() {
        testRail.runs().close(run.getId()).execute();
    }
}
