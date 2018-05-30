package com.cleartripweb.pages;

import java.util.List;

import com.cleartripweb.component.RoundTripComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class SearchResultsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "list.roundTripResults.searchResultsPage")
	private List<RoundTripComponent> listRoundTripResultsSearchResultsPage;
	@FindBy(locator = "btn.book.resultspage")
	private QAFWebElement btnBookResultspage;
	@FindBy(locator = "lbl.allAirlines.resultsPage")
	private QAFWebElement lblAllAirlinesResultsPage;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<RoundTripComponent> getListRoundTripResults() {
		return listRoundTripResultsSearchResultsPage;
	}

	public QAFWebElement getbtnBook() {
		return btnBookResultspage;
	}

	public QAFWebElement getAllAirlines() {
		return lblAllAirlinesResultsPage;
	}
	
	public void selectFlightsForDepatureAndReturn(){
		for(int i=0; i<getListRoundTripResults().size(); i++){
			Reporter.log(getListRoundTripResults().get(i).getActiveDate().getAttribute("data-date"));
			getListRoundTripResults().get(i).getDateSort().click();
			Reporter.log(getListRoundTripResults().get(i).getFlightsList().get(i).getFlightFare().getAttribute("data-pr"));
			getListRoundTripResults().get(i).getFlightsList().get(i).getRadioButton().click();

		}
	}

}
