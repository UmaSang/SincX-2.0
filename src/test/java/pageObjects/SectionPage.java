package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
public class SectionPage extends Basepage {
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;


    public SectionPage(WebDriver driver) {
        super(driver);

    }
    //----------------PageObjects-------------------

    // Capture domain field
    @FindBy(xpath = "//input[@id='domainName']")
    public WebElement domainName;

    @FindBy(xpath = "//p[text()='Continue']")
    public WebElement continueButton;
    // Capture email field
    @FindBy(xpath = "//input[@id='userName']")
    public WebElement emailField;

    @FindBy (xpath="//span[@class='MuiButton-label']")
    public WebElement emailcontinueButton;

    //Capture password field
    @FindBy(xpath="//input[@id='pword']")
    public WebElement pwdField;
    // Capture login Button field
    @FindBy(xpath="//p[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath="//div[@class='_1ll1jn7']//img[@alt='Logo Image']")
    public WebElement sincxButton;

    @FindBy (xpath = "//img[contains(@src, 'course')]")
    public WebElement courseButton;

    @FindBy(xpath ="//tr[@class='MuiTableRow-root']")
    public List<WebElement> rowElements;
    @FindBy (xpath = "//i[@class='material-icons-outlined'][text()='more_vert']")
    public List <WebElement> threeDots;


    @FindBy (xpath = "(//button[@type='button'])[2] ")
    public WebElement sectionsThreeDots;



    @FindBy (xpath = " (//div[@class='_1h8njdls'])//tbody/tr[29]/td[2]")
    public WebElement courseName;

    @FindBy (xpath = " //a[@class='_gozzbg']")
    public WebElement editButton;


    @FindBy (xpath = " //div[@class='_8l7bnu']//a[2]")
    public WebElement sectionButton;
//(//span)[178]
////span[normalize-space()='Manual test_Busyqa_umatest']
////tbody/tr[33]/td[4]/div[1]/div[1]/button[1]/span[1]/i[1]

    @FindBy (xpath = "//span[@class='MuiButton-label']")
    public WebElement addButton;

    @FindBy (xpath = "//div[@role='dialog']")
    public WebElement dialogWindow;

    @FindBy (xpath = "//input[@id='title']")
    public WebElement titleField;

    @FindBy (xpath = "//input[@id='title']")
    public WebElement emptyTitleField;

    @FindBy (xpath = "//p[@class='MuiFormHelperText-root Mui-error Mui-required']")
    public WebElement provideTitlePopup;



    @FindBy (xpath = "//p[normalize-space()='Edit']")
    public WebElement sectionsEditButton;

    @FindBy (xpath = "//input[@id='order']")
    public WebElement orderField;

    @FindBy (xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text _cgnn4d']")
    public WebElement saveButton;


    @FindBy (xpath = " (//button[@type='button'])[3]")
    public WebElement toDeleteThreeDots;

    @FindBy (xpath = "(//p[@class='_2kamhyo'])[1]")
    public WebElement deleteButton;

    @FindBy (xpath = "  //input[@id='delete']")
    public WebElement deleteField;

    @FindBy (xpath = "//p[@class='_gkprm7'][normalize-space()='Delete']")
    public WebElement scenarioDeleteButton;




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


    // Send text to the email field
    public void setEmailField(String email) throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(Keys.CONTROL + "a");
        emailField.sendKeys(Keys.DELETE);
        emailField.sendKeys(email);
    }
    public void getEmailContinueButton()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(emailcontinueButton));
        emailcontinueButton.click();
    }
    // Send text to the password field
    public void setPasswordField(String pwd) throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(pwdField));
        pwdField.sendKeys(Keys.CONTROL + "a");
        pwdField.sendKeys(Keys.DELETE);
        pwdField.sendKeys(pwd);

    }

    // Click login button
    public void loginButton()
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }



    public void clickCourseName()  throws InterruptedException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(courseName));
        wait.until(ExpectedConditions.elementToBeClickable(courseName));
        courseName.click();
    }

    public void clickLogoButton() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(sincxButton));
        wait.until(ExpectedConditions.elementToBeClickable(sincxButton));
        sincxButton.click();
    }

    public void clickCourseButton() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(courseButton));
        wait.until(ExpectedConditions.elementToBeClickable(courseButton));
        courseButton.click();
    }


    public void clickThreeDots() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i=0;i< rowElements.size();i++)
        {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Manual test_Busyqa_umatest")) {
                System.out.println("Course :"+courseName);
                threeDots.get(i).click();
                wait.until(ExpectedConditions.elementToBeClickable(editButton));
                editButton.click();
                break;
            }
        }

    }

    public void clickEditButton() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(editButton));
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
    }


    public void clickSectionButton() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(sectionButton));
        wait.until(ExpectedConditions.elementToBeClickable(sectionButton));
        sectionButton.click();
    }
    public void clickAddButton() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(addButton));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

       public void clickTileField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(titleField));
        wait.until(ExpectedConditions.visibilityOf(titleField));
        titleField.sendKeys(Keys.CONTROL + "a");
        titleField.sendKeys(Keys.DELETE);
        titleField.sendKeys(text);
    }

    public void clickEmptyTitleField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(emptyTitleField));
        emptyTitleField.sendKeys(Keys.CONTROL + "a");
        emptyTitleField.sendKeys(Keys.DELETE);
        emptyTitleField.sendKeys(text);
    }

    public void clickOrderField(String number) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(orderField));
        orderField.sendKeys(Keys.CONTROL + "a");
        orderField.sendKeys(Keys.DELETE);
        orderField.sendKeys(number);
    }


    public void clickTextOrderField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(orderField));
        orderField.sendKeys(Keys.CONTROL + "a");
        orderField.sendKeys(Keys.DELETE);
        orderField.sendKeys(text);
    }
    public void clickSaveButton() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }


    public void clickSectionThreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(sectionsThreeDots));
        wait.until(ExpectedConditions.elementToBeClickable(sectionsThreeDots));
        sectionsThreeDots.click();
    }



    public void clickSectionEditButton() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(sectionsEditButton));
        wait.until(ExpectedConditions.elementToBeClickable(sectionsEditButton));
        sectionsEditButton.click();
    }

    public void clickToDeleteThreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( toDeleteThreeDots));
        wait.until(ExpectedConditions.elementToBeClickable( toDeleteThreeDots));
        toDeleteThreeDots.click();
    }


    public void clickDeleteButton() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( deleteButton));
        wait.until(ExpectedConditions.elementToBeClickable( deleteButton));
        deleteButton.click();
    }




    public void textDeleteField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( deleteField));
        wait.until(ExpectedConditions.visibilityOf(deleteField));
        deleteField.sendKeys(Keys.CONTROL + "a");
        deleteField.sendKeys(Keys.DELETE);
        deleteField.sendKeys(text);
    }

    public void clicksScenarioDeleteButton() throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf( scenarioDeleteButton));
        wait.until(ExpectedConditions.elementToBeClickable( scenarioDeleteButton));
        scenarioDeleteButton.click();
    }


    //----------Validation----------------------



    public boolean validateCoursePage() throws TimeoutException{
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String originalWindowHandle = driver.getWindowHandle();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        boolean result = driver.getCurrentUrl().contains("courses");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);
        //  System.out.println("Privacy Policy displayed: " + privacypolicy.isDisplayed());

        return result;
    }


    public boolean validateSectionPage() throws TimeoutException{
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        boolean result = driver.getCurrentUrl().contains("sections");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);
        //  System.out.println("Privacy Policy displayed: " + privacypolicy.isDisplayed());

        return result;
    }

    public boolean validateDialogWindow() throws TimeoutException
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOf(dialogWindow)));
        return dialogWindow.isDisplayed();
    }

    public boolean provideTitlePopup() throws TimeoutException
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOf(dialogWindow)));
        return provideTitlePopup.isDisplayed();
    }





}





