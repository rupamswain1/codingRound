package testvagrantCodingRound.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testvagrantCodingRound.ReadProperty.ReadPropertyFile;
import testvagrantCodingRound.Utility.DatePicker;
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
    
    @FindBy(xpath = "//li[@class=\"hotelApp \"]/child::a[node()]")
    private WebElement hotelLink;
    
    @FindBy(xpath="//ul[@id='ui-id-1']//li[2]")
    private WebElement automcompleteLocation;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchHotelButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    private String dateXpath="//td[contains(@data-month,'%month%')]//child::a[contains(text(),'%date%')]";
	
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
        DynamicWait.elementToBeClickable(driver, 20, signInButton);
        signInButton.click();
        //Error message is fetched
        return errorMessage.getText();
	}
	
	public FlightSearchResult searchFlight()
	{
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
        DatePicker.getWebelement(driver, ReadPropertyFile.get("FlightDate"), dateXpath).click();        
        //all fields filled in. Now click on search
        searchButton.click();
        return new FlightSearchResult(driver);

	}
	
	public HotelSearchResult bookHotel()
	{
		 hotelLink.click();

	        localityTextBox.sendKeys(ReadPropertyFile.get("location"));
	        //wait for auto suggest box to appear
	        DynamicWait.elementToBeClickable(driver, 10, automcompleteLocation);
	        automcompleteLocation.click();
	        new Select(travellerSelection).selectByVisibleText(ReadPropertyFile.get("travellers"));
	        searchHotelButton.click();
	        return new HotelSearchResult(driver);
	}
	
}
