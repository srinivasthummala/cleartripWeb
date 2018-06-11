package com.cleartripweb.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cleartripweb.component.CalenderComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.StringMatcher;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
	}

	@FindBy(locator = "lnk.flights.homepage")
	private QAFWebElement lnkFlightsHomepage;
	@FindBy(locator = "lnk.hotels.homepage")
	private QAFWebElement lnkHotelsHomepage;
	@FindBy(locator = "lnk.trains.homepage")
	private QAFWebElement lnkTrainsHomepage;
	@FindBy(locator = "radio.tripType.homepage")
	private QAFWebElement radioTripTypeHomepage;
	@FindBy(locator = "txt.orignLocation.homepage")
	private QAFWebElement txtOrignLocationHomepage;
	@FindBy(locator = "txt.destination.homepage")
	private QAFWebElement txtDestinationHomepage;
	@FindBy(locator = "lnk.pageTitle.homepage")
	private QAFWebElement pageTitle;
	@FindBy(locator = "dt.depart.homepage")
	private QAFWebElement departDate;
	@FindBy(locator = "btn.cal.nextMonth")
	private QAFWebElement btnNextMonth;
	@FindBy(locator = "cal.table.list")
	private List<CalenderComponent> calMonthList;
	@FindBy(locator = "dt.return.homepage")
	private QAFWebElement returnDate;
	@FindBy(locator = "btn.searchFlights.homepage")
	private QAFWebElement btnSearchFlights;
	@FindBy(locator = "lbl.searchSummary.searchresultsPage")
	private QAFWebElement lblSearchSummary;
	
	public List<CalenderComponent> getCalMonthList() {
		return calMonthList;
	}

	public QAFWebElement getLnkFlightsHomepage() {
		return lnkFlightsHomepage;
	}
	public QAFWebElement getLnkHotelsHomepage() {
		return lnkHotelsHomepage;
	}

	public QAFWebElement getLnkTrainsHomepage() {
		return lnkTrainsHomepage;
	}
	
	public QAFWebElement getRadioTripTypeHomepage() {
		return radioTripTypeHomepage;
	}

	public QAFWebElement getTxtOrignLocationHomepage() {
		return txtOrignLocationHomepage;
	}

	public QAFWebElement getTxtDestinationHomepage() {
		return txtDestinationHomepage;
	}

	public QAFWebElement getdepartDate() {
		return departDate;
	}

	public QAFWebElement getPageTitle() {
		return pageTitle;
	}

	public QAFWebElement getReturnDate() {
		return returnDate;
	}
	
	public QAFWebElement getBtnNextMonth() {
		return btnNextMonth;
	}
	
	public QAFWebElement getBtnSearchFlights() {
		return btnSearchFlights;
	}
	
	public QAFWebElement getLblSearchSummary() {
		return lblSearchSummary;
	}


	public void waitForPageToLoad() {
		getPageTitle().verifyPresent();
	}

	public void selectLinksFromMenu() {

		getLnkFlightsHomepage().click();
		/*
		 * QAFExtendedWebElement menuItem = new QAFExtendedWebElement(
		 * String.format(ConfigurationManager.getBundle().getString(
		 * "resource-id.common.hotelSearchResultsPage"),
		 * "checkBoxPayAtHotelApplied")); return element;
		 */
	}

	public void selectTripType() {
		getRadioTripTypeHomepage().click();
	}

	public void setOriginCity(String originCity) {
		getTxtOrignLocationHomepage().isDisplayed();
		getTxtOrignLocationHomepage().clear();
		getTxtOrignLocationHomepage().sendKeys(originCity);
	}

	public void setDestCity(String destCity) {
		getTxtDestinationHomepage().isDisplayed();
		getTxtDestinationHomepage().clear();
		getTxtDestinationHomepage().sendKeys(destCity);
	}

