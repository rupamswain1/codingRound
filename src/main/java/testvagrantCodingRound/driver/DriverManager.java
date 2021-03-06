package testvagrantCodingRound.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import testvagrantCodingRound.ReadProperty.ReadPropertyFile;

public class DriverManager {

	private WebDriver driver;
	
	//Initializes chrome driver, can be modified in future to add fire fox, IE and Edge browser
	public  DriverManager()
	{
		String browser=ReadPropertyFile.get("Browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ff") ||browser.toUpperCase().contains("FIRE"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		//implicit wait is made 0 where explicit wait is used
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		openUrl(ReadPropertyFile.get("url"));
	}
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	//method to open url
	public void openUrl(String url)
	{
		driver.get(url);
	}
	
	//method to close browser
	public void quit()
	{
		driver.quit();
	}
}
