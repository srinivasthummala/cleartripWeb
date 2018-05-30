package com.cleartripweb.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.cleartripweb.pages.HomePage;
import com.cleartripweb.pages.HotelTestPage;
import com.cleartripweb.pages.HotelsearchresultsTestPage;
import com.cleartripweb.pages.SearchResultsPage;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class ClearTripSteps extends WebDriverTestCase {

	HomePage hm = new HomePage();
	HotelTestPage htp = new HotelTestPage();
	SearchResultsPage sr = new SearchResultsPage();
	HotelsearchresultsTestPage hsr = new HotelsearchresultsTestPage();
	
	@QAFTestStep(description="user launch cleartrip application")
	public void userLaunchCleartripApplication(){
		hm.launchPage();
		hm.waitForPageToLoad();
	}
	@QAFTestStep(description="user selects flights tab")
	public void userSelectsFlightsTab(){
		hm.selectLinksFromMenu();
	}
	@QAFTestStep(description="user selects round trip")
	public void userSelectsRoundTrip(){
		hm.selectTripType();
	}
	/*@QAFTestStep(description="user enter {0} and {1}")
	public void userEnterAnd(String str0,String str1){
		hm.setOriginCity(str0);
		hm.setDestCity(str1);
	}*/
	@QAFTestStep(description="user enter {0} and {1}")
	public void userEnterOriginAndDestination(String originCity, String destCity){
		hm.setOriginCity(originCity);
		hm.setDestCity(destCity);
	}
	@QAFTestStep(description="user select dates from calender")
	public void userSelectDatesFromCalender() throws InterruptedException{
		hm.setDepartAndReturnDates();
	}
	@QAFTestStep(description="user click on search flights")
	public void userClickOnSearchFlights(){
		hm.clickSearchFlights();
	}
	@QAFTestStep(description="user verify results page")
	public void userRerifyResultsPage(){
		hm.verifySearchSummary();
	}
	@QAFTestStep(description="user select flights and click on book button")
	public void userSelectFlightsAndClickOnBookButton(){
//		sr.getAllAirlines().waitForPresent(30000);
//		sr.getAllAirlines().isDisplayed();
		sr.getbtnBook().waitForPresent(20000);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sr.selectFlightsForDepatureAndReturn();
		sr.getbtnBook().click();
	}

	@QAFTestStep(description="user selects hotels tab")
	public void userSelectHotelsTab(){
		hm.getLnkHotelsHomepage().click();
	}
	@QAFTestStep(description="user verifies search for hotels label")
	public void userverifyHotelLabel(){
		htp.getLblHeaderHotlePage().isPresent();
		
	}
	@QAFTestStep(description="user enter city for hotel {city}")
	public void userEnterCity(String city){
		htp.getTxtCityHotelPage().clear();
		Actions ele = new Actions(getTestBase().getDriver());
		ele.sendKeys(htp.getTxtCityHotelPage(), city).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//		htp.getTxtCityHotelPage().sendKeys(city);
//		htp.getTxtCityHotelPage().sendKeys(Keys.ENTER);
		
	}
	
	@QAFTestStep(description="user select checkIn and checkOut dates from calender")
	public void userSetCheckInCheckOutDates(){
		htp.setCheckInAndCheckOutDates();
		
	}
	
	@QAFTestStep(description="user selects no of travelers")
	public void userSelectTravelers(){
		htp.selectTravelers();
		
	}
	
	@QAFTestStep(description="user click search button")
	public void userClichSearchButton(){
		htp.getBtnSearchHotelHotelPage().click();
		
	}
	@QAFTestStep(description="user verify city label in results page")
	public void userVerifyCityLabelinResults(){
		hsr.getLblSummaryCityHeaderHotelResults().waitForPresent();
		hsr.getLblSummaryCityHeaderHotelResults().isDisplayed();
		
	}
}
