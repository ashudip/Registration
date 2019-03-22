package pompackage;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstFormPOM {
	private static List<WebElement> elements = null;
	
	private static WebElement element = null;
	
	//enter url
	public static String enterurl()
	{
		String url = "https://rest.bldmn24.com/accounts/";
		return url;
	}
	
	
	
	//register link on login page
	public static WebElement registerlink(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
		return element;
	}	 
	//individual registration link on image
	public static WebElement individualreg(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//h4[contains(text(),'Individual Account')]"));
		return element;
	}
	public static WebElement Firstname(WebDriver driver){
	 
	    element = driver.findElement(By.xpath("//input[@id='input-first-name']"));
	 
	    return element;
	   }
	
	 public static WebElement Lastname(WebDriver driver){
		 
		    element = driver.findElement(By.xpath("//input[@id='input-last-name']"));
		 
		    return element;
	  }
	 
	 public static WebElement email(WebDriver driver)
	 {
		 element = driver.findElement(By.xpath("//input[@id='input-email']"));
		 return element;
	 }
	 
	 public static WebElement confirmemail(WebDriver driver)
	 {
		 element = driver.findElement(By.xpath("//input[@id='input-confirm-email']"));
		 return element;
	 }
	 
	public static WebElement password(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='input-password']"));
		return element;
	}
	
	public static WebElement confirmpassword(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='input-retype-new-password']"));
		return element;
	}
	public static WebElement clickdialcode(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),'Dial Code')]"));
		return element;
	}
	//text box to enter the dial code
	public static WebElement dialcodetextbox(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@autocomplete='off']"));
		return element;
	}
	//select the highlighted text
	public static WebElement selectHighlightedtext(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//span[contains(text(),'+91 India')]"));
		return element; 
				
	}
	
	public static WebElement mobileno(WebDriver driver) 
	{
		element = driver.findElement(By.xpath("//input[@id='input-mobile']"));
		return element;
	}
	
	public static List<WebElement> Iagreecheckbox(WebDriver driver)
	{
		
		elements = driver.findElements(By.xpath("//span[@class='required-text']"));
		return elements;
	}
	//register button of first form on individual page
	public static WebElement registerbtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@class='btn btn-success w-100 text-uppercase']"));
		return element;
	}
	//first name requuired msg
	public static WebElement usernamereq(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(text(),' Valid first name is required. ')]"));
		return element;
	}
	//lastname required msg
	public static WebElement lastnamereq(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),' Valid last name is required. ')]"));
		return element;
	}
	//email required msg
	public static List<WebElement> emailreq(WebDriver driver)
	{
		elements = driver.findElements(By.xpath("//div[contains(text(),' Valid email is required. ')]"));
		return elements;
	}
	//password required message
	public static WebElement validpasswordreq(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(text(),' Valid password is required. ')]"));
		return element;		
	}
	
	public static WebElement passwordreq(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),' Password is required. ')]"));
		return element;
	}
	public static WebElement validphonereq(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),' Valid mobile no. is required. ')]"));
		return element;
	}
	
	//validation if email and confirm email are not same
	public static WebElement confirmpassworddoesntmatch(WebDriver driver){
		element = driver.findElement(By.xpath("//div[contains(text(),' Confirm email must be same as email. ')]"));
		return element;	
	}
	
	//validation message if password and confirm password dont match
	public static WebElement passconfirmpassdontmatch(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),' Confirm password must be same as password. ')]"));
		return element;
	}
	
}
