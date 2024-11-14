package testCases.Users;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.netty.handler.timeout.TimeoutException;
import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import pageObjects.UserTabPage;
import testBase.Baseclass;

public class TC_SXAdmin_302 extends Baseclass {

    @Test
    public void verifyTheHeaderTitle() throws InterruptedException, TimeoutException {
        {

        	SectionPage lp = new SectionPage(driver);
            lp.setTxtDomain(p.getProperty("domainName"));
            lp.continueClick();
            lp.setEmailField(p.getProperty("userName"));
            lp.getEmailContinueButton();
            lp.setPasswordField(p.getProperty("passWord"));
            lp.loginButton();

            CoursesPage cp=new CoursesPage(driver);
            cp.clickSincxButton();

            UserTabPage up=new UserTabPage(driver);
            up.clickUsersTabButton();
            Assert.assertTrue(up.validateRowHeaderTile());



        }
    }

}


