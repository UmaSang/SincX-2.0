package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentPage extends Basepage {
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;

    public AssessmentPage(WebDriver driver) {
        super(driver);

    }

    //----------------PageObjects-------------------


   @FindBy (xpath="//p[@class='_1qr5fe8'][normalize-space()='Assessment']")
    public WebElement  AssessmentTab;

    @FindBy (xpath=" //p[@class='_gkprm7']")
    public WebElement  AddButton;
 

    @FindBy(xpath ="//tr[@class='MuiTableRow-root']")
   public List <WebElement> rowElements;
    @FindBy (xpath = "//i[@class='material-icons-outlined'][text()='more_vert']")
    public List <WebElement> ThreeDots;

    
    
    
    
    @FindBy (xpath=" //textarea[@id='title']")
    public WebElement  quesField;

    @FindBy (xpath=" //input[@id='order']")
    public WebElement  orderField;

   @FindBy (xpath=" //button[@title='Open']//span[@class='MuiTouchRipple-root']")
   public WebElement  quesTypeField;

    @FindBy (xpath="//p[normalize-space()='Save']")
    public WebElement  saveButton;


    @FindBy (xpath="(//button[@type='button'])[4]")
    public WebElement  threeDots;

    @FindBy (xpath="//p[normalize-space()='Options']")
    public WebElement  optionButton;


    @FindBy (xpath="//p[@class='_1493vjz2']")
    public WebElement  addButton;

    @FindBy (xpath="//textarea[@id='title']")
    public WebElement  optionField;

    @FindBy (xpath="//input[@id='order']")
    public WebElement orderfield;

    @FindBy (xpath="//input[@id='mui-autocomplete-64740']")
    public WebElement ansField;

   @FindBy (xpath="//p[normalize-space()='Save']")
   public WebElement savButton;


    @FindBy (xpath="(//div[@class='_1h8njdls'])[2]")
    public WebElement dialogWindow;



    @FindBy (xpath="//tbody/tr[4]/td[3]/div[1]/div[1]/button[1]/span[1]/i[1]")
    public WebElement assessThreeDots;




    @FindBy (xpath="(//p[@class='_2kamhyo'])[1]")
    public WebElement deleteButton;



    @FindBy (xpath="//input[@id='delete']")
    public WebElement deleteField;




    @FindBy (xpath="(//span[@class='MuiButton-label'])[2]")
    public WebElement redDeleteButton;




    @FindBy (xpath="//p[normalize-space()='Edit']")
    public WebElement EditButton;


    @FindBy (xpath="(//span[@class='MuiButton-label'])[2]")
    public WebElement  KCSaveButton;


    //---------------------Action methods----------------


    public void clickAssessmentTab() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(AssessmentTab));
        wait.until(ExpectedConditions.elementToBeClickable(AssessmentTab));
        Thread.sleep(1000);
        AssessmentTab.click();
    }



    public void clickAddButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(AddButton));
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        Thread.sleep(1000);
        AddButton.click();
    }





    public void clickQuesField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(quesField));
        wait.until(ExpectedConditions.elementToBeClickable(quesField));
        quesField.click();
        quesField.sendKeys(text);
    }



    public void clickEditQuesField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(quesField));
        wait.until(ExpectedConditions.elementToBeClickable(quesField));
        quesField.sendKeys(Keys.CONTROL + "a");
        quesField.sendKeys(Keys.DELETE);
        quesField.click();
        quesField.sendKeys(text);
    }




    public void clickOrderField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(orderField));
        wait.until(ExpectedConditions.elementToBeClickable(orderField));
        orderField.sendKeys(text);
    }






    public void clickQuesTypeField() throws InterruptedException {

     
            wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(quesTypeField));
            wait.until(ExpectedConditions.elementToBeClickable(quesTypeField));
            quesTypeField.click();
            List<WebElement> options= driver.findElements(By.xpath(
                    "//ul[@class='MuiAutocomplete-listbox']//li"));
            for (int i = 0; i < options.size(); i++) {
                String optionName = options.get(i).getText();
                if (optionName.contains("Options-Multiple Answers")) {
                    options.get(i).click();
                    break;

                }
            }
    }


  //ul[@class='MuiAutocomplete-listbox']//li
    
    
    

    public void clickSaveButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        Thread.sleep(1000);
        saveButton.click();
    }
    public void clickThreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(threeDots));
        wait.until(ExpectedConditions.elementToBeClickable(threeDots));
        Thread.sleep(1000);
        threeDots.click();
    }




    public void clickOptionButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(optionButton));
        wait.until(ExpectedConditions.elementToBeClickable(optionButton));
        Thread.sleep(1000);
        optionButton.click();
    }



    public void clickddButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(addButton));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        Thread.sleep(1000);
        addButton.click();
    }


    public void clickOptionField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(   optionField));
        wait.until(ExpectedConditions.elementToBeClickable(   optionField));
        Thread.sleep(1000);
        optionField.click();
        optionField.sendKeys(text);
    }


    public void clickorderfield(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(orderfield));
        wait.until(ExpectedConditions.elementToBeClickable(orderfield));
        Thread.sleep(1000);
        orderfield.click();
        orderfield.sendKeys(text);
    }





    public void clickAnsField() throws InterruptedException {
    	
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
         Thread.sleep(1000);
         wait.until(ExpectedConditions.visibilityOf(ansField));
         wait.until(ExpectedConditions.elementToBeClickable(ansField));
         ansField.click();
         List<WebElement> listElements = driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
         for (int i = 0; i < listElements.size(); i++) {
             String courseName = listElements.get(i).getText();
             if (courseName.contains("Options - Multiple Answers")) {
                 listElements.get(i).click();
                 break;
             }
         }

     }










    public void clicksavButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(  savButton));
        wait.until(ExpectedConditions.elementToBeClickable(savButton));
        Thread.sleep(1000);
        savButton.click();
    }




    public void clickAssessThreeDots() throws InterruptedException {
    	 wait = new WebDriverWait(driver,Duration.ofSeconds(120));
         Thread.sleep(1000);
         for (int i=0;i< rowElements.size();i++)
         {
             String courseName = rowElements.get(i).getText();
             // Check if the course name contains the expected course name
             if (courseName.contains("Example")) {
                 System.out.println("Course :"+courseName);
                 ThreeDots.get(i).click();
                 wait = new WebDriverWait(driver,Duration.ofSeconds(120));
                 wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
                 deleteButton.click();
                 break;
             }
         }

     }


    public void clickAssessEditThreeDots() throws InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i=0;i< rowElements.size();i++)
        {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Example")) {
                System.out.println("Course :"+courseName);
                ThreeDots.get(i).click();
                wait = new WebDriverWait(driver,Duration.ofSeconds(120));
                wait.until(ExpectedConditions.elementToBeClickable(EditButton));
                EditButton.click();
                break;
            }
        }

    }

    
    
    
    
    
    
    
    
    
    

    public void clickDeleteButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }



    public void clickDeleteField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(deleteField));
        wait.until(ExpectedConditions.elementToBeClickable(deleteField));
        Thread.sleep(1000);
        deleteField.sendKeys(text);
    }



    public void clickRedDeleteButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(redDeleteButton));
        wait.until(ExpectedConditions.elementToBeClickable(redDeleteButton));
        redDeleteButton.click();
    }

    public void clickEditButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(EditButton));
        wait.until(ExpectedConditions.elementToBeClickable(EditButton));
        EditButton.click();
    }







    // --------------Validation------------------------


    public boolean validateAssessmentPage() throws TimeoutException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean result = driver.getCurrentUrl().contains("assessment");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("\t");
        System.out.println("CurrentUrl: " + currentUrl);
        return result;
    }



    public boolean validateDialogWindow() throws TimeoutException
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOf(dialogWindow)));
        return dialogWindow.isDisplayed();
    }




    public void clickKCSaveButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(KCSaveButton));
        wait.until(ExpectedConditions.elementToBeClickable(KCSaveButton));
        KCSaveButton.click();
    }









}
