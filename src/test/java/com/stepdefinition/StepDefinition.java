package com.stepdefinition;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.base.Baseclass;
import com.pojo.BookHotel;
import com.pojo.BookingConfirm;
import com.pojo.Loginpage;
import com.pojo.SearchHotel;
import com.pojo.SelectHotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition extends Baseclass{
	@Given("User is on the  Adactin login page")
	public void userIsOnTheAdactinLoginPage() throws IOException {
		
	    maximize();  
	}
	@When("User should enters login Details {string},{string}")
	public void userShouldEntersLoginDetails( String username, String password) {
		Loginpage login = new Loginpage();
		  login.login(username, password); 
	}

@When("User should verify {string}")
public void userShouldVerify(String expValue) {
	SearchHotel hotelPage = new SearchHotel();
	String actValue = getAttribute(hotelPage.getTxtVerifyLogin());
	Assert.assertEquals("verify login", expValue, actValue);


	
	
}


@When("User should  Search Hotel {string},{string},{string},{string},{string}, {string},{string},{string}")
public void userShouldSearchHotel(String Location, String Hotels, String RoomType, String NumberofRooms, String CheckinDate, String CheckoutDate, String AdultsperRoom, String ChildrenperRoom) {
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	SearchHotel search = new SearchHotel();
	search.searchHotel(Location, Hotels, RoomType, NumberofRooms, CheckinDate, CheckoutDate, AdultsperRoom, ChildrenperRoom);
	SelectHotel selectPage = new SelectHotel();
	selectPage.selectHotel();
}

@When("User should verify {string} is present")
public void userShouldVerifyIsPresent(String expValue) {
	BookHotel page = new BookHotel();
	String actValue = getText(page.getTxtBookHotel());
	Assert.assertEquals("verify book hotel msg", expValue, actValue);
}
@When("User should verify book hotel {string},{string},{string} and payment")
public void userShouldVerifyBookHotelAndPayment(String Firstname, String Lastname, String Address, io.cucumber.datatable.DataTable dataTable) {
   BookHotel book = new BookHotel();
  List<Map<String, String>> asMaps = dataTable.asMaps();
  Map<String, String> map = asMaps.get(0); 
  String CreditNumber = map.get("CreditNumber");
  String CreditCardType = map.get("CreditCardType");
  String ExpierdMonth = map.get("ExpierdMonth");
  String ExpierdYear = map.get("ExpierdYear");
  String CVVNmuber = map.get("CVVNmuber");
  book.bookHote(Firstname, Lastname, Address, CreditNumber, CreditCardType, ExpierdMonth, ExpierdYear, CVVNmuber);
}
@Then("User should verify confirmation {string}")
public void userShouldVerifyConfirmation(String expValue) {
	BookingConfirm book = new BookingConfirm();
	String actValue = getText(book.getTxtBookingConfirm());
	Assert.assertEquals("verify booking confirm",expValue,actValue );
}
@Then("User should verify {string},{string} ,{string},{string},{string}, {string} and {string}")
public void user_should_check(String expFName, String expLName,String expAdd, String expCNo, String expCType, String expCMonth,String expyear,String expCvv) throws InterruptedException  {
	Thread.sleep(4000);
	findElementById("book_now").click();
	BookHotel  page = new BookHotel();
	String actFname = getText(page.getTxtFirstname());
	String actlast = getText(page.getTxtLastname());
	String actAddress = getText(page.getTxtAddress());
	String actCredit = getText(page.getTxtCreditNumber());
	String actCtype = getText(page.getDdnCreditCardType());
	String actExipre = getText(page.getDdnExpierdMonth());
	String actyear = getText(page.getDdnExpierdYear());
	String actCvv = getText(page.gettxtCVVNmuber());
	
	Assert.assertEquals("Verify error first name", expFName,actFname);
	Assert.assertEquals("Verify error first name", expLName,actlast);
	Assert.assertEquals("Verify error first name", expAdd,actAddress);
	Assert.assertEquals("Verify error first name", expCNo,actCredit);
	Assert.assertEquals("Verify error first name", expCType,actCtype);
	Assert.assertEquals("Verify error first name", expCMonth,actExipre);
	Assert.assertEquals("Verify error first name", expyear,actyear);
	Assert.assertEquals("Verify error first name", expCvv,actCvv);
	
	
	

	

}



	




}