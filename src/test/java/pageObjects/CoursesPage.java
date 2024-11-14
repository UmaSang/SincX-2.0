package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import testBase.Baseclass;

import java.io.IOException;


import javax.sound.sampled.Control;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class CoursesPage extends Basepage {
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;


    // Constructor

    public CoursesPage(WebDriver driver) {
        super(driver);

    }


    //----------------PageObjects-------------------

    // SincX button
    @FindBy(xpath="//a[contains(@href, 'admin/orgs')]")
    public WebElement sincxButton;
    //Course Button
    @FindBy (xpath = "//img[contains(@src, 'course')]")
    public WebElement courseButton;
    @FindBy(xpath = "//h1[contains(text(), 'Course')]")
    public  WebElement coursePageTitle;
    // Add new Course button
    @FindBy(xpath = "//p[text()='Add']")
    public WebElement addCourseButton;
    // Text field to add course
    @FindBy(xpath = "//input[@id='title']")
    public WebElement addCourseText;
    //Save course button
    @FindBy(xpath="//p[text()='Save']")
    public WebElement saveCourseButton;
    //Course Table details
    @FindBy(xpath="//table[contains(@class ,'MuiTable-root')]")
    public WebElement courseTableElement;
    @FindBy(xpath ="//tr[@class='MuiTableRow-root']")
    List <WebElement> rowElements;
    @FindBy (xpath = "//i[@class='material-icons-outlined'][text()='more_vert']")
    List <WebElement> threeDots;
    //Elements inside : in the course table
    @FindBy(xpath="//p[@class='_d17jlg']")
    public WebElement editCourseButton;
    @FindBy(xpath ="//p[@class='_2kamhyo']" )
    public WebElement deleteCourseButton;
    //Elements in the Add Course dialog
    @FindBy(xpath="//p[text()='Title']")
    public WebElement titleElement;
    @FindBy(xpath="//input[@id='title']")
    public WebElement courseTextField;
    @FindBy(xpath = "//p[text()='Save']")
    public WebElement saveButton;
    @FindBy(xpath="//p[@class='MuiFormHelperText-root Mui-error Mui-required']")
    public WebElement errorMessageText;
    //Elements in the Delete Course Dialog
    @FindBy(xpath = "//p[text()='Are you sure you want to delete?']")
    public WebElement deleteTitleElement;
    @FindBy(xpath = "//input[@id='delete']")
    public WebElement deleteTextField;
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text _brgg17g']")
    public WebElement deleteButton;
    //Elements in the course Details Tab
    @FindBy(xpath="//h1[@class='_1tfolp8']")
    public  WebElement detailsTabTitle;
    @FindBy(xpath="//h2[text()='Main']")
    public WebElement mainFrameTitle;
    @FindBy(xpath="//h2[text()='Settings']")
    public WebElement settingsFrameTitle;
    @FindBy(xpath="//h2[text()='Certification']")
    public WebElement certificationFrameTitle;
    @FindBy(xpath="//h2[text()='Assessment']")
    public WebElement assessmentFrameTitle;
    @FindBy(xpath="//h2[text()='Recurrence']")
    public WebElement recurrenceFrameTitle;
    @FindBy(xpath="//h2[text()='Consents']")
    public WebElement consentsFrameTitle;
    @FindBy(xpath="//h2[text()='Feedback configuration']")
    public WebElement feedbackFrameTitle;
    //Elements inside Main frame
    @FindBy(xpath = "//div[@class='_3chu6s']")
    public WebElement editTitle;
    @FindBy(xpath = "(//div[@class='_w54tgl']//p[text()= 'Edit'])[1]")
    public WebElement mainEditButton;
    @FindBy(xpath="//input[@id='duration']")
    public WebElement durationTextElement;
    @FindBy(xpath="//i[text()='file_upload']")
    public WebElement browseElement;
    @FindBy(xpath = "//textarea[@id='descr']")
    public WebElement descriptionTextElement;
    //Elements inside Settings Frame
    @FindBy(xpath = "(//div[@class='_w54tgl']//p[text()= 'Edit'])[2]")
    public WebElement settingsEditButton;
    @FindBy(xpath = "(//button[@title='Open'])[1]")
    public WebElement statusDropDown;

    //Capture resources tab
    @FindBy(xpath = "//a[contains(@href,'resources')]") public WebElement resourcesTab;
    //Capture FAQ tab
    @FindBy(xpath = "//a[contains(@href,'faqs')]") public WebElement faqTab;
    //Capture Users tab
    @FindBy (xpath = "//a[contains(@href,'people')]") public   WebElement usersTab;
    //Capture Preview tab
    @FindBy (xpath = "//a[contains(@href,'preview')]") public WebElement previewTab;
    //Capture settings icon
    @FindBy (xpath = "//i[text()='settings']") public WebElement settingsIcon;
    //Capture Logout option in the Settings
    @FindBy (xpath = "//li//p[contains(text(),'Logout')]") public WebElement logoutSettings;
    //Capture Library
    @FindBy (xpath = "//p[contains(text(),'Library')]//ancestor::button") public WebElement library;

    //---------------------Action methods----------------
    //Click SincXButton
    public void clickSincxButton() throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(sincxButton));
        sincxButton.click();

    }
    // Click Courses Tab
    public void clickCoursesButton() throws TimeoutException
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(courseButton));
        courseButton.click();
      //  validateCoursePageDetails();
    }

    // Click Add Courses
    public void clickAddCourse(String courseTitle) throws TimeoutException, InterruptedException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(180));
        wait.until(ExpectedConditions.elementToBeClickable(addCourseButton));
        addCourseButton.click();

        wait.until(ExpectedConditions.visibilityOf(titleElement));
        courseTextField.sendKeys(courseTitle);
        saveButton.click();

        if(courseTitle.isEmpty())
        {
            String errorMessage=errorMessageText.getText();
            Assert.assertEquals(errorMessage,"Provide title","Expected error message is Provide title");
        }else {
            Thread.sleep(2000);
            String courseStatus=validateCourseStatus(courseTitle);
            Assert.assertEquals(courseStatus, "DRAFT", "Expected course status is DRAFT");
        }

    }

    // Click Edit Courses
    public void clickEditCourse(String expectedCourse) throws TimeoutException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(coursePageTitle));
            // Iterate through each row
        for (int i=0;i< rowElements.size();i++)
        {
            String courseName = rowElements.get(i).getText();
            // Check if the course name matches the expected course name
            if (courseName.contains(expectedCourse)) {
                System.out.println("Course :"+courseName);
                threeDots.get(i).click();
                wait.until(ExpectedConditions.elementToBeClickable(editCourseButton));
                editCourseButton.click();
                break;
                }
            }
    }
    // Click Delete Courses
    public void clickDeleteCourse(String expectedCourse) throws TimeoutException, InterruptedException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(coursePageTitle));

        for (int i=0;i< rowElements.size();i++)
        {
            String courseName = rowElements.get(i).getText();
            // Check if the course name contains the expected course name
            if (courseName.contains(expectedCourse)) {
                System.out.println("Course :"+courseName);
                threeDots.get(i).click();
                wait.until(ExpectedConditions.elementToBeClickable(deleteCourseButton));
                deleteCourseButton.click();

                wait.until(ExpectedConditions.visibilityOf(deleteTitleElement));
                Assert.assertEquals(deleteTitleElement.getText(),"Are you sure you want to delete?","Expected Message is Are you sure you want to delete? ");
                deleteTextField.sendKeys("delete");
                deleteButton.click();
                break;
                }
            }

        Thread.sleep(2000);
        boolean courseExists = false;
        List <WebElement> updatedRowElement=driver.findElements(By.tagName("tr"));
        for (int i=0;i< updatedRowElement.size();i++)
        {
            String courseName = updatedRowElement.get(i).getText();
            // Check if the course name matches the expected course name
            if (courseName.contains(expectedCourse)) {
                courseExists = true;
                break;
                }
            }
        if (courseExists) {
            System.out.println(expectedCourse + " still exist");
        } else {
            System.out.println(expectedCourse + " is successfully deleted");
        }

    }
    //Click Edit Main Details
    public void clickEditMainDetails() throws TimeoutException, InterruptedException, IOException {
        wait=new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(detailsTabTitle));
        //Click on Edit button
        mainEditButton.click();
        wait.until(ExpectedConditions.visibilityOf(courseTextField));
        //Enter details on each field
        courseTextField.sendKeys(Keys.CONTROL + "a");
        courseTextField.sendKeys("Introduction to Automation");

        //Image field
        String filePath = "C:\\Users\\anupk\\OneDrive\\Desktop\\Co-Op\\Sprint3\\maple.png";
        String autoITPath="C:\\Users\\anupk\\OneDrive\\Desktop\\Co-Op\\Sprint3\\upload.exe";
        browseElement.click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec(autoITPath + " " + filePath );
        Thread.sleep(3000);

        //Duration field
        durationTextElement.sendKeys("10");
        descriptionTextElement.sendKeys("Master the fundamentals of web automation using Selenium and Java");
        Thread.sleep(2000);
        saveButton.click();

    }
    //Click Edit Settings Details
    public void clickEditSettingsDetails() throws TimeoutException
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(detailsTabTitle));

        settingsEditButton.click();
        wait.until(ExpectedConditions.visibilityOf(statusDropDown));
        statusDropDown.click();
        WebElement statusValueElement=driver.findElement(By.xpath(""));
        String statusValue=statusValueElement.getText();
    }

    //Click Resources tab
    public void clickResourcesTab() throws TimeoutException {
        wait = new WebDriverWait (driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(resourcesTab));
        resourcesTab.click();
    }

    //Click FAQ tab
    public void clickFAQTab() throws TimeoutException {
        wait = new WebDriverWait (driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(faqTab));
        faqTab.click();
    }
    //Click Users tab
    public void clickUsersTab() throws TimeoutException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(usersTab));
        usersTab.click();
    }
    //Click Preview Tab
    public void clickPreviewTab() throws TimeoutException{
        wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(previewTab));
        previewTab.click();
    }
    //Click setting icon
    public void clickSettingIcon() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(settingsIcon));
        settingsIcon.click();
    }
    //Click Logout option under the Settings
    public void clickLogoutWithinSettingsIcon() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(logoutSettings));
        logoutSettings.click();
    }

    //Click Libray
    public void clickLibray(){
        wait = new WebDriverWait (driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(library));
        library.click();
    }

    //----------------Validation---------------------
    //Validate Course Page
    public boolean validateCoursePage() throws TimeoutException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(coursePageTitle));
        return coursePageTitle.isDisplayed();
    }
    // validate course page details
    public void validateCoursePageDetails() throws TimeoutException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement tableHeader =driver.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head']"));// Locate the table header
      //  Locate all header cell
        List <WebElement> columnElement = tableHeader.findElements(By.tagName("th"));
        //Expected header values
        String[] expectedHeaders = {"Index", "Info", "Status",""};
        for(int i=0;i<columnElement.size();i++)
        {
            String actualHeader  = columnElement.get(i).getText();
            if (actualHeader.equals(expectedHeaders[i])) {
                System.out.println("Header validated: " + actualHeader);
            } else {
                System.out.println("Header mismatch Expected: " + expectedHeaders[i] + ", but got: " + actualHeader);
            }

        }
    }

    //Validate course status
    public String validateCourseStatus(String expectedCourse) throws TimeoutException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(coursePageTitle));

        List<WebElement> rowElement = courseTableElement.findElements(By.tagName("tr"));
        String courseStatus = null;

        // Iterate through each row in the course table
        for (WebElement courseRow : rowElement) {
            // Find all columns in the current row
            List<WebElement> columnElement = courseRow.findElements(By.tagName("td"));
            // Check if the row has more than 3 columns
            if (columnElement.size() > 3) {
                // Get the course name from the second column
                String cellValue = columnElement.get(1).getText();
                String courseName = cellValue.split("\n")[0].trim();
                // Check if the course name matches the expected course name
                if (courseName.equals(expectedCourse)) {
                    // Locate status in the third column
                    WebElement statusElement = columnElement.get(2).findElement(By.xpath("//p[@class='_zubb3xw']"));
                    courseStatus = statusElement.getText();

                    switch (courseStatus) {
                        case "DRAFT":
                            System.out.println("Status of " + courseName + ": " + courseStatus);
                            break;
                        case "DISABLED":
                            System.out.println("Status of " + courseName + ": " + courseStatus);
                            break;
                        case "LIVE":
                            System.out.println("Status of " + courseName + ": " + courseStatus);
                            break;
                        default:
                            System.out.println("Unexpected status for " + courseName + ": " + courseStatus);
                    }
                    //return courseStatus;
                }

            }
        }
        return courseStatus;
    }

    //Validate Edit Button loads Details tab
    public boolean validateDetailsTab() throws TimeoutException
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(detailsTabTitle));
        String actualUrl=driver.getCurrentUrl();
        return (actualUrl.contains("details"));
    }

    //Validate frames on Details Tab
    public void framesOnDetailsTab() throws TimeoutException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(detailsTabTitle));
        String[] expectedFrames = {"Main", "Settings", "Certification", "Assessment", "Recurrence",
                "Consents", "Feedback Configuration"};

        List<WebElement> framesDetailsTab = driver.findElements(By.tagName("h2"));
        for (int i = 0; i < expectedFrames.length; i++) {
            if (i < framesDetailsTab.size()) {
                String actualFrame = framesDetailsTab.get(i).getText();
                if (actualFrame.equals(expectedFrames[i])) {
                    System.out.println((i + 1) + " " + actualFrame + " is visible");
                } else {
                    System.out.println((i + 1) + " " + actualFrame + " does not match expected: " + expectedFrames[i]);
                }
            } else {
                System.out.println("Expected frame " + expectedFrames[i] + " is not found.");
            }
        }
        System.out.println("Validate all  "  + expectedFrames.length + " frames");
    }


    //Validate Resource Tab availability
    public boolean validateResourceTabAvailability() throws TimeoutException {
        wait = new WebDriverWait (driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(resourcesTab));
        return resourcesTab.isDisplayed();
    }
    //Validate FAQ Tab availability
    public boolean validateFAQTabAvailability() throws TimeoutException {
        wait = new WebDriverWait (driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(faqTab));
        return faqTab.isDisplayed();
    }
    //Validate Users Tab availability
    public boolean validateUsersTabAvailability() throws TimeoutException {
        wait = new WebDriverWait (driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(usersTab));
        return usersTab.isDisplayed();
    }

}
