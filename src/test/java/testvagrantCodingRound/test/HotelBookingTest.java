package testvagrantCodingRound.test;


import testvagrantCodingRound.ReadProperty.ReadPropertyFile;
import testvagrantCodingRound.Utility.DynamicWait;
import testvagrantCodingRound.driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelBookingTest {

    @FindBy(xpath = "//li[@class=\"hotelApp \"]/child::a[node()]")
    private WebElement hotelLink;
    
    @FindBy(xpath="//ul[@id='ui-id-1']//li[2]")
    private WebElement automcompleteLocation;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(xpath="//a[@class='button action resetLink']")
    private WebElement result;
    
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
    public void shouldBeAbleToSearchForHotels() throws InterruptedException {
        driverManager.openUrl(ReadPropertyFile.get("url"));
        hotelLink.click();

        localityTextBox.sendKeys(ReadPropertyFile.get("location"));
        //wait for auto suggest box to appear
        DynamicWait.elementToBeClickable(driver, 10, automcompleteLocation);
        automcompleteLocation.click();
        new Select(travellerSelection).selectByVisibleText(ReadPropertyFile.get("travellers"));
        searchButton.click();
        //wait for page to be loaded and Show link to be displayed
        DynamicWait.elementToBeClickable(driver, 10, result);
        String resultString=result.getText();
        Assert.assertTrue(resultString.contains("Show all"));
       
    }

      
    @AfterClass
    public void clear()
    {
 	  driverManager.quit();
    }

}
