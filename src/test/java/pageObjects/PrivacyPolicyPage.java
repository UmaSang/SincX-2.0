package pageObjects;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivacyPolicyPage extends Basepage{
	

    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;
    public String currentUrl;
    public String headerValue;

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);

    }



//----------------PageObjects-------------------

    // Capture domain field
    @FindBy(xpath = "//input[@id='domainName']")
    public WebElement domainName;

    // Capture continue button
    @FindBy(xpath = "//p[text()='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement emailField;

    @FindBy(xpath= "//a[normalize-space()='privacy']")
    public WebElement privacyLink;

    @FindBy(xpath= " //h1[normalize-space()='Privacy policy']")
    public WebElement privacyPolicyPage;


    @FindBy(xpath="//h1[normalize-space()='Privacy policy']")
    public WebElement privacypolicy;



    //---------------------Action methods----------------
    // Send text to the domain field
    public void setTxtDomain(String domain) throws TimeoutException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(domainName));
        domainName.sendKeys(Keys.CONTROL + "a");
        domainName.sendKeys(Keys.DELETE);
        domainName.sendKeys(domain);
    }


    // click continue button
    public void continueClick() throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
    public void setPrivacyLinkClick() throws TimeoutException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(privacyLink));
        privacyLink.click();
    }


    // Capture new Window (Privacy Policy)
    public boolean clickPrivacyPolicyAndValidateTitle() throws TimeoutException{
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String originalWindowHandle = driver.getWindowHandle();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    //    wait.until(driver -> driver.getWindowHandles().size() > 1);

        // Switch to the new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOf(privacypolicy));

        // Validate the URL
        boolean result = driver.getCurrentUrl().contains("privacy-policy");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);
        System.out.println("Privacy Policy displayed: " + privacypolicy.isDisplayed());

        return result;
    }




    //----------------Validation---------------------


    public boolean validDomain() throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return emailField.isDisplayed();
    }
    public boolean PrivacyPolicy() throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(privacyPolicyPage));
        return privacyPolicyPage.isDisplayed();

    }



}



