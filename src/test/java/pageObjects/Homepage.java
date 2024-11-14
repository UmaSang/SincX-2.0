package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends Basepage {

	public WebDriverWait wait;

	public Homepage(WebDriver driver) {
		super(driver);
	}

//Locators	

	@FindBy(xpath = "//p[@for='domain']")
	public WebElement domainpage;

	@FindBy(xpath = "//input[@id='domainName']")
	public WebElement txtdomainname;

	@FindBy(xpath = "//input[@id='domainName']")
	public WebElement indomainname;

	@FindBy(xpath = "//input[@id='domainName']")
	public WebElement extdomainname;

	@FindBy(xpath = "//span[@class='MuiButton-label']")
	public WebElement Continuebutton;

	@FindBy(xpath = "//div[@role='alert']")
	public WebElement alert;

	@FindBy(xpath = "//input[@id='pword']")
	public WebElement pwdField;

	@FindBy(xpath = "//div[@role='alert']")
	public WebElement pwdalert;

	@FindBy(xpath = " //div[@role='alert']")
	public WebElement alertPopup;
	
	
	@FindBy(xpath= "//span[normalize-space()='Dismiss']")
	public WebElement dismissButton;

	@FindBy(xpath = "//input[@id='userName']")
	public WebElement txtusername;

	@FindBy(xpath = ("//button[@type='button']"))
	public WebElement continuebutton;

	@FindBy(xpath = "//input[@id='pword']")
	public WebElement txtpassword;

	@FindBy(xpath = "//button[@type='button']")
	public WebElement loginbutton;

	@FindBy(xpath = "div[class='_cliwdz'] h1[class='_k8siqs']")
	public WebElement welcomemsg;

	@FindBy(xpath = "//a[normalize-space()='privacy']")
	public WebElement privacyLink;

	@FindBy(xpath = " //h1[normalize-space()='Privacy policy']")
	public WebElement privacyPolicyPage;

	@FindBy(xpath = "//p[text()='Start over']")
	public WebElement startOverLink;

	@FindBy(xpath = "//h1[@class='_k8siqs']")
	public WebElement msgconfirmation;

	@FindBy(xpath = "//p[@class='_1hx0zhz'][normalize-space()='Profile']")
	public WebElement profilebutton;

	@FindBy(xpath = "div[class='_mwa2db'] img[alt='Logo Image']")
	public WebElement sincxlogo;

	@FindBy(xpath = "//div[@class='_mwa2db']//img[@alt='Logo Image']")
	public WebElement clickSincxLogo;

	@FindBy(xpath = "//p[normalize-space()='Admin mode']")
	public WebElement adminmode;

	@FindBy(xpath = "//h1[@class='_k8siqs']")
	public WebElement messageconfirmation;

	@FindBy(xpath = "//i[@class='material-icons-outlined']")
	public WebElement sbutton;

	@FindBy(xpath = "//p[normalize-space()='Logout']")
	public WebElement logout;

	public int sheetindex;
	
	
	
	

//Action Methods//

	public void set_domainname(String dname) throws TimeoutException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(txtdomainname));
		txtdomainname.sendKeys(Keys.CONTROL + "a");
		txtdomainname.sendKeys(Keys.DELETE);
		txtdomainname.sendKeys(dname);
	}

	public void click_firstcontiunebutton() throws TimeoutException  {

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(Continuebutton));
		Continuebutton.click();
	}

	public void externalDomain(String ext_domainname) throws TimeoutException  {

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(extdomainname));
		extdomainname.sendKeys(Keys.CONTROL + "a");
		extdomainname.sendKeys(Keys.DELETE);
		extdomainname.sendKeys(ext_domainname);
	}

	public void inDomainName(String in_domainname) throws TimeoutException
	{

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(indomainname));
		indomainname.sendKeys(Keys.CONTROL + "a");
		indomainname.sendKeys(Keys.DELETE);
		indomainname.sendKeys(in_domainname);
	}

	public void click_Sincxlogo() throws TimeoutException
	{

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(clickSincxLogo));
		clickSincxLogo.click();
	}

	public void click_dismissButton() throws TimeoutException
	{

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(dismissButton));
		dismissButton.click();
		txtusername.clear();
	}
	
	public void set_username(String user_name) throws TimeoutException
	{

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(txtusername));
		txtusername.sendKeys(Keys.CONTROL + "a");
		txtusername.sendKeys(Keys.DELETE);
		txtusername.sendKeys(user_name);
	}

	public void click_secondcontiunebutton() throws TimeoutException
	
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(continuebutton));
		continuebutton.click();

	}
	public void click_sincxlogobutton() throws TimeoutException  {

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(sincxlogo));
		sincxlogo.click();
	}
	public void set_pwd(String pwd) throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(txtpassword));
		txtpassword.sendKeys(Keys.CONTROL + "a");
		txtpassword.sendKeys(Keys.DELETE);
		txtpassword.sendKeys(pwd);
	}

	public void setTwoComPwd(String pwd) throws TimeoutException  {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(txtpassword));
		txtpassword.sendKeys(Keys.CONTROL + "a");
		txtpassword.sendKeys(Keys.DELETE);
		txtpassword.sendKeys(pwd);
	}
	

	public void domainPageisDisplayed() throws TimeoutException  {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(txtdomainname));
		txtdomainname.sendKeys(Keys.CONTROL + "a");
		txtdomainname.sendKeys(Keys.DELETE);
	
	}

	public void clickStartOverLink() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(startOverLink));
		startOverLink.click();

	}

	



	public void click_loginbutton() throws TimeoutException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(loginbutton));
		loginbutton.click();
	}

	public void setPrivacyLinkClick() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(privacyLink));
		privacyLink.click();
	}

	public void click_profilebutton() throws TimeoutException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(profilebutton));
		profilebutton.click();
	}

	public void click_adminmode() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(adminmode));
		adminmode.click();

	}

	public void click_settingbutton()throws TimeoutException  {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(sbutton));
		sbutton.click();
	}

	public void click_logout() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}

	
	
	
	
	
	
	
	
