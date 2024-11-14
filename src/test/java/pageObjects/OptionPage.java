package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OptionPage  extends Basepage {
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;

    public OptionPage(WebDriver driver) {
        super(driver);

    }

    //----------------PageObjects-------------------


    @FindBy (xpath="(//i[contains(text(),'more_vert')])[2]")
    public WebElement KCThreeDots;



    @FindBy (xpath= "//p[normalize-space()='Knowledge Check']")
    public WebElement KCButton;

    @FindBy(xpath ="//tr[@class='MuiTableRow-root']")
    List <WebElement> rowElements;


    @FindBy (xpath="//p[normalize-space()='Options']")
    public WebElement optionButton;


    @FindBy (xpath="//p[@class='_1493vjz2']")
    public WebElement optionAddButton;


    @FindBy (xpath=" //textarea[@id='title']")
    public WebElement optionTitleField;


    @FindBy (xpath=" //input[@id='order']")
    public WebElement optionOrderField;


    @FindBy (xpath="//button[@title='Open']")
    public WebElement optionAnswerField;

    @FindBy (xpath=" //p[normalize-space()='Save']")
    public WebElement optionSaveButton;


   @FindBy (xpath="//tbody/tr[4]/td[3]/div[1]/div[1]/button[1]/span[1]/i[1]")
   public WebElement threeDots;



    @FindBy (xpath="//p[@class='MuiFormHelperText-root Mui-error Mui-required']")
    public WebElement selectAnsAlert;



    @FindBy(xpath ="//tr[@class='MuiTableRow-root']")
    public List <WebElement> rowElemets;
    @FindBy (xpath = "//i[@class='material-icons-outlined'][text()='more_vert']")
    public List <WebElement> threeDts;


    @FindBy (xpath="//p[normalize-space()='Edit']")
    public WebElement EditButton;

    
    
    
    

    //---------------------Action methods----------------

    public void clickOptionThreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(KCThreeDots));
        wait.until(ExpectedConditions.elementToBeClickable(KCThreeDots));
        Thread.sleep(1000);
        KCThreeDots.click();
    }



    public void clickKCButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(KCButton));
        wait.until(ExpectedConditions.elementToBeClickable(KCButton));
        KCButton.click();
    }





    public void clickOptionButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(optionButton));
        wait.until(ExpectedConditions.elementToBeClickable(optionButton));
        optionButton.click();
    }


    public void clickOptionAddButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(optionAddButton));
        wait.until(ExpectedConditions.elementToBeClickable(optionAddButton));
        optionAddButton.click();
    }


    public void clickOptionTitleField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(optionTitleField));
        wait.until(ExpectedConditions.elementToBeClickable(optionTitleField));
        optionTitleField.sendKeys(text);
    }

    public void clickOptionOrderField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(optionOrderField));
        wait.until(ExpectedConditions.elementToBeClickable(optionOrderField));
        optionOrderField.sendKeys(  text);
    }


    public void clickOptionAnswerField() throws InterruptedException {

     
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(optionAnswerField));
        wait.until(ExpectedConditions.elementToBeClickable(optionAnswerField));
        optionAnswerField.click();
        Thread.sleep(1000);
        List<WebElement> options= driver.findElements(By.xpath(
                "//ul[@class='MuiAutocomplete-listbox']//li"));
        for (int i = 0; i < options.size(); i++) {
            String optionName = options.get(i).getText();
            if (optionName.contains("Yes")) {
                options.get(i).click();
                break;

            }
        }
}

    
    
    
    
    
    
    
    
    public void clickEditOptionThreeDots() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i=0;i< rowElements.size();i++)
        {
            String courseName = rowElements.get(i).getText();
            // Check if the course name matches the expected course name
            if (courseName.contains("what are the phrases of STLC")) {
                System.out.println("Course :"+courseName);
                threeDts.get(i).click();
                wait.until(ExpectedConditions.elementToBeClickable(EditButton));
                wait.until(ExpectedConditions.visibilityOf(EditButton));
                EditButton.click();
                break;
            }
        }
    }
    public void clickOptionSaveButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(optionSaveButton));
        wait.until(ExpectedConditions.elementToBeClickable(optionSaveButton));
        optionSaveButton.click();
    }



    public void clickthreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(threeDots));
        wait.until(ExpectedConditions.elementToBeClickable(threeDots));
        threeDots.click();
    }

    // --------------Validation------------------------

    public boolean validateSelectAnsAlert() throws TimeoutException
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOf(selectAnsAlert)));
        return selectAnsAlert.isDisplayed();
    }

    public boolean validateAssessmentPage() throws TimeoutException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean result = driver.getCurrentUrl().contains("assessment");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);
        return result;
    }


    public boolean validateQuizPage() throws TimeoutException
    {wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean result = driver.getCurrentUrl().contains("quiz");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);
        return result;
    }


}
