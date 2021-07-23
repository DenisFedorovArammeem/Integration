package com.swtestacademy;

import io.qameta.allure.TmsLink;
import org.json.simple.JSONObject;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.junit.runner.Description;
import org.testng.ITestContext;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JUnitProject extends Base
{
	//private static String PROJECT_ID = "1";
	//private static APIClient client = null;
	private static Long runId;
	private static String caseId = "";
	private static int FAIL_STATE = 5;
	private static int SUCCESS_STATE = 1;

	@Rule
	public TestName testName = new TestName();

//	@BeforeClass
//	public static void createSuite() throws APIException {
//		//Login to API
//		client = new APIClient("https://em6yxnfsmo.testrail.io");
//		client.setUser("denis.f@qamadness.com");
//		client.setPassword("YSPbJiBPJENd3qL5XxsT");
//		//Create Test Run
//		Map data = new HashMap();
//		data.put("include_all",true);
//		data.put("name","Test Run "+System.currentTimeMillis());
//		JSONObject c = (JSONObject)client.sendPost("add_run/"+PROJECT_ID,data);
//		//Extract Test Run Id
//		runId = (Long)c.get("id");





	@TmsLink("1")
	@Test
	public void validLogin()
	{
		Assert.assertTrue(true);
	}

	@TmsLink("2")
	@Test
	public void invalidLogin()
	{
		Assert.assertTrue(false);
	}
}