package testvagrantCodingRound.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testvagrantCodingRound.Utility.DynamicWait;

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
	
	public String loginWithoutCredentials()
	{
		yourTrips.click();
		//wait till sign In becomes clickable
        DynamicWait.elementToBeClickable(driver, 10, signIn);
        signIn.click();
        //switch to frame
        driver.switchTo().frame(1);
        DynamicWait.elementToBeClickable(driver, 10, signInButton);
        signInButton.click();
        //Error message is fetched
        return errorMessage.getText();
	}
	
}
