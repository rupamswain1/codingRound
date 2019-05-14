package testvagrantCodingRound.test;

import testvagrantCodingRound.ReadProperty.ReadPropertyFile;
import testvagrantCodingRound.driver.DriverManager;
import testvagrantCodingRound.wait.DynamicWait;

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

    @FindBy(id="OneWay")
    WebElement oneWay;
    
    @FindBy(id="FromTag")
    WebElement fromLocation;

    @FindBy(id="ToTag")
    WebElement toLocation;
    
    @FindBy(xpath="//ul[@id='ui-id-1']//li[1]")
    private WebElement FromautomcompleteLocation;
    
    @FindBy(xpath="//ul[@id='ui-id-2']//li[1]")
    private WebElement ToautomcompleteLocation;
    
    @FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
    private WebElement datePicker;
    
    @FindBy(id="SearchBtn")
    private WebElement searchButton;
    
    @FindBy(xpath="//div[@class='searchSummary']")
    private WebElement searchSummary;
    

    DriverManager driverManager;
	WebDriver driver;
	
	//Initializes browser class and pagefactory elements
    @BeforeClass
    public void setup()
    {
  	  driverManager=new DriverManager();
  	  driver=driverManager.driver;
  	  PageFactory.initElements(driver, this);
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

    	driverManager.openUrl(ReadPropertyFile.get("url"));
        oneWay.click();
    	fromLocation.clear();
    	fromLocation.sendKeys(ReadPropertyFile.get("From"));
        //wait for the auto complete options to appear for the origin
    	DynamicWait.elementToBeClickable(driver, 20, FromautomcompleteLocation);
        FromautomcompleteLocation.click();

        toLocation.clear();
        toLocation.sendKeys(ReadPropertyFile.get("To"));
        //wait for the auto complete options to appear for the destination
    	DynamicWait.elementToBeClickable(driver, 20, ToautomcompleteLocation);
        //select the first item from the destination auto complete list
        ToautomcompleteLocation.click();
        datePicker.click();
        
        //all fields filled in. Now click on search
        searchButton.click();

        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

       
     }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    @AfterClass
    public void clear()
    {
 	  driverManager.quit();
    }

    
}
