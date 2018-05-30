package com.cleartripweb.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class HotelTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	HomePage hm = new HomePage();
	
	@FindBy(locator = "lbl.header.hotlePage")
	private QAFWebElement lblHeaderHotlePage;
	@FindBy(locator = "txt.city.hotelPage")
	private QAFWebElement txtCityHotelPage;
	@FindBy(locator = "dd.travelers.hotelsPage")
	private QAFWebElement TravelersHotelsPage;
	@FindBy(locator = "btn.searchHotel.hotelPage")
	private QAFWebElement btnSearchHotelHotelPage;
	@FindBy(locator = "dt.checkIn.hotelPage")
	private QAFWebElement checkInDate;
	@FindBy(locator = "dt.checkOut.hotelPage")
	private QAFWebElement checkOutDate;
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLblHeaderHotlePage() {
		return lblHeaderHotlePage;
	}

	public QAFWebElement getTxtCityHotelPage() {
		return txtCityHotelPage;
	}

	public QAFWebElement getTravelersHotelsPage() {
		return TravelersHotelsPage;
	}

	public QAFWebElement getBtnSearchHotelHotelPage() {
		return btnSearchHotelHotelPage;
	}
	
	public QAFWebElement getCheckInDate() {
		return checkInDate;
	}
	
	public QAFWebElement getCheckOutDate() {
		return checkOutDate;
	}
	
	public void waitForPageToLoad(){
		lblHeaderHotlePage.isDisplayed();
	}
	
	public void setHotelCity(String city){
		getTxtCityHotelPage().clear();
		getTxtCityHotelPage().sendKeys(city);
	}
	
	public void setCheckInAndCheckOutDates(){
		Date d = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("d/MMMM/yyyy");
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.DATE, 5);
		d = calendar.getTime();
		String checkInDate = dateFormatter.format(d);
		String [] checkIn = checkInDate.split("/");
		String checkInDay = checkIn[0];
		String checkInMonth = checkIn[1];
		
		calendar.add(Calendar.DATE, 5);
		d = calendar.getTime();
		String checkOutDate = dateFormatter.format(d);
		String [] checkOut = checkOutDate.split("/");
		String checkOutDay = checkOut[0];
		String checkOutMonth = checkOut[1];

		//getCheckInDate().clear();
		getCheckInDate().click();
		hm.selectDate(checkInMonth, checkInDay);
		Reporter.log("date selected");
		//getCheckOutDate().clear();
		getCheckOutDate().click();
		hm.selectDate(checkOutMonth, checkOutDay);
	}
	
	public void selectTravelers(){
		Select travelers = new Select(getTravelersHotelsPage());
		travelers.selectByIndex(1);
	}
	
	

}
