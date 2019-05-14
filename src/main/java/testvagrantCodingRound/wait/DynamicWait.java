package testvagrantCodingRound.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWait {
	
	//Explicit wait for element to be clickable.
	public static void elementToBeClickable(WebDriver driver, int timeInSecond, WebElement locator)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
