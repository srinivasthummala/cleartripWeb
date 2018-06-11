package com.cleartripweb.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cleartripweb.component.TrainCalenderComponent;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class TrainsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	HomePage hm = new HomePage();
	
	@FindBy(locator = "txt.fromStation.trainspage")
	private QAFWebElement txtFromStationTrainspage;
	@FindBy(locator = "txt.toStation.tainspage")
	private QAFWebElement txtToStationTainspage;
	@FindBy(locator = "dd.select.trainclass.trainspage")
	private QAFWebElement ddSelectTrainclassTrainspage;
	@FindBy(locator = "cal.departDate.trainspage")
	private QAFWebElement calDepartDateTrainspage;
	@FindBy(locator = "dd.select.adults.trainspage")
	private QAFWebElement ddSelectAdultsTrainspage;
	@FindBy(locator = "dd.select.children.trainspage")
	private QAFWebElement ddSelectChildrenTrainspage;
	@FindBy(locator = "btn.searchTrains.trainspage")
	private QAFWebElement btnSearchTrainsTrainspage;
	@FindBy(locator = "lbl.trainSearch.trainspage")
	private QAFWebElement labelTrainsSearch;
	@FindBy(locator = "cal.btn.next.hotelpage")
	private QAFWebElement calNextBtn;
	@FindBy(locator = "cal.list.monthTablelist.hotelpage")
	private List<TrainCalenderComponent> calMonthList;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	
	public List<TrainCalenderComponent> getCalMonthList() {
		return calMonthList;
	}

	public QAFWebElement getFromStation() {
		return txtFromStationTrainspage;
	}

	public QAFWebElement getToStation() {
		return txtToStationTainspage;
	}

	public QAFWebElement getSelectTrainclass() {
		return ddSelectTrainclassTrainspage;
	}

	public QAFWebElement getDepartDate() {
		return calDepartDateTrainspage;
	}

	public QAFWebElement getSelectAdults() {
		return ddSelectAdultsTrainspage;
	}

	public QAFWebElement getSelectChildren() {
		return ddSelectChildrenTrainspage;
	}

	public QAFWebElement getSearchTrains() {
		return btnSearchTrainsTrainspage;
	}
	
	public void waitForPageToLoad() {
		labelTrainsSearch.isDisplayed();
	}
	
	public void selectAdultsToTravel(String noOfAdults){
		Select adults = new Select(ddSelectAdultsTrainspage);
		List<WebElement> adultSelection = adults.getOptions();
		for(WebElement option : adultSelection){
			if(option.getText().contains(noOfAdults)){
				option.click();
				break;
			}
		}
	}
	
	public void selectTrainClass(String myOption){
		Select trainClass = new Select(ddSelectTrainclassTrainspage);
		List<WebElement> trainClassoptions = trainClass.getOptions();
		for(WebElement option : trainClassoptions){
			if(option.getText().contains(myOption)){
				option.click();
				break;
			}
		}
	}
	
	public void selectTravelDate(){
		Date d = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("d/MMMM/yyyy");
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.DATE, 5);
		d = calendar.getTime();
		String checkInDate = dateFormatter.format(d);
		String [] checkIn = checkInDate.split("/");
		String checkInDay = checkIn[0];
		String checkInMonth = checkIn[1];
		String year = checkIn[2];
		String monthYear = checkInMonth + " " + year;
		
		calDepartDateTrainspage.click();
		selectDate(monthYear, checkInDay);
		Reporter.log("date selected");
		
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
		calNextBtn.click();
		selectDate(month, day);
	}

}
