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

public class SubSectionPage extends Basepage {
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;

	public SubSectionPage(WebDriver driver) {
		super(driver);

	}

	
	
	
	
	// ----------------PageObjects-------------------

	@FindBy(xpath = "  //p[normalize-space()='Sub-Sections']")
	public WebElement subSectionButton;

	@FindBy(xpath = "//button[@type='button']")
	public WebElement subSectionAddButton;

	@FindBy(xpath = "//p[normalize-space()='Save']")
	public WebElement subSectionSaveButton;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElement threeDotsSubSection;
	
    @FindBy(xpath ="//tr[@class='MuiTableRow-root']")
    public List<WebElement> rowElements;
    @FindBy (xpath = "//i[@class='material-icons-outlined'][text()='more_vert']")
    public List <WebElement> threeDots;
    
    @FindBy (xpath = "//input[@id='order']")
    public WebElement orderField;
   

	@FindBy(xpath = "//input[@id='title']")
	public WebElement subSectionTitle;

	@FindBy(xpath = "//textarea[@id='contentText']")
	public WebElement subSectionTextField;

	@FindBy(xpath = "//input[@id='order']")
	public WebElement subSectionOrderField;

	@FindBy(css = "button[class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator _1hhulki']")
	public WebElement subSectionTypeField;

	@FindBy(xpath = "//input[@id='contentYt']")
	public WebElement subSectionYTField;

	@FindBy(xpath = "  //input[@id='title']")
	public WebElement subSectionTileYTField;

	@FindBy(xpath = " //p[normalize-space()='Provide Youtube']")
	public WebElement subSectionYTAlertPopup;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElement KTThreeDots;

	@FindBy(xpath = "   //p[normalize-space()='Key Takeaways']")
	public WebElement KeyTakeawayButton;

	@FindBy(xpath = "//input[@id='title']")
	public WebElement KTTileField;

	@FindBy(xpath = " //input[@id='order']")
	public WebElement KeyOrderField;

	@FindBy(xpath = " //span[@class='_3jbd3m']")
	public WebElement longOrderAlert;

	@FindBy(xpath = " //a[@class='_gozzbg']")
	public WebElement editButton;

	@FindBy(xpath = "//p[normalize-space()='Knowledge Check']")
	public WebElement KCButton;

	@FindBy(xpath = "//span[@class='MuiButton-label']")
	public WebElement KCAddButton;

	  @FindBy(xpath = "  //textarea[@id='title']")
	    public WebElement KCTitleField;
	
	  @FindBy(xpath = " //input[@id='order']")
	    public WebElement KCOrderField;
	
	  @FindBy(xpath = "//button[@title='Open']")
	    public WebElement KCOueField;
	
	   @FindBy(xpath = "//p[normalize-space()='Save']")
	    public WebElement KCSaveButton;
	   @FindBy(xpath = "  //div[@id='menu-appbar']//div[1]//img[1]")
	    public WebElement EditButton;
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	// ---------------------Action methods----------------

	public void clickSubSectionButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionButton));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionButton));
		subSectionButton.click();
	}

	public void clickSubSectionAddButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionAddButton));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionAddButton));
		subSectionAddButton.click();
	}

	public void clickSubSectionSaveButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionSaveButton));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionSaveButton));
		subSectionSaveButton.click();
	}

	public void clickThreeDotSubSection() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Example")) {
                System.out.println("Course :" + courseName);
                threeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(120));
                subSectionButton.click();
	}
            
        }
        
	}

	public void clickSubSectionTitle(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionTitle));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionTitle));
		subSectionTitle.sendKeys(Keys.CONTROL + "a");
		subSectionTitle.sendKeys(Keys.DELETE);
		subSectionTitle.sendKeys(text);
	}

	public void clickSubSectionTextField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionTextField));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionTextField));
		subSectionTextField.sendKeys(Keys.CONTROL + "a");
		subSectionTextField.sendKeys(Keys.DELETE);
		subSectionTextField.sendKeys(text);
	}

	public void clickSubSectionOrderField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionOrderField));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionOrderField));
		subSectionOrderField.sendKeys(Keys.CONTROL + "a");
		subSectionOrderField.sendKeys(Keys.DELETE);
		subSectionOrderField.sendKeys(text);
	}

