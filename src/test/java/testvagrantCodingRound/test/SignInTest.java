package testvagrantCodingRound.test;

import testvagrantCodingRound.WebPages.LandingPage;
import testvagrantCodingRound.driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest {

	private DriverManager driverManager;
	private WebDriver driver;
	
	//Initializes browser class and pagefactory elements
  @BeforeClass
  public void setup()
  {
	  driverManager=new DriverManager();
	  this.driver=driverManager.getDriver();
	  
  }

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	
    	LandingPage landingPage=new LandingPage(this.driver);
    	String errorMessage=landingPage.loginWithoutCredentials();
    	System.out.println(errorMessage);
        Assert.assertTrue(errorMessage.contains("There were errors in your submission"));
        
    }
//Close browser
   @AfterClass
   public void clear()
   {
	   driverManager.quit();
   }
   
}
