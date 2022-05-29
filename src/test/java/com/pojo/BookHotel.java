package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class BookHotel extends Baseclass {
	
	
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	WebElement txtBookHotel;

	public WebElement getTxtBookHotel() {
		return txtBookHotel;
	}
	@FindBy(id="first_name")
	private WebElement txtFirstname;
	
	@FindBy(id="last_name")
	private WebElement txtLastname;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCreditNumber;
	
	@FindBy(id="cc_type")
	private WebElement DdnCreditCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement DdnExpierdMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement DdnExpierdYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCVVNmuber;
	
	
	@FindBy(id="book_now")
	private WebElement btnBook;


	public WebElement getTxtFirstname() {
		return txtFirstname;
	}


	public WebElement getTxtLastname() {
		return txtLastname;
	}


	public WebElement getTxtAddress() {
		return txtAddress;
	}


	public WebElement getTxtCreditNumber() {
		return txtCreditNumber;
	}


	public WebElement getDdnCreditCardType() {
		return DdnCreditCardType;
	}


	public WebElement getDdnExpierdMonth() {
		return DdnExpierdMonth;
	}


	public WebElement getDdnExpierdYear() {
		return DdnExpierdYear;
	}


	public WebElement gettxtCVVNmuber() {
		return gettxtCVVNmuber();
	}


	public WebElement getBtnBook() {
		return btnBook;
	}
	
	public void bookHote(String Firstname, String Lastname,String Address,String CreditNumber,
			String CreditCardType, String ExpierdMonth,String ExpierdYear,String CVVNmuber) {

type(getTxtFirstname(), Firstname);
type(getTxtLastname(), Lastname);
type(getTxtAddress(), Address);
type(getTxtCreditNumber(), CreditNumber);
selectOptionText(getDdnCreditCardType(), CreditCardType);
selectOptionText(getDdnExpierdMonth(), ExpierdMonth);
selectOptionIndex(getDdnExpierdYear(), 12);
type(gettxtCVVNmuber(), CVVNmuber);
click(getBtnBook());
	}

}

