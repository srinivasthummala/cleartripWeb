package com.cleartripweb.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HotelsearchresultsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "lbl.summaryCityHeader.hotelResults")
	private QAFWebElement lblSummaryCityHeaderHotelResults;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLblSummaryCityHeaderHotelResults() {
		return lblSummaryCityHeaderHotelResults;
	}

}
