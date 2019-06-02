package testvagrantCodingRound.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchResult {

	@FindBy(xpath="//div[@class='searchSummary']")
    private WebElement searchSummary;
	
	private WebDriver driver;
	public FlightSearchResult(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getSearchSummary()
	{
		return searchSummary.isDisplayed();
	}
}
