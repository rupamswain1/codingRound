package testvagrantCodingRound.test;

import testvagrantCodingRound.ReadProperty.ReadPropertyFile;
import testvagrantCodingRound.Utility.DynamicWait;
import testvagrantCodingRound.WebPages.FlightSearchResult;
import testvagrantCodingRound.WebPages.LandingPage;
import testvagrantCodingRound.driver.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlightBookingTest {

   
    DriverManager driverManager;
	WebDriver driver;
	
	//Initializes browser class and pagefactory elements
    @BeforeClass
    public void setup()
    {
  	  driverManager=new DriverManager();
  	  this.driver=driverManager.getDriver();
  	  PageFactory.initElements(this.driver, this);
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

    	LandingPage landingPage=new LandingPage(driver);
    	FlightSearchResult flightResult=landingPage.searchFlight();

        //verify that result appears for the provided journey search
        Assert.assertTrue(flightResult.getSearchSummary());

       
     }

   
    @AfterClass
    public void clear()
    {
 	  driverManager.quit();
    }

    
}
