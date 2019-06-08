package testvagrantCodingRound.test;

import testvagrantCodingRound.ReadProperty.ReadPropertyFile;
import testvagrantCodingRound.Utility.ReadXlsx;
import testvagrantCodingRound.WebPages.LandingPage;
import testvagrantCodingRound.driver.DriverManager;

import java.util.Map;

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
    	Map<String, String> errorDetails=new ReadXlsx().getData("SignInTest").get(0);
    	Assert.assertTrue(errorMessage.contains(errorDetails.get("ERROR MESSAGE")));
        
    }
//Close browser
   @AfterClass
   public void clear()
   {
	   driverManager.quit();
   }
   
}
