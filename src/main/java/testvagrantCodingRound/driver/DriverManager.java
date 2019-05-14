package testvagrantCodingRound.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver driver;
	
	//Initializes chrome driver, can be modified in future to add fire fox, IE and Edge browser
	public  DriverManager()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//implicit wait is made 0 where explicit wait is used
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
