package com.cleartripweb.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.cleartripweb.pages.HomePage;
import com.cleartripweb.pages.SearchResultsPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class MyTest extends WebDriverTestCase {
	@QAFDataProvider(dataFile="resources/data.txt")
	@Test
	public void test(Map<String, String> data) {
		HomePage hm = new HomePage();
		hm.launchPage(null);
		hm.waitForPageToLoad();
		hm.selectLinksFromMenu();
		hm.selectTripType();
		hm.setOriginCity(data.get("originCity"));
		hm.setDestCity(data.get("destCity"));
		hm.setDepartAndReturnDates();
		hm.clickSearchFlights();
		hm.verifySearchSummary();
		SearchResultsPage sr = new SearchResultsPage();
		
		sr.getAllAirlines().waitForPresent(30000);
		sr.getAllAirlines().isDisplayed();
		sr.selectFlightsForDepatureAndReturn();
		sr.getbtnBook().click();
		//hm.dateValue();
	}
	
	

}
