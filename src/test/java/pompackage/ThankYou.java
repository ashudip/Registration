package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ThankYou {
	
	private static WebElement element = null;
	
	//get the thank you message after registration
	
	public static WebElement thankyoumsg(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//h6[contains(text(),'Thank You!')]"));
		
		return element;
	}	 
	//message after thank you message
	public static WebElement message(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//p[@class='text-center']"));
		return element;		
	}
	
}
