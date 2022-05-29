package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class Loginpage extends Baseclass {
	
	
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="username")
private WebElement txtUsername;

@FindBy(id="password")
private WebElement txtpassword;

@FindBy(id="login")
private WebElement btnLogin;

public WebElement getTxtUsername() {
	return txtUsername;
}

public WebElement getTxtpassword() {
	return txtpassword;
}

public WebElement getBtnLogin() {
	return btnLogin;
}


public void login (String username, String password) {
	type(getTxtUsername(), username);
	type(getTxtpassword(), password);
	
	click(getBtnLogin());
	
}
}
