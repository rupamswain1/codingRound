package testvagrantCodingRound.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelSearchResult {

	 @FindBy(xpath="//span[@class='fillCityName']")
	 private WebElement cityNane;

	private WebDriver driver;
	public HotelSearchResult(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public boolean CityDisplyed()
	{
		return cityNane.isDisplayed();
	}
}
