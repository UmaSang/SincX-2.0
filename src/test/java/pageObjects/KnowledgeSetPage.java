package pageObjects;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KnowledgeSetPage  extends Basepage {

    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;


    public KnowledgeSetPage(WebDriver driver) {
        super(driver);

    }





    //----------------PageObjects-------------------
    @FindBy(xpath ="(//tr[@class='MuiTableRow-root'])")
    public List<WebElement> rowElements;


    @FindBy(xpath ="(//td[@class='MuiTableCell-root MuiTableCell-body _1fqux7yl'])")
    public List<WebElement> ThreeDots;


    @FindBy(xpath = "//p[@class='_2kamhyo']")
    public WebElement deleteOption;

    @FindBy (xpath ="//div[@class='MuiInputBase-root MuiInput-root _1v6gz0b MuiInputBase-fullWidth MuiInput-fullWidth MuiInputBase-formControl MuiInput-formControl']//input[@id='delete']")
    public WebElement deleteField;

    @FindBy (xpath="(//p[@class='_gkprm7'][normalize-space()='Delete'])")
    public WebElement redDeleteButton;



    @FindBy(xpath = "//div[@class='MuiButtonBase-root MuiListItem-root _fa6vzb5 MuiListItem-gutters MuiListItem-button']//p[text()='Knowledge Sets']")
    public WebElement knowledgeSet;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text _1uf280aj']")
    public WebElement addButton;
    

    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleTab;

    @FindBy(xpath = "(//span[@class='_11rh7af'])[1]")
    public WebElement browseButton;

    @FindBy(xpath = "//button[@title='Open'][1]")
    public WebElement statusTab;
    
    @FindBy(xpath = "//p[normalize-space()='Save']")
    public WebElement saveButton;
    

    @FindBy(xpath = "//textarea[@id='descr']")
    public WebElement descriptionField;

    
    @FindBy(xpath = "//p[normalize-space()='Provide title']")
    public WebElement alertTitle;

    //---------------------Action methods----------------
    public void clickThreeDotKS() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(2000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            if (courseName.contains("Software Testing")) {
                System.out.println("Course :" + courseName);
                ThreeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(140));
                wait.until(ExpectedConditions.visibilityOf(deleteOption));
                wait.until(ExpectedConditions.elementToBeClickable(deleteOption));
                deleteOption.click();
            }
        }

    }


    public void textDeleteField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(deleteField));
        wait.until(ExpectedConditions.elementToBeClickable(deleteField));
        deleteField.sendKeys(text);
    }

    public void clickRedDeleteButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(redDeleteButton));
        wait.until(ExpectedConditions.elementToBeClickable(redDeleteButton));
        redDeleteButton.click();
    }



    public void clickKnowledgeSet() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(knowledgeSet));
        wait.until(ExpectedConditions.elementToBeClickable(knowledgeSet));
        knowledgeSet.click();
    }

    public void clickAddButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf( addButton));
        wait.until(ExpectedConditions.elementToBeClickable( addButton));
        addButton.click();
    }


    public void clickTileOne(String text) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(titleTab));
        wait.until(ExpectedConditions.elementToBeClickable( titleTab));
        titleTab.sendKeys(text);
    }


    public void clickStatusList() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(statusTab));
        wait.until(ExpectedConditions.elementToBeClickable(statusTab));
        statusTab.click();
        List<WebElement> listElements = driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
        for (int i = 0; i < listElements.size(); i++) {
            String courseName = listElements.get(i).getText();
            if (courseName.contains("LIVE")) {
                listElements.get(i).click();
                break;

            }
        }

    }
    
    
    
    public void clickSaveButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    

    public void clickTileTwo(String text) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(titleTab));
        wait.until(ExpectedConditions.elementToBeClickable( titleTab));
        titleTab.sendKeys(text);
    }
    


    public void clickBrowseButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(browseButton));
        wait.until(ExpectedConditions.elementToBeClickable(browseButton));
        browseButton.click();
        Thread.sleep(2000);
        String filePath = "C:\\Users\\Uma\\Documents\\a1.png"; // Update with your image path
        StringSelection ss=new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        Robot robot= null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        //deleteButton.click();

    }


    public void clickDescriptionField(String text) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        wait.until(ExpectedConditions.elementToBeClickable(descriptionField));
        descriptionField.sendKeys(text);
    }

    
    

    @SuppressWarnings("deprecation")
	public void clickUploadButton() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(browseButton));
        wait.until(ExpectedConditions.elementToBeClickable(browseButton));
        browseButton.click();
        Thread.sleep(2000);
        String imagePath = "C:\\Users\\Uma\\Documents\\a2.png"; // Update with your image path
        String autoITPath="C:\\Users\\Uma\\Documents\\FileUpload.exe";
         try {
             Runtime.getRuntime().exec(autoITPath+  " " +imagePath);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
        Thread.sleep(2000);
    }


    
    
    
 //   ---------------------Validation---------------------
    
    public boolean validateKnowledgeSetPage() throws TimeoutException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        String actualUrl=driver.getCurrentUrl();
        return (actualUrl.contains("cats"));
    }

    public boolean validateTitleAlert() throws TimeoutException {
        wait = new WebDriverWait (driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(alertTitle));
        return alertTitle.isDisplayed();
    }

}