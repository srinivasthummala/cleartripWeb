package com.cleartripweb.component;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class TrainCalenderComponent extends QAFWebComponent {
	
	public TrainCalenderComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "cal.monthTitle.hotelpage")
	private QAFWebElement calMonthTitle;
	@FindBy(locator = "cal.list.monthDay.hotelpage")
	private List<QAFWebElement> calMonthDays;
	
	
	public QAFWebElement getCalMonthTitle() {
		return calMonthTitle;
	}

	public List<QAFWebElement> getCalMonthDays() {
		return calMonthDays;
	}
}
