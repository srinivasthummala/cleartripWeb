package com.cleartripweb.pages;

import java.util.List;

import com.cleartripweb.component.RoundTripComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SeartchResultsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(locator = "list.roundTripResults.searchResultsPage")
	private List<RoundTripComponent> roundTripResult;
	
	public  List<RoundTripComponent> getRoundTripResult()	{
		return roundTripResult;
	}
	
	@FindBy(locator = "lbl.allAirlines.resultsPage")
	private QAFWebElement allAirlines;
	
	public QAFWebElement getAllAirlines() {
		return allAirlines;
	}
	
	@FindBy(locator = "btn.book.resultspage")
	private QAFWebElement btnBook;
	
	public QAFWebElement getbtnBook() {
		return btnBook;
	}
	
	public void selectFlightsForDepatureAndReturn(){
		System.out.println(getRoundTripResult().size());
		for(int i=0; i<getRoundTripResult().size(); i++){
			String activeDate  = getRoundTripResult().get(i).getActiveDate().getAttribute("data-date");
			System.out.println("active date: "+ activeDate);
			getRoundTripResult().get(i).getDateSort().click();
			String flightFare = getRoundTripResult().get(i).getFlightsList().get(i).getFlightFare().getAttribute("data-pr");
			System.out.println("flight fare : "+flightFare);
			getRoundTripResult().get(i).getFlightsList().get(i).getRadioButton().click();
		}
	}

}
