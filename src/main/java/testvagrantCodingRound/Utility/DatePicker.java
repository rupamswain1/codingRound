package testvagrantCodingRound.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker 
{
	//this method will provide webeement for date provided in test data file
	public static WebElement getWebelement(WebDriver driver, String date, String xpath)
	{
		String[] dateData=date.split("/");
		xpath=xpath.replaceAll("%date%", dateData[0]);
		xpath=xpath.replaceAll("%month%", Integer.parseInt(dateData[1])-1+"");
		System.out.println(xpath);
		return driver.findElement(By.xpath(xpath));
	}
}
