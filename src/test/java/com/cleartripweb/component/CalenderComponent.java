package com.cleartripweb.component;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CalenderComponent extends QAFWebComponent{

	public CalenderComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(locator = "cal.monthName.homepage")
	private QAFWebElement calMonthTitle;
	@FindBy(locator = "cal.days.homepage")
	private List<QAFWebElement> calMonthDays;
	
	
	public QAFWebElement getCalMonthTitle() {
		return calMonthTitle;
	}

	public List<QAFWebElement> getCalMonthDays() {
		return calMonthDays;
	}
}
