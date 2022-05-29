package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class BookingConfirm extends Baseclass {
	public BookingConfirm() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	WebElement txtBookingConfirm;
	public WebElement getTxtBookingConfirm() {
		return txtBookingConfirm;
	}
	@FindBy(id="order_no")
	private WebElement txtOrderno;
	public WebElement getTxtOrderno() {
		return txtOrderno;
	}
	public void BookingConfirm(String Orderno) {
		type(getTxtOrderno(), Orderno);
//		System.out.println(Orderno);

	}	

}