//Validation//

	public boolean domainpageisDisplayed() throws TimeoutException 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(domainpage));
		return domainpage.isDisplayed();
	}
	
	public boolean InvalidDomain() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(alertPopup));
		return alertPopup.isDisplayed();
	}
	

	public boolean disButton() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(dismissButton));
		return dismissButton.isDisplayed();
	}
	
	public boolean validDomain() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(txtusername));
		return txtusername.isDisplayed();
	}

	public boolean pop_alert() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(alert));
		return alert.isDisplayed();
	}
	public boolean welcomepage() throws TimeoutException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(welcomemsg));
		return welcomemsg.isDisplayed();
	}
	
	public boolean validPassword() throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        System.out.println("Current URL: " + driver.getCurrentUrl());
        if(driver.getCurrentUrl().contains("dashboard"))
        {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='_k8siqs']"))));
            return true;
        }
        return false;
    }
	
	public boolean verify_profilepage() throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        System.out.println("Current URL: " + driver.getCurrentUrl());
        if(driver.getCurrentUrl().contains("profile"))
        {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='_cliwdz'])[2]"))));
            return true;
        }
        return false;
    }
	
	public boolean invalidEmail() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(alert));
		return alert.isDisplayed();
	}
	
	
	
	
	public boolean isConfirmationMsgDisplayed() throws TimeoutException  { // p[@class='_pxo6mo']
		try {
			// Check if the message is displayed and return true if successful
			return sincxlogo.isDisplayed(); // or any other condition you need to check
		} catch (Exception e) {
			// If an exception occurs, return false
			return false;
		}
	}

	public boolean alert_popup() throws TimeoutException { // p[@class='_pxo6mo']
		try {
			// Check if the message is displayed and return true if successful
			return alert.isDisplayed(); // or any other condition you need to check
		} catch (Exception e) {
			// If an exception occurs, return false
			return false;
		}
	}

	public boolean alert_pwd() throws TimeoutException { // p[@class='_pxo6mo']
		try {
			// Check if the message is displayed and return true if successful
			return pwdalert.isDisplayed(); // or any other condition you need to check
		} catch (Exception e) {
			// If an exception occurs, return false
			return false;
		}
	}

	public boolean validUsername() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pwdField));
		return pwdField.isDisplayed();
	}

	public boolean twoCombinationPwd() throws TimeoutException { // p[@class='_pxo6mo']
		try {
			// Check if the message is displayed and return true if successful
			return pwdalert.isDisplayed(); // or any other condition you need to check
		} catch (Exception e) {
			// If an exception occurs, return false
			return false;
		}
	}
//				public boolean twoCombinationPwd() throws TimeoutException{
//
//					wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//					wait.until(ExpectedConditions.visibilityOf(pwdalert));
//					return pwdalert.isDisplayed();
//				}			
//			

	public String getConfirmationMsg() throws TimeoutException  {
		try {
			return (msgconfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public boolean PrivacyPolicy() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(privacyLink));
		return privacyLink.isDisplayed();
	}

	public boolean PrivacyPolicyPage() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(privacyPolicyPage));
		return privacyPolicyPage.isDisplayed();
	}
	
	

	public boolean pwd_alert() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(pwdalert));
		return pwdalert.isDisplayed();
	}

	public String getConfirmaMsg()throws TimeoutException  {
		try {
			return (messageconfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
