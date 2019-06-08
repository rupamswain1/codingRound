package testvagrantCodingRound.test;

import testvagrantCodingRound.ReadProperty.ReadPropertyFile;
import testvagrantCodingRound.Utility.DynamicWait;
import testvagrantCodingRound.Utility.ReadXlsx;
import testvagrantCodingRound.WebPages.FlightSearchResult;
import testvagrantCodingRound.WebPages.LandingPage;
import testvagrantCodingRound.driver.DriverManager;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlightBookingTest {

   
    DriverManager driverManager;
	WebDriver driver;
	
	//Initializes browser class and pagefactory elements
    @BeforeMethod
    public void setup()
    {
  	  driverManager=new DriverManager();
  	  this.driver=driverManager.getDriver();
  	  PageFactory.initElements(this.driver, this);
    }

    @Test(dataProvider="provideData")
    public void testThatResultsAppearForAOneWayJourney(Object data) {

    	LandingPage landingPage=new LandingPage(driver);
    	FlightSearchResult flightResult=landingPage.searchFlight((Map<String, String>)data);

        //verify that result appears for the provided journey search
        Assert.assertTrue(flightResult.getSearchSummary());

       
     }

    @DataProvider(parallel=true)
    public Object[] provideData()
    {
    	List<Map<String, String>> xcelData=new ReadXlsx().getData("FlightBookingTest");
		Object[] data=new Object[xcelData.size()];
		for(int i=0;i<xcelData.size();i++ )
		{
			data[i]=xcelData.get(i);
		}
		return data;
    }
    @AfterMethod
    public void clear()
    {
 	  driverManager.quit();
    }

    
}
