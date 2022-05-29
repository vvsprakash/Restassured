package com.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
@RunWith(Cucumber.class)

@CucumberOptions(snippets=SnippetType.CAMELCASE,dryRun=false,features="src/test/resources",glue = {"com.stepdefinition"},plugin= {"pretty","json:\\src\\test\\resources\\Adactin\\Adctin.json"},monochrome=true)


public class TestRunner {

	@AfterClass
	public static void AfterClass() {
		Reporting.generateJvmReport("C:\\Users\\Admin\\eclipse-workspace\\Adactinhotel\\src\\test\\resources\\Adactin\\Adactin.json");

	}
	
		
		
		
		
}