//	public void launchPage() {
//		launchPage(null);
//	}

	public void setDepartAndReturnDates(){
		Date d = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("d/MMMM/yyyy");
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.DATE, 5);
		d = calendar.getTime();
		String deparDate = dateFormatter.format(d);
		String [] depart = deparDate.split("/");
		String deptDay = depart[0];
		String DeptMonth = depart[1];
		
		calendar.add(Calendar.DATE, 5);
		d = calendar.getTime();
		String returnDate = dateFormatter.format(d);
		String [] returnD = returnDate.split("/");
		String returnDay = returnD[0];
		String returnMonth = returnD[1];

		getdepartDate().clear();
		getdepartDate().click();
		selectDate(DeptMonth, deptDay);
		Reporter.log("date selected");
		getReturnDate().clear();
		getReturnDate().click();
		selectDate(returnMonth, returnDay);
	}

	public void selectDate(String month, String day)  {
		for (int i = 0; i < getCalMonthList().size(); i++) {
			String monthName = getCalMonthList().get(i).getCalMonthTitle().getText();
			if (monthName.equalsIgnoreCase(month)) {
				System.out.println("Month Name" + monthName);
				List<QAFWebElement> el = getCalMonthList().get(i).getCalMonthDays();
				
				for (QAFWebElement e : el) {
					if (e.getText().equalsIgnoreCase(day)) {
						System.out.println("Month day" + e.getText());
						e.click();
						return;
					}
				}
			}
		}
		getBtnNextMonth().click();
		selectDate(month, day);
	}
	
	public void clickSearchFlights(){
		getBtnSearchFlights().isPresent();
		getBtnSearchFlights().click();
	}
	
	public void verifySearchSummary(){
		getLblSearchSummary().verifyText(StringMatcher.contains("Pune"));
		getLblSearchSummary().assertText(StringMatcher.contains("Hyderabad"));
	}

	public void dateValue() {
		Date d = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("d/MMMM/yyyy");
		System.out.println(d);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 5);
		d = calendar.getTime();
		String deparDate = dateFormatter.format(d);
		String [] depart = deparDate.split("/");
		String deptDay = depart[0];
		String DeptMonth = depart[1];
		System.out.println(deptDay);
		System.out.println(DeptMonth);

		System.out.println(deparDate);
		calendar.add(Calendar.DATE, 5);
		d = calendar.getTime();
		String returnDate = dateFormatter.format(d);
		String [] returnD = returnDate.split("/");
		String returnDay = returnD[0];
		String returnMonth = returnD[1];
		System.out.println(returnDay);
		System.out.println(returnMonth);
		
/*
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Format 1:   " + dateFormatter.format(d));

		DateFormat formatter = DateFormat.getInstance(); // Date and time
		String dateStr = formatter.format(d);
		System.out.println(dateStr);

		formatter = DateFormat.getTimeInstance(); // time only
		System.out.println(formatter.format(d));

		formatter = DateFormat.getDateInstance(); // date only
		System.out.println(formatter.format(d));

		Calendar calendar = Calendar.getInstance(); // day of month(1-31)
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("dayOfMonth : " + dayOfMonth);

		System.out.println("The current date is : " + calendar.getTime());
		calendar.add(Calendar.DATE, -15);
		System.out.println("15 days ago: " + calendar.getTime());
		calendar.add(Calendar.DATE, 15);
		System.out.println("15 days after: " + calendar.getTime());
		calendar.add(Calendar.DATE, 15);
		System.out.println("15 days after: " + calendar.getTime());
		Date da = calendar.getTime();
		dateFormatter = new SimpleDateFormat("d/MMMM/yyyy");
		String sdate = dateFormatter.format(da);
		System.out.println("15 days after formatted : " + sdate);

		// System.out.println("15 days after formatted : "
		// +formatter.format(calendar));
		calendar.add(Calendar.MONTH, 4);
		System.out.println("4 months later: " + calendar.getTime());
		calendar.add(Calendar.YEAR, 2);
		System.out.println("2 years later: " + calendar.getTime());*/

	}
}
