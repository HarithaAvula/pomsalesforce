package salesforcetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;
@Listeners(contestutility.TestEventListenersUtility.class)
public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);	

	}

	@FindBy(id  = "userNavLabel")
	WebElement userNavLabel;
	
	public String Username() {
		
	String 	username = "learningtest2023@gmail.com";
		
		driver.findElement(By.id("userNavLabel")).click();
		
		System.out.println("profile tab is clicked");
		
		driver.findElement(By.id("userNavMenu"));
		
		
		WebElement logout  = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		
		logout.click();
		
		System.out.println("Logout button is clicked");
		
		driver.get("https://ertg-dev-ed.develop.my.salesforce.com/");
		
		
	    WebElement user_id =  	driver.findElement(By.xpath("//*[@id=\"idcard-identity\"]"));
	
		System.out.println(user_id);
		
	     if(user_id.getText().equalsIgnoreCase(username)) {
		
		System.out.println("Username is same");
		
		
		
	
	}
		
	     return username;
	}
	

	
	
	
}
