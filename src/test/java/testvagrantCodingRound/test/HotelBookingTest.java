package testvagrantCodingRound.test;


import testvagrantCodingRound.Utility.ReadXlsx;
import testvagrantCodingRound.WebPages.HotelSearchResult;
import testvagrantCodingRound.WebPages.LandingPage;
import testvagrantCodingRound.driver.DriverManager;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class HotelBookingTest {


    
   
    
    DriverManager driverManager;
	WebDriver driver;
	//Initializes browser class and pagefactory elements
    @BeforeMethod
    public void setup()
    {
  	  driverManager=new DriverManager();
  	  driver=driverManager.getDriver();
  	  PageFactory.initElements(driver, this);
    }

    @Test(dataProvider="provideData")
    public void shouldBeAbleToSearchForHotels(Object data) throws InterruptedException {
        LandingPage bookHotel=new LandingPage(driver);
        HotelSearchResult result=bookHotel.bookHotel((Map<String, String>)data);
        Assert.assertTrue(result.CityDisplyed());
       
       
    }

    @DataProvider(parallel=true)
    public Object[] provideData()
    {
    	List<Map<String, String>> xcelData=new ReadXlsx().getData("HotelBookingTest");
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
