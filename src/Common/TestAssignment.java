package Common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LandingPage;
import Pages.SearchResultPage;

public class TestAssignment extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	public static String title;
	static ExtentTest test;
	static ExtentReports report;
	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",".\\BrowserFile\\chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports(".\\Report\\ExtentReportResults.html");
		test = report.startTest("Flight Booking");
		BaseClass.getValues();
	}
	@Test
	public void testMethod() throws Exception {	
		LandingPage landing=new LandingPage(driver);
		SearchResultPage searchResult=new SearchResultPage(driver);
		driver.get(url);
		driver.manage().window().maximize();
		try {
			assertEquals(landing_page_title, driver.getTitle());
			test.log(LogStatus.PASS, landing_pass_message);
		}catch(AssertionError a) {
			test.log(LogStatus.FAIL, landing_fail_message );
		}
		
		landing.select_round_trip();
		Thread.sleep(3000);
		landing.click_cross_button();
		landing.select_from_city(from_city);
		landing.select_to_city(to_city);
		landing.select_from_date();
		landing.select_to_date();
		landing.select_passenger();
		landing.select_search();
		//wait.until(ExpectedConditions.visibilityOfAllElements(elements)
		try{
			//wait.until(ExpectedConditions.titleContains(search_page_title));
			assertTrue(driver.getTitle().equals(search_page_title));
			test.log(LogStatus.PASS, search_pass_message);
		}catch(AssertionError a) {
			test.log(LogStatus.FAIL, search_fail_message );
		}
		try {
			assertTrue(searchResult.Stops_visible()&&searchResult.Airlines_visible()&&searchResult.Departure_visible());
			test.log(LogStatus.PASS, filter_pass_message);
		}catch(AssertionError a) {
			test.log(LogStatus.FAIL, filter_fail_message );
		}
		
	}
	@AfterMethod
	public void afterMethod() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
