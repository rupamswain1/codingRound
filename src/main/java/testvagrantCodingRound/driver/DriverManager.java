package testvagrantCodingRound.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver driver;
	
	public  DriverManager()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void openUrl(String url)
	{
		driver.get(url);
	}
	public void quit()
	{
		driver.quit();
	}
}
