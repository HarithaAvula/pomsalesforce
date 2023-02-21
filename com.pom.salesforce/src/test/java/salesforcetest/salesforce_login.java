package salesforcetest;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.awt.datatransfer.StringSelection;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Toolkit;
import org.openqa.selenium.Alert;
// options--
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import contestutility.constant;
import contestutility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(contestutility.TestEventListenersUtility.class)

@Test
public class salesforce_login  extends BaseTest{


	private static Properties propertyFile;
	public static  void login() throws InterruptedException, IOException {
		
      PropertiesUtility propertiesUtility =new PropertiesUtility();
   
      Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
		
		String url=propertiesUtility.getPropertyValue("url");
		String username=propertiesUtility.getPropertyValue("login.valid.userid");
		String password=propertiesUtility.getPropertyValue("login.valid.password");
		

		
		String expected = "Home Page ~ Salesforce - Developer Edition";
	     GetDriverInstance("chrome");
	     goToUrl(url);
			
			By idLoc = By.id("username");
		logger.info("started");
		
	     loginpage loginpage = new loginpage(driver);
	     Thread.sleep(1000);
	     loginpage.enterUsername(username);
	     Thread.sleep(1000);
	     loginpage.enterPassword(password);
	     loginpage.clickLogin();
	     String result  =     driver.getTitle();
	     
		 if (result.equalsIgnoreCase(expected)) {
			 
			 System.out.println(result);
			 logger.info(result);
			 
			 
		 }
			
driver.close();


	}
	
	
	@Test
	
public static void loginwrong() throws InterruptedException {
		
		PropertiesUtility propertiesUtility =new PropertiesUtility();
		   
	      Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
			
			String url=propertiesUtility.getPropertyValue("url");
			String username=propertiesUtility.getPropertyValue("login.valid.userid");
			String password=propertiesUtility.getPropertyValue("");
			

			
			String expected = "Home Page ~ Salesforce - Developer Edition";
		     GetDriverInstance("chrome");
		     goToUrl(url);
				
				By idLoc = By.id("username");
			logger.info("started");
			
		     loginpage loginpage = new loginpage(driver);
		     Thread.sleep(1000);
		     loginpage.enterUsername(username);
		     Thread.sleep(1000);
		     WebElement password_ele = 	driver.findElement(By.id("password"));
				String password_value = password_ele.getAttribute("value");
		     
		    // String password_value = password.getAttribute("value");
				
				if(password_value.isEmpty()) {
					
					System.out.println("password box is empty");
					
					
				}
				
				loginpage.clickLogin();
			    
				
			    WebElement error_msg = 	driver.findElement(By.id("error"));
			   System.out.println(error_msg.getText());
			   logger.error(error_msg.getText());
			    driver.close();
			
				
			}
@Test
public static void remberbox() throws InterruptedException {
	
	 PropertiesUtility propertiesUtility =new PropertiesUtility();
	   
     Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
		
		String url=propertiesUtility.getPropertyValue("url");
		String username=propertiesUtility.getPropertyValue("login.valid.userid");
		String password=propertiesUtility.getPropertyValue("login.valid.password");
		

		
		String expected = "Home Page ~ Salesforce - Developer Edition";
	     GetDriverInstance("chrome");
	     goToUrl(url);
			
			By idLoc = By.id("username");
		logger.info("started");
		
	     loginpage loginpage = new loginpage(driver);
	     Thread.sleep(1000);
	     loginpage.enterUsername(username);
	     Thread.sleep(1000);
	     loginpage.enterPassword(password);
	     driver.findElement(By.name("rememberUn")).click();
			logger.info("Remember checkbox is clicked");
	     loginpage.clickLogin();
	     String result  =     driver.getTitle();
	     
		 if (result.equalsIgnoreCase(expected)) {
			 
			 System.out.println(result);
			 logger.info(result);
			 
			 
		 }
			
driver.close();

	
	
}
	@Test
	
public static void forgotpassword() {
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().fullscreen();
	
	driver.get("https://login.salesforce.com/");
	
	driver.get("https://ertg-dev-ed.develop.my.salesforce.com/secur/forgotpassword.jsp?locale=us");
	
	driver.findElement(By.xpath("//input[@id='un']")).sendKeys("learningtest2023@gmail.com");
	driver.findElement(By.id("continue")).click();
	
 	WebElement message = 	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]"));
	System.out.println(message.getText());
	 logger.info(message.getText());
	 
	
	
}

	@Test
	public static void wrong_details() throws InterruptedException {
		PropertiesUtility propertiesUtility =new PropertiesUtility();
		   
	    Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
			
			String url=propertiesUtility.getPropertyValue("url");
			String username=propertiesUtility.getPropertyValue("login.invalid.userid");
			String password=propertiesUtility.getPropertyValue("login.invalid.password");
			
			 GetDriverInstance("chrome");
				
				goToUrl(url);
				
				By idLoc = By.id("username");
				
				

			     loginpage loginpage = new loginpage(driver);
			     Thread.sleep(1000);
			     loginpage.enterUsername(username);
			     Thread.sleep(1000);
			     loginpage.enterPassword(password);
			     loginpage.clickLogin();
			     
			     WebElement error_msg = 	driver.findElement(By.id("error"));
			 	logger.error(error_msg.getText());
			 	
			 	driver.close();
			 	
	}	
	
	@Test
	
	public static void returnfromhome() throws InterruptedException {
		 PropertiesUtility propertiesUtility =new PropertiesUtility();
		   
	      Properties propertyFile= propertiesUtility.loadFile("applicationDataProperties");
			
			String url=propertiesUtility.getPropertyValue("url");
			String username=propertiesUtility.getPropertyValue("login.valid.userid");
			String password=propertiesUtility.getPropertyValue("login.valid.password");
			

			
			String expected = "Home Page ~ Salesforce - Developer Edition";
		     GetDriverInstance("chrome");
		     goToUrl(url);
				
				By idLoc = By.id("username");
			logger.info("started");
			
		     loginpage loginpage = new loginpage(driver);
		     Thread.sleep(1000);
		     loginpage.enterUsername(username);
		     Thread.sleep(1000);
		     loginpage.enterPassword(password);
		     loginpage.clickLogin();
		     String result  =     driver.getTitle();
		     
			 if (result.equalsIgnoreCase(expected)) {
				 
				 System.out.println(result);
				 logger.info(result);
				 
				 
			 }
		
			 HomePage homepage = new HomePage(driver);
			String username1 =  homepage.Username();
			
		    logger.info("same user name");
		
		driver.close();
		
	
	}
}
