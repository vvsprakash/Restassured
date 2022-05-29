package com.stepdefinition;

import java.io.IOException;

import com.base.Baseclass;
import com.pojo.Loginpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookClass extends Baseclass {
	
	@Before
	public void beforeScenario() throws IOException {

		System.out.println(getPropertyValue("browserName"));
		getDriver(getPropertyValue("browserName"));
		System.out.println(getPropertyValue("url"));
		enterUrl("https://adactinhotelapp.com/");
		maximize();
		Loginpage login = new Loginpage();
		login.login(getPropertyValue("username"), getPropertyValue("password"));
		

	}
//	@After
//	private void afterScenario() {
//		closeCurrent();
//
//	}

}
