package registrationtest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.graphbuilder.curve.Point;

import pompackage.FirstFormPOM;
import readwriteexcel.ReadExcel;
import readwriteexcel.WriteExcel;

public class IndiRegFirstForm {
	WebDriver driver;
    String xl_path,xl_tcRes,xl_TsRes;
    int xRows_TC, xRows_TS, xCols_TC, xCols_TS,randno;
    String[][] xlTC, xlTS;
    String vKW, IP1, IP2,IP3,IP4,IP5,IP6,IP7,IP8,IP9,Vactual,vExpected;
    String vTS_Res, vTC_Res;
    String res;
    
    @BeforeTest
    public void init() throws IOException
    {
    	xl_path = "/home/codemaxpc-01/Desktop/BTA/seleniumTC/Register.xlsx";
    	xl_tcRes = "/home/codemaxpc-01/Desktop/BTA/seleniumTC/Register_Tcres.xlsx";
    	xl_TsRes = "/home/codemaxpc-01/Desktop/BTA/seleniumTC/Register_TSres.xlsx";
    	   xlTC = ReadExcel.readXL(xl_path,"Test cases");
           xlTS = ReadExcel.readXL(xl_path,"Test Steps");
       xRows_TC = xlTC.length;
       xCols_TC = xlTC[0].length;
       System.out.println("TC Rows are " + xRows_TC);
       System.out.println("TC Cols are " + xCols_TC);
       
       xRows_TS = xlTS.length;
       xCols_TS = xlTS[0].length;
       System.out.println("TS Rows are " + xRows_TS);
       System.out.println("TS Cols are " + xCols_TS);
    }
  @Test
  public void f() {
	  for (int i = 1; i <xRows_TC; i++) {

          if(xlTC[i][2].equals("Y"))
          {
              System.out.println("Test case ready for execution :-"+xlTC[i][0]);
              vTC_Res = "pass";
              for (int j = 1; j < xRows_TS; j++) {
                  if(xlTC[i][0].equals(xlTS[j][0]))
                  {
                      vKW  = xlTS[j][3];
                      //username
                      IP1 = xlTS[j][4];
                     //lastname
                      IP2 = xlTS[j][5];
                      //email
                      IP3 = xlTS[j][6];
                      //confirmemail
                      IP4 = xlTS[j][7];
                      //password
                      IP5 = xlTS[j][8];
                      //confirmpassword
                      IP6 = xlTS[j][9];
                      //phone no
                      IP7 = xlTS[j][10];
                      //affiliatename
                      IP8 = xlTS[j][11];
                      //affiliate email
                      IP9 = xlTS[j][12];
                      vExpected = xlTS[j][13];  
                      vTS_Res = "pass";
                      System.out.println("KW: " + vKW);
                      System.out.println("IP1: " + IP1);
                      System.out.println("IP2: " + IP2);
                      System.out.println("IP3: " + IP3);
                      System.out.println("IP4: " + IP4);
                      System.out.println("IP5: " + IP5);
                      System.out.println("IP6: " + IP6);
                      System.out.println("IP7: " + IP7);
                      System.out.println("IP8: " + IP8);
                      System.out.println("IP9: " + IP9);
                      
                      System.out.println("vExpected: " +vExpected);
                      try {
                      
                     res = execute(vKW,IP1,IP2,IP3,IP4,IP5,IP6,IP7,IP8,IP9,vExpected);
                              if(vTS_Res.equals("pass"))
                              {
                                  vTS_Res = "pass";
                                 // takeScreenshot("/home/codemaxpc-01/Desktop/BTA/PassScreenshot/pass"+xlTC[i][0]+"_"+j+".png");
                                  
                              }
                          else {
                               
                              vTS_Res = "verfication failed";
                              vTC_Res = "fail";
                             xlTS[j][16] = "look at the screenshot";
                           //  takeScreenshot("/home/codemaxpc-01/Desktop/BTA/FailScreenshot/fail"+xlTC[i][0]+"_"+j+".png");
                                  
                          }
                      } catch (Exception e) {
                          // TODO: handle exception
                          System.out.println("My coding errror "+e);
                          vTC_Res = "fail";
                          vTS_Res = "fail";
                          xlTS[j][16] = "look at screenshot";
                         // takeScreenshot("/home/codemaxpc-01/Desktop/BTA/FailScreenshot/fail"+xlTC[i][0]+"_"+j+".png");
                       }
                      //actual result
                      xlTS[j][14] = res;
                      //expected result
                      xlTS[j][15] = vTS_Res;
                  }
              }
              xlTC[i][3] = vTC_Res;
      }
          else
          {
              System.out.println("test case not ready for execution"+xlTC[i][0]);
          }
      }
	  
	  
  }
  @AfterTest
  public void teardown() throws Exception
  {
      WriteExcel.writeXL(xl_tcRes, "Test cases", xlTC);
      WriteExcel.writeXL(xl_TsRes, "Test steps", xlTS);
      //driver.quit();        
  }
  
