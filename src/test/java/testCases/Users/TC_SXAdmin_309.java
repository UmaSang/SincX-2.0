package testCases.Users;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import pageObjects.UserTabPage;
import testBase.Baseclass;

public class TC_SXAdmin_309  extends Baseclass {

    @Test
    public void verifyEditTexts() throws InterruptedException, TimeoutException {
        {


        	SectionPage lp = new SectionPage(driver);
            lp.setTxtDomain(p.getProperty("domainName"));
            lp.continueClick();
            lp.setEmailField(p.getProperty("userName"));
            lp.getEmailContinueButton();
            lp.setPasswordField(p.getProperty("passWord"));
            lp.loginButton();

            CoursesPage cp = new CoursesPage(driver);
            cp.clickSincxButton();

            UserTabPage up = new UserTabPage(driver);
            up.clickUsersTabButton();
            up.clickSpecificUserToEdit();
            up.clickRolesFieldToEdit();
            up.clickSaveButton();
            Assert.assertTrue(up.validateEditedUsers());



        }
    }

}