//    public void clickSubSectionTypeField() throws InterruptedException {
//
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        wait.until(ExpectedConditions.visibilityOf(subSectionTypeField));
//        wait.until(ExpectedConditions.elementToBeClickable(subSectionTypeField));
//        subSectionTypeField.click();
//        Thread.sleep(1000);
//        try {
//            Select dropdown = new Select(subSectionTypeField);
//            if (dropdown.getFirstSelectedOption().getText().equals("Textual")) { // Replace with the expected option text
//                System.out.println("Option is already selected.");
//            } else {
//                // Select an option by visible text
//                Thread.sleep(1000);
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Textual")));
//                wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//                dropdown.selectByVisibleText("Textual"); // Replace with the actual text of the option you want to select
//                System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
//            }
//            // dropdown.selectByVisibleText("Textual");
//
//        } catch (NoSuchElementException e) {
//            // Handle the case where the element was not found
//            System.out.println("Element not found: " + e.getMessage());
//        }
//    }

	public void clickSubSectionTextualTypeFields() throws InterruptedException {


			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(subSectionTypeField));
			wait.until(ExpectedConditions.elementToBeClickable(subSectionTypeField));
			subSectionTypeField.click();
			Thread.sleep(1000);
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

	public void clickSubSectionYTTypeField() throws InterruptedException {


	        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	        wait.until(ExpectedConditions.visibilityOf(subSectionTypeField));
	        subSectionTypeField.click();
	        Thread.sleep(1000);
	        List<WebElement> listElements= driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
	        for (int i=0; i<listElements.size(); i++)
	        {
	            String option = listElements.get(i).getText();

	            if (option.contains("Youtube Video")) {
	                listElements.get(i).click();
	                break;
	            }
	        }

	
		}
		
		

	public void clickSubSectionTileYTField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionTileYTField));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionTileYTField));
		subSectionTileYTField.sendKeys(text);

	}

	public void clickSubSectionYTField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionYTField));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionYTField));
		subSectionYTField.sendKeys(text);

	}

	public void clickSubSectionYouTubeField() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(subSectionYTField));
		wait.until(ExpectedConditions.elementToBeClickable(subSectionYTField));
		subSectionYTField.click();

	}
	
	

    public void clickTextOrderField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(100);
        wait.until(ExpectedConditions.visibilityOf(orderField));
        orderField.sendKeys(Keys.CONTROL + "a");
        orderField.sendKeys(Keys.DELETE);
        orderField.sendKeys(text);
    }


	public void clickKTThreeDots() throws InterruptedException {


        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Example")) {
                System.out.println("Course :" + courseName);
                threeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(120));
                wait.until(ExpectedConditions.visibilityOf(KeyTakeawayButton));
                KeyTakeawayButton.click();

            }

        }
	}

	
	public void clickEditKTThreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("What are the phrases of SDLC?")) {
                System.out.println("Course :" + courseName);
                threeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(120));
                wait.until(ExpectedConditions.visibilityOf(EditButton));
                EditButton.click();

            }

        }

    }
	
	
	
	
	
	
	
	
	public void clickKeyTakeawayButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KeyTakeawayButton));
		wait.until(ExpectedConditions.elementToBeClickable(KeyTakeawayButton));
		KeyTakeawayButton.click();

	}

	public void clickKTTileField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KTTileField));
		wait.until(ExpectedConditions.elementToBeClickable(KTTileField));
		Thread.sleep(1000);
		KTTileField.sendKeys(text);

	}
	
	
	

    public void clickSSectionThreeDots() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Test Automation")) {
                System.out.println("Course :" + courseName);
                threeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(120));
                subSectionButton.click();
                break;
            }
        }
    }

    

    public void clickSSThreeDotsToEdit() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Example")) {
                System.out.println("Course :" + courseName);
                threeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(120));
                EditButton.click();
                break;
            }
        }
    }

	public void clickKOrderField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KeyOrderField));
		wait.until(ExpectedConditions.elementToBeClickable(KeyOrderField));
		KeyOrderField.sendKeys(Keys.CONTROL + "a");
		KeyOrderField.sendKeys(Keys.DELETE);
		KeyOrderField.sendKeys(text);
	}

	public void clickKTLongOrderField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KeyOrderField));
		wait.until(ExpectedConditions.elementToBeClickable(KeyOrderField));
		KeyOrderField.sendKeys(Keys.CONTROL + "a");
		KeyOrderField.sendKeys(Keys.DELETE);
		KeyOrderField.sendKeys(text);
	}

	public void clickEditButton() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(editButton));
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		editButton.click();
	}

	public void clickKeyTTileField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KTTileField));
		wait.until(ExpectedConditions.elementToBeClickable(KTTileField));
		KTTileField.sendKeys(Keys.CONTROL + "a");
		KTTileField.sendKeys(Keys.DELETE);
		KTTileField.sendKeys(text);
	}

	public void clickKeyOrderField(String text) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KeyOrderField));
		wait.until(ExpectedConditions.elementToBeClickable(KeyOrderField));
		KeyOrderField.sendKeys(Keys.CONTROL + "a");
		KeyOrderField.sendKeys(Keys.DELETE);
		KeyOrderField.sendKeys(text);
	}

	public void clickKCButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KCButton));
		wait.until(ExpectedConditions.elementToBeClickable(KCButton));
		KCButton.click();

	}

	public void clickKCAddButton() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(KCAddButton));
		wait.until(ExpectedConditions.elementToBeClickable(KCAddButton));
		KCAddButton.click();

	}

    public void clickSubSectionTextualTypeField() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(subSectionYTField));
        subSectionYTField.click();

        Thread.sleep(1000);
        List<WebElement> listElements= driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
        for(int i=0; i<listElements.size(); i++)
        {
            String option = listElements.get(i).getText();
            if (option.contains("Textual")) {
                listElements.get(i).click();
                break;
            }
        }

    }


    public void clickSubSectionYTTypeFieldss() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(subSectionYTField));
        subSectionYTField.click();

        Thread.sleep(1000);
        List<WebElement> listElements= driver.findElements(By.xpath("//li[@class='MuiAutocomplete-option']"));
        for (int i=0; i<listElements.size(); i++)
        {
            String option = listElements.get(i).getText();
            if (option.contains("Youtube")) {
                listElements.get(i).click();
                break;
            }
        }
    }

    public void clickKCTitleField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(KCTitleField));
        wait.until(ExpectedConditions.elementToBeClickable(KCTitleField));
        KCTitleField.sendKeys(Keys.CONTROL + "a");
        KCTitleField.sendKeys(Keys.DELETE);
        KCTitleField.sendKeys(text);
    }


    public void clickKCOrderField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(KCOrderField));
        wait.until(ExpectedConditions.elementToBeClickable(KCOrderField));
        KCOrderField.sendKeys(Keys.CONTROL + "a");
        KCOrderField.sendKeys(Keys.DELETE);
        KCOrderField.sendKeys(text);
    }

    public void clickKCOueField() throws InterruptedException {

            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(KCOueField));
            wait.until(ExpectedConditions.elementToBeClickable(KCOueField));
            KCOueField.click();
            Thread.sleep(1000);
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

    public void clickKCThreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Example")) {
                System.out.println("Course :" + courseName);
                threeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(120));
                wait.until(ExpectedConditions.visibilityOf(KCButton));
                KCButton.click();

            }

        }

    }


	

    public void clickKCSaveButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(   KCSaveButton));
        wait.until(ExpectedConditions.elementToBeClickable(   KCSaveButton));
        KCSaveButton.click();

    }
	
	

    public void clickEditKCThreeDots() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains("Benefits of Manual Testing?")) {
                System.out.println("Course :" + courseName);
                threeDots.get(i).click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(120));
                wait.until(ExpectedConditions.visibilityOf(editButton));
                editButton.click();

            }

        }

    }

	
	
	
	
	
	
	
	

