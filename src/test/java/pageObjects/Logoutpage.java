package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logoutpage  extends Basepage {

	public WebDriverWait wait;

	public Logoutpage(WebDriver driver) {
		
		super(driver);
	
	}
	//Locators
	
	@FindBy(xpath = "//p[@class='_1hx0zhz'][normalize-space()='Profile']")
	WebElement profilebutton;

	@FindBy(xpath = "//p[normalize-space()='Admin mode']")
	WebElement adminmode;
	

	@FindBy(xpath = "//i[@class='material-icons-outlined']")
	WebElement sbutton;
	

	@FindBy(xpath = "//p[normalize-space()='Logout']")
	WebElement logout;
	




//Action Methods

	public void click_profilebutton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(profilebutton));
		profilebutton.click();
	}

	public void click_adminmode() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(adminmode));
		adminmode.click();

	}


public void click_settingbutton() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	wait.until(ExpectedConditions.visibilityOf(sbutton));
	sbutton.click();
}


public void click_logout() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	wait.until(ExpectedConditions.visibilityOf(logout));
	logout.click();
}












}