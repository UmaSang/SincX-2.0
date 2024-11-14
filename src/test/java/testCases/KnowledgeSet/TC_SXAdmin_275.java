package testCases.KnowledgeSet;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.KnowledgeSetPage;
import pageObjects.SectionPage;
import testBase.Baseclass;

public class TC_SXAdmin_275 extends Baseclass {

    @Test
    public void verifyMandatoryField() throws InterruptedException, TimeoutException, java.util.concurrent.TimeoutException {
        {

        	SectionPage lp = new SectionPage(driver);
            lp.setTxtDomain(p.getProperty("domainName"));
            lp.continueClick();
            lp.setEmailField(p.getProperty("userName"));
            lp.getEmailContinueButton();
            lp.setPasswordField(p.getProperty("passWord"));
            lp.loginButton();
            

            KnowledgeSetPage dp = new KnowledgeSetPage(driver);
            CoursesPage cp = new CoursesPage(driver);
            cp.clickSincxButton();
            dp.clickKnowledgeSet();
            dp.clickAddButton();
            dp.clickSaveButton();
            Assert.assertTrue(dp.validateTitleAlert());

        }

    }
}