//---------------Validation-----------------

	// Capture new Window (Privacy Policy)
	public boolean validateChaptersPage() throws TimeoutException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean result = driver.getCurrentUrl().contains("chapters");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("\t");
		System.out.println("CurrentUrl: " + currentUrl);
		return result;
	}

	public boolean validateAlertPopup() throws TimeoutException, InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(1000);
		wait.until((ExpectedConditions.visibilityOf(subSectionYTAlertPopup)));
		return subSectionYTAlertPopup.isDisplayed();
	}

	public boolean validateKnowledgeCheckPage() throws TimeoutException, InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(1000);
		boolean result = driver.getCurrentUrl().contains("knowledgechecks");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("\t");
		System.out.println("CurrentUrl: " + currentUrl);
		return result;
	}

	public boolean validateTooLongOrderAlert() throws TimeoutException, InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		Thread.sleep(1000);
		wait.until((ExpectedConditions.visibilityOf(longOrderAlert)));
		return longOrderAlert.isDisplayed();
	}
	
	  public boolean validateQuizPage() throws TimeoutException, InterruptedException {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	        Thread.sleep(1000);
	        boolean result = driver.getCurrentUrl().contains("quiz");
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("\t");
	        System.out.println("CurrentUrl: " + currentUrl);
	        return result;
	    }
	
	
	    public boolean validateSSectionPage() throws TimeoutException, InterruptedException {
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	        Thread.sleep(1000);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        boolean result = driver.getCurrentUrl().contains("chapters");
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("\t");
	        System.out.println("CurrentUrl: " + currentUrl);
	        //  System.out.println("Privacy Policy displayed: " + privacypolicy.isDisplayed());

	        return result;
	    }

	
	
	
	
	

}
