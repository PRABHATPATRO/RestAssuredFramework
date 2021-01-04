package com.AutomationProject.setupFiles;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.AutomationProject.configProperties.ConfigProperties;

import io.restassured.*;

public class TestSetup {
	
	public static ConfigProperties configProp ;
	
	@BeforeSuite
	public void setUpFramework()
	{
		configProp = ConfigFactory.create(ConfigProperties.class);//mandatory step to initialize configprop object
		RestAssured.baseURI = configProp.getbaseURI();
		RestAssured.basePath = configProp.getBasePath();
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");

	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");

	}
	//using Method class is a part of reflection concept which is responsible of 
	//printing the method name that is going to execute post beforemethod 
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		System.out.println("Test case : "+ method.getName() + " started" );

	}
	//Using the Listener class ITestResult, It is going to print the method name 
	// after the execution completed
	@AfterMethod
	public void afterMethod(ITestResult testCaseResult)
	{
		System.out.println("Test Case: " + testCaseResult.getName() + " completed");

	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");

	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After class");

	}
	@AfterSuite
	public void cleanUp()
	{
		System.out.println("After suite");

	}
	
	

}
