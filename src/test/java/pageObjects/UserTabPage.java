package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserTabPage extends Basepage {

    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;


    public UserTabPage(WebDriver driver) {
        super(driver);

    }


    //----------------PageObjects-------------------


    @FindBy(xpath = "//img[contains(@src, 'user')]")
    public WebElement usersTab;


    @FindBy(xpath = "//span[@class='MuiButton-label']")
    public WebElement addButton;


    @FindBy(xpath = "//div[@class='_1uyjv9i']//div[@class='_bfbtmj']//h1[normalize-space()='busyQA, Canada']")
    public WebElement UserTilePage;


    @FindBy(xpath = "//tr[@class='MuiTableRow-root MuiTableRow-head']")
    public List<WebElement> rowHeaderTitle;


    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text _cgnn4d'])[1]")
    public WebElement saveButton;


    @FindBy(xpath = "//input[@id='givenname']")
    public WebElement UserFirstName;


    @FindBy(xpath = "//input[@id='familyname']")
    public WebElement UserLastName;


    @FindBy(xpath = "//input[@id='email']")
    public WebElement UserEmail;


    @FindBy(xpath = "//input[@id='designation']")
    public WebElement UserJob;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> UserRow;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> UserColumn;


    @FindBy(xpath = "(//button[@title='Open'])[2]")
    public WebElement managerField;


    @FindBy(xpath = "//p[normalize-space()='Provide a valid first name']")
    public WebElement alertPopup;



    @FindBy(xpath = "//button[@class='_tm5ffe']//*[name()='svg']")
    public WebElement closeButton;


    @FindBy(xpath = "(//button[@title='Open'])[3]")
    public WebElement rolesField;


    @FindBy(xpath ="//tr[@class='MuiTableRow-root']")
    public List<WebElement> rowElements;

    @FindBy (xpath = "//i[@class='material-icons-outlined'][text()='more_vert']")
    public List <WebElement> threeDots;

    @FindBy(xpath = "(//div[@class='_12kvah7'])[1]")
    public WebElement EditButton;


    @FindBy(xpath = "(//div[@class='_5kaapu'])")
    public WebElement subTitles;


    @FindBy(xpath = "(//div[@class='_su47snu'])")
    public WebElement CourseTitles;


    @FindBy(xpath = "(//img[@class='_129bj4t'])[3]")
    public WebElement CourseButton;



    @FindBy(xpath = "//img[@alt='Filter image alt']")
    public WebElement filterImage;


    @FindBy(xpath = "//button[@title='Close']")
    public WebElement OpenButton;


    @FindBy(xpath = "//div[@class='_1xcambl']")
    public WebElement browseButton;


    @FindBy(xpath = "//i[normalize-space()='delete']")
    public WebElement ImageDeleteButton;


    @FindBy(xpath = "//p[@class='_2kamhyo']")
    public WebElement DeleteButton;


    @FindBy (xpath ="//input[@id='delete']")
    public WebElement deleteField;


    @FindBy (xpath="(//p[@class='_gkprm7'][normalize-space()='Delete'])")
    public WebElement redDeleteButton;


//---------------------Action methods----------------

    public void clickUsersTabButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(usersTab));
        wait.until(ExpectedConditions.elementToBeClickable(usersTab));
        usersTab.click();
    }


    public void clickUserAddButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(addButton));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }


    public void clickSaveButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public void clickUserFirstName(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UserFirstName));
        wait.until(ExpectedConditions.elementToBeClickable(UserFirstName));
        UserFirstName.sendKeys(text);
    }

    public void clickUserLastName(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UserLastName));
        wait.until(ExpectedConditions.elementToBeClickable(UserLastName));
        UserLastName.sendKeys(text);
    }

    public void clickUserEmail(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UserEmail));
        wait.until(ExpectedConditions.elementToBeClickable(UserEmail));
        UserEmail.sendKeys(text);
    }


    public void clickUserJobTitle(String text) throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UserJob));
        wait.until(ExpectedConditions.elementToBeClickable(UserJob));
        UserJob.sendKeys(text);
    }



    public void clickManagerField() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(managerField));
        managerField.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        List<WebElement> options= driver.findElements(By.xpath(
                "//ul[@class='MuiAutocomplete-listbox']//li"));
        for (WebElement option : options) {
            if (option.getText().equals("bamanager busyqa")) {
                option.click();

            }
            break;
        }
    }

    public void clickRolesField() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(rolesField));
        rolesField.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        List<WebElement> options= driver.findElements(By.xpath(
                "//ul[@class='MuiAutocomplete-listbox']//li"));

        for (WebElement option : options) {
            if (option.getText().equals("ADMIN")) {
                option.click();

            }
            break;
        }

    }
