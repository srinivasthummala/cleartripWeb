package com.cleartripweb.steps;

import org.hamcrest.Matchers;
import org.openqa.selenium.Keys;
import com.cleartripweb.bean.TrainsBean;
import com.cleartripweb.pages.HomePage;
import com.cleartripweb.pages.HotelTestPage;
import com.cleartripweb.pages.HotelsearchresultsTestPage;
import com.cleartripweb.pages.SearchResultsPage;
import com.cleartripweb.pages.TrainsTestPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class ClearTripSteps extends WebDriverTestCase {

	HomePage hm = new HomePage();
	HotelTestPage htp = new HotelTestPage();
	SearchResultsPage sr = new SearchResultsPage();
	TrainsTestPage ttp = new TrainsTestPage();
	HotelsearchresultsTestPage hsr = new HotelsearchresultsTestPage();
	
	TrainsBean trainBean = new TrainsBean();

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
	public void userEnterCity(String city) {
		htp.getTxtCityHotelPage().clear();
		htp.getTxtCityHotelPage().sendKeys(city);
		QAFTestBase.pause(1000);
		htp.getTxtCityHotelPage().sendKeys(Keys.ENTER);
		
		
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
		Validator.verifyThat(hsr.getLblSummaryCityHeaderHotelResults().isDisplayed(), Matchers.notNullValue());
		
	}
	
	@QAFTestStep(description="user selects trains tab")
	public void userSelectsTrainsTab(){
		hm.getLnkTrainsHomepage().isPresent();
		hm.getLnkTrainsHomepage().click();
	}
	
	@QAFTestStep(description="user verifies trains search header label")
	public void userVerifiesTrainsSearchHeaderLabel(){
		ttp.waitForPageToLoad();
	}
	
	@QAFTestStep(description="user enter from {from} to {to} for travel")
	public void userEnterFromToStationsForTravel(String fromStation, String toStation){
		trainBean.setFromaStation(fromStation);
		trainBean.setToStation(toStation);
		ConfigurationManager.getBundle().setProperty("train.bean", trainBean);
		ttp.getFromStation().sendKeys(fromStation);
		QAFTestBase.pause(1000);
		ttp.getFromStation().sendKeys(Keys.ENTER);
		ttp.getToStation().sendKeys(toStation);
		QAFTestBase.pause(1000);
		ttp.getToStation().sendKeys(Keys.ENTER);
	}
	
	@QAFTestStep(description="user select {myClass} as train class")
	public void userSelectTrainClassFromDropDown(String trainClass){
		ttp.getSelectTrainclass().click();
		ttp.selectTrainClass(trainClass);
	}
	
	@QAFTestStep(description="user pick travel date from calender")
	public void userPickTravelDateFromCalender(){
		ttp.selectTravelDate();
	}
	
	@QAFTestStep(description="user select {no.of adults} adults for travel")
	public void userSelectNoOfAdults(){
		trainBean.fillRandomData();
		System.out.println(trainBean.getAdults());
		ttp.selectAdultsToTravel(trainBean.getAdults());
	}
	
	@QAFTestStep(description="user click on search trains button")
	public void userClickOnSearchTrainsButton(){
		ttp.getSearchTrains().click();;
	}
	
	@QAFTestStep(description="user verify train results page")
	public void userRerifyTrainResultsPage(){
		trainBean = (TrainsBean) ConfigurationManager.getBundle().getProperty("train.bean");
		hm.getLblSearchSummary().isPresent();
		Reporter.log(hm.getLblSearchSummary().getText());
		System.out.println(trainBean.getFromaStation());
		Validator.verifyThat(hm.getLblSearchSummary().getText(), Matchers.containsString(trainBean.getFromaStation()));
		Validator.verifyThat(hm.getLblSearchSummary().getText(), Matchers.containsString(trainBean.getToStation()));

	}
}
