package registrationtest;

import java.sql.Connection;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;





public class TokenValidation {
	WebDriver driver;
	String token = null;
	String url= "https://rest.bldmn24.com/verify_registration.php?type=individual&token=";
	String url1;
	//String usertoken = "4344da24dd744ea529cc2b1178b6029362f0394d1ee9d21ddd3de640c3f5dda8";
	 Connection con;
	    @Test
	     public void init(String email){
	        try {
	                    
	        	token =  Databasequeries.token_query(email);
	        	url1 = url+token;
	        	System.out.println(url1);
	        	//driver.navigate().to(url1);
	        	//Thread.sleep(5000);
	        	 
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	            }
	        }
}