  //keywords will be matched
  
  public String execute(String KW,String ip1,String ip2,String ip3,String ip4,String ip5,String ip6,String ip7,String ip8,String ip9,String expected) throws InterruptedException
  {
	 
      
	  if(KW.equalsIgnoreCase("LaunchBrowser"))
      {
         launchbrowser();
          return null;
      }
  	else if(KW.equalsIgnoreCase("enter_url"))
  	{
  		enter_url(ip1);
  		return null;
  	}
  	else if(KW.equalsIgnoreCase("click_Register_link"))
  	{
  		click_register_link();
  		return null;
  	}
  	else if(KW.equalsIgnoreCase("Click_indiReg_link"))
  	{
  		Click_indiReg_link();
  		return null;
  	}
  	else if (KW.equalsIgnoreCase("enter_details"))
  	{
  		enter_details(ip1, ip2, ip3, ip4, ip5, ip6, ip7, ip8, ip9);
  		return null;
  	}
  	else if (KW.equalsIgnoreCase("CloseBrowser"))
  	{
  		closebrowser();
  		return null;
  	}
  	else
  	{
  		return null;
  	}
	  
  }
  //click on register link on login page
  public void launchbrowser()
	{
		System.setProperty("webdriver.gecko.driver","/home/codemaxpc-01/Desktop/BTA/geckodriver");	   
  	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	public  void enter_url(String ip1)
	{
		driver.navigate().to(ip1);
	}
  public void click_register_link()
  {
	  FirstFormPOM.registerlink(driver).click();
  }
  
  // click on individual registration link
  public void Click_indiReg_link()
  {
	  FirstFormPOM.individualreg(driver).click(); 
  }
  public void enter_details(String ip1,String ip2,String ip3,String ip4,String ip5,String ip6,String ip7,String ip8,String ip9) throws InterruptedException
  {
	  
	  //enter username
	  FirstFormPOM.Firstname(driver).sendKeys(ip1);
	  //enter lastname
	  FirstFormPOM.Lastname(driver).sendKeys(ip2);
	  //enter email
	  FirstFormPOM.email(driver).sendKeys(ip3);
	  //enter confirm email
	  FirstFormPOM.confirmemail(driver).sendKeys(ip4);
	  //enter password
	  FirstFormPOM.password(driver).sendKeys(ip5);
	  //enter confirm password
	  FirstFormPOM.confirmpassword(driver).sendKeys(ip6);
	  //select india code
	  FirstFormPOM.clickdialcode(driver).click();
	  //enter india dial code
	  FirstFormPOM.dialcodetextbox(driver).sendKeys("+91");
	  Thread.sleep(1000);
	  //select highlighted text
	  //WebDriverWait wait  = new WebDriverWait(driver,10);
	  //wait.until(ExpectedConditions.elementToBeClickable(FirstFormPOM.selectHighlightedtext(driver)));
	  FirstFormPOM.selectHighlightedtext(driver).click();
	  FirstFormPOM.mobileno(driver).sendKeys(ip7);
	  //select i agree text box
	  Thread.sleep(1000);
	  WebElement checkbox = FirstFormPOM.Iagreecheckbox(driver);
	  if(!checkbox.isSelected())
	  {
		  System.out.println("check box not selected");
		  checkbox.click();
	  }
	  Thread.sleep(2000);
  }
  public void closebrowser()
 	{
 		driver.close();
 	}
}
