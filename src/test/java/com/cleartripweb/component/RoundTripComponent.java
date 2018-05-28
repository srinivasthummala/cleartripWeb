package com.cleartripweb.component;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class RoundTripComponent extends QAFWebComponent  {

	public RoundTripComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "lnk.activeDate.resultsPage")
	private QAFWebElement activeDate;
	@FindBy(locator = "lnk.dateSort.resultsPge")
	private QAFWebElement dateSort;
	
	
	@FindBy(locator = "lst.flightsListView.resultspage")
	private List<flightList> flightsList;
	
	public  List<flightList> getFlightsList()	{
		return flightsList;
	}
	
	public QAFWebElement getActiveDate() {
		return activeDate;
	}
	
	public QAFWebElement getDateSort() {
		return dateSort;
	}

	
	public class flightList extends QAFWebComponent {

		public flightList(String locator) {
			super(locator);
			// TODO Auto-generated constructor stub
		}
		
		@FindBy(locator = "radio.selectFlight.resultsPage")
		private QAFWebElement radioButton;
		@FindBy(locator = "lbl.flightFare.resultsPage")
		private QAFWebElement flightFare;
		
		public QAFWebElement getRadioButton() {
			return radioButton;
		}
		
		public QAFWebElement getFlightFare() {
			return flightFare;
		}
	}

}
