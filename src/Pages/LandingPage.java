package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	WebDriverWait wait;
	@FindBy(xpath="//span[text()='Round Trip']")
	private WebElement round_trip;
	@FindBy(className="ixi-icon-cross")
	private WebElement cross_button;
	@FindBy(xpath="//div[text()='From']/following-sibling::input")
	private WebElement from_city;
	@FindBy(xpath="//div[text()='From']/parent::div/following-sibling::div//div[contains(text(),'Lohegaon')]")
	private WebElement select_from_city;
	@FindBy(xpath="//div[text()='To']/following-sibling::input")
	private WebElement to_city;
	@FindBy(xpath="//div[text()='To']/parent::div/following-sibling::div//div[contains(text(),'Rajiv')]")
	private WebElement select_to_city;
	@FindBy(xpath="//div[text()='September 2020']/following-sibling::table//td[@data-date='17092020']")
	private WebElement from_date;
	@FindBy(xpath="(//div[text()='October 2020']/following-sibling::table//td[@data-date='24102020'])[2]")
	private WebElement to_date;
	@FindBy(xpath="//div[text()='Adult']/parent::div/following-sibling::div/span[@data-val='2']")
	private WebElement passenger;
	@FindBy(xpath="//button[text()='Search']")
	private WebElement search;
	
	public LandingPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,20);
	}
	
	public void select_round_trip(){
		round_trip.click();
	}
	public void click_cross_button(){
		cross_button.click();
	}
	public void select_from_city(String from_city_name){
		from_city.sendKeys(from_city_name);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='From']/parent::div/following-sibling::div//div[contains(text(),'Lohegaon')]")));
		from_city.sendKeys(Keys.ENTER);
	}
	public void select_to_city(String to_city_name){
		to_city.sendKeys(to_city_name);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='To']/parent::div/following-sibling::div//div[contains(text(),'Rajiv Gandhi')]")));
		to_city.sendKeys(Keys.ENTER);
	}
	public void select_from_date(){
		from_date.click();
	}
	public void select_to_date(){
		to_date.click();
	}
	public void select_passenger(){
		passenger.click();
	}
	public void select_search(){
		search.click();
	}
}
