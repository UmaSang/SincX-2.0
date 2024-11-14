package pageObjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage  extends Basepage {

    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;


    public DashboardPage(WebDriver driver) {
        super(driver);

    }


//----------------PageObjects-------------------

    @FindBy(xpath="//a[contains(@href, 'admin/orgs')]")
    public WebElement sincxButton;

    @FindBy (xpath = "//img[contains(@src, 'course')]")
    public WebElement courseButton;

    @FindBy (xpath = " (//div[@class='_1h8njdls'])//tbody/tr[29]/td[2]")
    public WebElement courseName;


    @FindBy (xpath = "(//div[@role='button'])[7]")
    public WebElement dashBoardButton;


    @FindBy (xpath = "(//table[@class='MuiTable-root _nzyk8q'])//tbody")
    public WebElement table;


    @FindBy (xpath = "//tbody/tr")
    public List<WebElement> totalNoOfCourse;

    
    @FindBy(xpath = "//div[@class='_c77kua']")
    public WebElement sortButton;

    @FindBy(xpath = "(//button[@title='Open'])[1]")
    public WebElement groupButton;
    
    
    @FindBy(xpath = "(//p[@class='_1yanunz'])[1]")
    public WebElement applyButton;
    
    

    @FindBy(xpath = "//p[@class='_cbdrkue']")
    public WebElement resetButton;
    
    
    @FindBy(xpath = "(//button[@title='Open'])[5]")
    public WebElement courseStatusButton;
    
    
    @FindBy(xpath = "(//button[@title='Open'])[7]")
    public WebElement recurrenceButton;
    
    @FindBy(xpath = " (//button[@type='button'])[1]")
    public WebElement downloadButton;
    
    @FindBy(xpath = "//div[@class='_103ycj2']")
    public WebElement settingButton;

    
    @FindBy(xpath = "//p[normalize-space()='Learner mode']")
    public WebElement LearnerMode;

    @FindBy(xpath = "//p[normalize-space()='Logout']")
    public WebElement Logout;
    
    
    
    
    
    //---------------------Action methods----------------


    public void clickLogoButton() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(sincxButton));
        wait.until(ExpectedConditions.elementToBeClickable(sincxButton));
        sincxButton.click();
    }



    public void clickCourseButton() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(140));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(courseButton));
        wait.until(ExpectedConditions.elementToBeClickable(courseButton));
        courseButton.click();
    }



    public void clickCourseName()  throws InterruptedException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(courseName));
        wait.until(ExpectedConditions.elementToBeClickable(courseName));
        courseName.click();
    }



    public void clickDashBoardButton()  throws InterruptedException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(dashBoardButton));
        wait.until(ExpectedConditions.elementToBeClickable(dashBoardButton));
        dashBoardButton.click();
    }



    public void clickTotalNoOfCourse()  throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOf(table));
        wait.until(ExpectedConditions.elementToBeClickable(table));
        table.click();
        List<WebElement> listElements = driver.findElements(By.xpath("//tbody/tr"));
        for (int i = 0; i < listElements.size(); i++) {
            int rowCount = listElements.size();
            System.out.println("Total number of rows: " + rowCount);
            }
        }



    
    
    
    

    public void clickSortButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(sortButton));
        wait.until(ExpectedConditions.elementToBeClickable(sortButton));
        sortButton.click();
    }



    public void clickGroupButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(groupButton));
        wait.until(ExpectedConditions.elementToBeClickable(groupButton));
        groupButton.click();
    }

    

    public void clickListOfCourse() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(groupButton));
        wait.until(ExpectedConditions.elementToBeClickable(groupButton));
//        groupButton.click();
        List<WebElement> listElements = driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
        for (int i = 0; i < listElements.size(); i++) {
            String courseName = listElements.get(i).getText();
            if (courseName.contains("QA_umatest")) {
                listElements.get(i).click();
                break;

            }
        }

    }
    
    
    
    public void clickApplyButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        applyButton.click();
    }

    

    public void clickResetButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(resetButton));
        wait.until(ExpectedConditions.elementToBeClickable(resetButton));
        resetButton.click();
    }

    public void clickCourseStatusButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(courseStatusButton));
        wait.until(ExpectedConditions.elementToBeClickable(courseStatusButton));
       courseStatusButton.click();
        List<WebElement> listElements = driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
        for (int i = 0; i < listElements.size(); i++) {
            String courseStatus = listElements.get(i).getText();
            if (courseStatus.contains("Live")) {
                listElements.get(i).click();
                break;

            }
        }

    }
    
    
    

    public void clickRecurrenceButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(recurrenceButton));
        wait.until(ExpectedConditions.elementToBeClickable(recurrenceButton));
        recurrenceButton.click();
        List<WebElement> listElements = driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
        for (int i = 0; i < listElements.size(); i++) {
            String recurrenceName = listElements.get(i).getText();
            if (recurrenceName.contains("HALFYEAR")) {
                listElements.get(i).click();
                break;

            }
        }

    }

    

    public void clickDownloadButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf( downloadButton));
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        downloadButton.click();
    }


    public void clickSettingButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(settingButton));
        wait.until(ExpectedConditions.elementToBeClickable(settingButton));
        settingButton.click();
    }

    
    public void clickLearnerMode() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(LearnerMode));
        wait.until(ExpectedConditions.elementToBeClickable(LearnerMode));
        LearnerMode.click();
    }



    public void clickLogout() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(Logout));
        wait.until(ExpectedConditions.elementToBeClickable(Logout));
        Logout.click();
    }

    //----------Validation----------------------



    public boolean validateCoursePage() throws TimeoutException{
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        String originalWindowHandle = driver.getWindowHandle();
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));

        boolean result = driver.getCurrentUrl().contains("courses");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);
        return result;
    }






    public boolean validateAdminPage() throws TimeoutException{
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String originalWindowHandle = driver.getWindowHandle();
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));

        boolean result = driver.getCurrentUrl().contains("orgs");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);

        return result;
    }


    public boolean validateLoginPage() throws TimeoutException{
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String originalWindowHandle = driver.getWindowHandle();
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));

        boolean result = driver.getCurrentUrl().contains("login");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);

        return result;
    }

        }









