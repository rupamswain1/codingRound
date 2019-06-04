package testvagrantCodingRound.test;


import testvagrantCodingRound.WebPages.HotelSearchResult;
import testvagrantCodingRound.WebPages.LandingPage;
import testvagrantCodingRound.driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBookingTest {


    
   
    
    DriverManager driverManager;
	WebDriver driver;
	//Initializes browser class and pagefactory elements
    @BeforeClass
    public void setup()
    {
  	  driverManager=new DriverManager();
  	  driver=driverManager.getDriver();
  	  PageFactory.initElements(driver, this);
    }

    @Test
    public void shouldBeAbleToSearchForHotels() throws InterruptedException {
        LandingPage bookHotel=new LandingPage(driver);
        HotelSearchResult result=bookHotel.bookHotel();
        Assert.assertTrue(result.CityDisplyed());
       
       
    }

      
    @AfterClass
    public void clear()
    {
 	  driverManager.quit();
    }

}
