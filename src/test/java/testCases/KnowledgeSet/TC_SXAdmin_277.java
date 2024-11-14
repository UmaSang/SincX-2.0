package testCases.KnowledgeSet;

import testBase.Baseclass;
import pageObjects.CoursesPage;
import pageObjects.DashboardPage;
import pageObjects.KnowledgeSetPage;
import pageObjects.SectionPage;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_277 extends Baseclass {

    @Test
    public void verifyToDeleteKnowledgeSet() throws InterruptedException, TimeoutException, java.util.concurrent.TimeoutException {
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
            KnowledgeSetPage kp=new KnowledgeSetPage(driver);
            kp.clickKnowledgeSet();
            kp.clickThreeDotKS();
            kp.textDeleteField(p.getProperty("deleteField"));
            kp.clickRedDeleteButton();
            Assert.assertTrue(kp.validateKnowledgeSetPage());

        }

    }
}
