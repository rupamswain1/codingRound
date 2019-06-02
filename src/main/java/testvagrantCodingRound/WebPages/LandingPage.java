package testvagrantCodingRound.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage 
{
	private WebDriver driver;
	
	@FindBy(id="userAccountLink")
	private WebElement yourTrips;
	
	@FindBy(id="SignIn")
	private WebElement signIn;
	
	@FindBy(id="signInButton")
	private WebElement signInButton;
	
	@FindBy(id="errors1")
	private WebElement errorMessage;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void 
	
}
