package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class SelectHotel extends Baseclass {

	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnSelect;
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	public WebElement getBtnSelect() {
		return btnSelect;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	public void selectHotel() {
		click(getBtnSelect());
		click(getBtnContinue());
		
		
		
		
	}

}
