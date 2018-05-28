package com.cleartripweb.tests;

import org.testng.annotations.Test;

import com.cleartripweb.pages.HomePage;
import com.cleartripweb.pages.SeartchResultsPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class MyTest extends WebDriverTestCase {
	
	@Test
	public void test() throws InterruptedException {
		HomePage hm = new HomePage();
		hm.launchPage();
		hm.waitForPageToLoad();
		hm.selectLinksFromMenu();
		hm.selectTripType();
		hm.setOriginCity("Pune");
		hm.setDestCity("Hyderabad");
		hm.setDepartAndReturnDates();
		hm.clickSearchFlights();
		hm.verifySearchSummary();
		SeartchResultsPage sr = new SeartchResultsPage();
		Thread.sleep(4000);
		sr.getAllAirlines().isDisplayed();
		sr.selectFlightsForDepatureAndReturn();
		sr.getbtnBook().click();
		//hm.dateValue();
	}
	
	

}
