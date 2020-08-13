package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	WebDriverWait wait;
	@FindBy(xpath="//div[text()='Stops']")
	private WebElement Stops;
	@FindBy(xpath="//div[text()='Departure from PNQ']")
	private WebElement Departure;
	@FindBy(xpath="//div[text()='Airlines']")
	private WebElement Airlines;
	
	public SearchResultPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,20);
	}
	public boolean Stops_visible(){
		return Stops.isDisplayed();
	}
	public boolean Departure_visible(){
		return Departure.isDisplayed();
	}
	public boolean Airlines_visible(){
		return Airlines.isDisplayed();
	}
}