//
//    public void clickCountry() throws InterruptedException {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(managerField));
//        managerField.click();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
//        Thread.sleep(2000);
//        List<WebElement> options= driver.findElements(By.xpath(
//                "//ul[@id='mui-autocomplete-87383-popup']//li"));
//        Select dropdown = new Select(options);
//
//        // Scroll and select by visible text
//        dropdown.selectByVisibleText("Option Text");
//
//    }



    public void clickSpecificUserToEdit() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 3500)");
        Thread.sleep(2000);
        for (int i = 0; i < rowElements.size(); i++) {
            String UserName = rowElements.get(i).getText();

            if (UserName.contains("tom@gmail.com")) {
                System.out.println("UserName :" + UserName);
                threeDots.get(i).click();
                break;

            }

        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.elementToBeClickable(EditButton));
        EditButton.click();

    }



    public void clickRolesFieldToEdit() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(rolesField));
        rolesField.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        List<WebElement> options= driver.findElements(By.xpath(
                "//ul[@class='MuiAutocomplete-listbox']//li"));
        for (int i = 0; i < options.size(); i++) {
            String roleName = options.get(i).getText();
            if (roleName.contains("MANAGER")) {
                options.get(i).click();
                break;

            }
        }

    }



    public void clickCourse() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 4000)");
        Thread.sleep(2000);
        for (int i = 0; i < rowElements.size(); i++) {
            String UserName = rowElements.get(i).getText();

            if (UserName.contains("tom@gmail.com")) {
                System.out.println("UserName :" + UserName);
                threeDots.get(i).click();
                break;

            }

        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(CourseButton));
        CourseButton.click();

    }



    public void clickToDeleteUser() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 4000)");
        Thread.sleep(2000);
        for (int i = 0; i < rowElements.size(); i++) {
            String UserName = rowElements.get(i).getText();

            if (UserName.contains("tom@gmail.com")) {
                System.out.println("UserName :" + UserName);
                threeDots.get(i).click();
                break;

            }

        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(DeleteButton));
        DeleteButton.click();

    }

    public void clickToUploadImage() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        wait.until(ExpectedConditions.visibilityOf(browseButton));
        wait.until(ExpectedConditions.elementToBeClickable(browseButton));
        browseButton.click();
        Thread.sleep(2000);
        String imagePath = "C:\\Users\\Uma\\Documents\\a3.png"; // Update with your image path
        String autoITPath = "C:\\Users\\Uma\\Documents\\ImageUpload.exe";
        try {
            Runtime.getRuntime().exec(autoITPath + " " + imagePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(4000);
        ImageDeleteButton.click();
    }







//    public void clickStatus() throws InterruptedException {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
//        Thread.sleep(1000);
//
//        WebElement popupDialog = driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollTop += 200;", popupDialog);
//
//
//    }
//
//









    public void clickCloseButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(closeButton));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
    }




    public void textDeleteField(String text) throws InterruptedException {

        wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(deleteField));
        // wait.until(ExpectedConditions.elementToBeClickable(deleteField));
        deleteField.sendKeys(text);
    }



    public void clickRedDeleteButton() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(redDeleteButton));
        wait.until(ExpectedConditions.elementToBeClickable(redDeleteButton));
        redDeleteButton.click();
    }







    //----------Validation----------------------


    public boolean validateUserTilePage() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UserTilePage));
        String pl = UserTilePage.getText();
        System.out.println("Course:" + pl);
        return UserTilePage.isDisplayed();

    }


    public boolean validateRowHeaderTile() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        WebElement headerElement = driver.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head']")); // Adjust selector as needed
        String headerText = headerElement.getText();

        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(UserTilePage));
        String pl = UserTilePage.getText();
        System.out.println("Course:" + pl);
        // List of strings to check
        List<String> expectedStrings = Arrays.asList("Index", "Roles", "Name", "Email");

        // Check if each string is present in the header
        for (String Expected : expectedStrings) {
            if (headerText.contains(Expected)) {
                System.out.println(Expected + " is present in the header.");
            } else {
                System.out.println(Expected + " is NOT present in the header.");
            }
        }
        return true;
    }




    public boolean validateSubTilesAndCourses() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        WebElement headerElement = driver.findElement(By.xpath("(//div[@class='_5kaapu'])")); // Adjust selector as needed
        String headerText = headerElement.getText();

        // List of strings to check
        List<String> expectedStrings = Arrays.asList("Assigned", "Self-enrolled", "Ongoing", "Due soon", "Overdue","Completed");
        List<WebElement> gridItems = driver.findElements(By.xpath("(//div[@class='_su47snu'])"));

        for (WebElement item : gridItems) {
            System.out.println(item.getText());
        }
        for (String ExpectedTitles : expectedStrings) {
            if (headerText.contains(ExpectedTitles)) {
                System.out.println(ExpectedTitles + " is present as SubTitles .");
            } else {
                System.out.println(ExpectedTitles + " is present as SubTitles.");
            }
        }
        return true;

    }







    public boolean validateAddedUsers() throws InterruptedException {
        String searchEmail = "tom@gmail.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1621cmx']//tbody"))); // Adjust XPath to your table

        // Locate the table
        WebElement table = driver.findElement(By.xpath("//div[@class='_1621cmx']//tbody")); // Adjust as needed

        // Get all rows in the table
        List<WebElement> rows = table.findElements(By.xpath("//div[@class='_1621cmx']//tbody/tr")); // Get all row elements

        boolean emailFound = false;

        // Iterate through each row
        for (WebElement row : rows) {
            // Get all cells in the current row
            List<WebElement> cells = row.findElements(By.xpath("//tbody/tr/td[2]")); // Get all cell elements

            // Check each cell for the email address
            for (WebElement cell : cells) {
                if (cell.getText().trim().equalsIgnoreCase(searchEmail.trim())) {
                    System.out.println("Found email: " + searchEmail + " in row: " + row.getText());
                    emailFound = true;
                    break; // Exit the inner loop if found
                }
            }
            if (emailFound) {
                break; // Exit the outer loop if found
            }
        }
        return true;

    }


    public boolean validateEditedUsers() throws InterruptedException {
        String searchRoles = "tom@gmail.com";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1621cmx']//tbody"))); // Adjust XPath to your table

        // Locate the table
        WebElement table = driver.findElement(By.xpath("//div[@class='_1621cmx']//tbody")); // Adjust as needed

        // Get all rows in the table
        List<WebElement> rows = table.findElements(By.xpath("//div[@class='_1621cmx']//tbody/tr")); // Get all row elements

        boolean roleFound = false;

        // Iterate through each row
        for (WebElement row : rows) {
            // Get all cells in the current row
            List<WebElement> cells = row.findElements(By.xpath("//tbody/tr[42]/td[3]")); // Get all cell elements

            // Check each cell for the email address
            for (WebElement cell : cells) {
                if (cell.getText().trim().equalsIgnoreCase(searchRoles.trim())) {
                    System.out.println("Found role: " + searchRoles + " in row: " + row.getText());
                    roleFound = true;
                    break; // Exit the inner loop if found
                }
            }
            if (roleFound) {
                break; // Exit the outer loop if found
            }
        }
        return true;

    }












    public boolean validateAlertPopUp() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(140));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(alertPopup));
        String pl = alertPopup.getText();
        System.out.println("Alert:" + pl);
        return alertPopup.isDisplayed();

    }


    public boolean validateUserIsDeleted() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Thread.sleep(1000);
        for (int i = 0; i < rowElements.size(); i++) {
            String User = rowElements.get(i).getText();
            if (User.contains("tom@gmail.com")) {
                System.out.println("Course:" + User);
            } else {
                System.out.println("Course is Deleted Successfully");
            }
        }
        return true;
    }















}

