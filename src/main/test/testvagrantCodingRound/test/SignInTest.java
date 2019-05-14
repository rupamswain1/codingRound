package testvagrantCodingRound.test;

import testvagrantCodingRound.ReadProperty.ReadPropertyFile;
import testvagrantCodingRound.driver.DriverManager;
import testvagrantCodingRound.wait.DynamicWait;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {

	@FindBy(id="userAccountLink")
	WebElement yourTrips;
	
	@FindBy(id="SignIn")
	WebElement signIn;
	
	@FindBy(id="signInButton")
	WebElement signInButton;
	
	@FindBy(id="errors1")
	WebElement errorMessage;
	
	DriverManager driverManager;
	WebDriver driver;
	
	//Initializes browser class and pagefactory elements
  @BeforeTest
  public void setup()
  {
	  driverManager=new DriverManager();
	  driver=driverManager.driver;
	  PageFactory.initElements(driver, this);
  }

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

    	driverManager.openUrl(ReadPropertyFile.get("url"));
    	
        yourTrips.click();
        //wait till sign In becomes clickable
        DynamicWait.elementToBeClickable(driver, 10, signIn);
        signIn.click();
        //switch to frame
        driver.switchTo().frame(1);
        signInButton.click();
        //Error message is fetched
        String errors1 = errorMessage.getText();
     
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        
    }
//Close browser
   @AfterTest
   public void clear()
   {
	   driverManager.quit();
   }
   
}
