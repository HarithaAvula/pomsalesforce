package salesforcetest;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

@Listeners(contestutility.TestEventListenersUtility.class)


public class loginpage extends BasePage{


	
	
	

	WebDriver driver;

	
	@FindBy(id  = "username")
	WebElement userName;

	

	@FindBy(id  = "password")
	WebElement passwrd;
	
	@FindBy (id = "Login") WebElement Login;
	
	public loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void enterUsername(String data) {
		WaitUntilElementIsVisible(userName,"username element");
		enterText(userName,data, "usernameEle");
	
	
	
	}
	
	
	public void  enterPassword(String data) {
		
		enterText(passwrd, data, "passwordEle");
		
	}
	
	
	public WebDriver clickLogin() {
		
		clickElement(Login,"login button element");
		
		return driver;
		
	}
	
	public String getTextFromAlert() {
	
		Alert alert = switchToAlert();
		return getAlertText(alert);
		
		
	}

}



