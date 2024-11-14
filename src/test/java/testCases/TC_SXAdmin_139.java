package testCases;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import testBase.Baseclass;

public class TC_SXAdmin_139 extends Baseclass {

    @Test
    public void verifyDeleteSection() throws InterruptedException, TimeoutException {
        SectionPage ss = new SectionPage(driver);
        CoursesPage cp=new CoursesPage(driver);
        ss.setTxtDomain(p.getProperty("domainName"));
        ss.continueClick();
        ss.setEmailField(p.getProperty("userName"));
        ss.getEmailContinueButton();
        ss.setPasswordField(p.getProperty("passWord"));
        ss.loginButton();
        ss.clickLogoButton();
        cp.clickCoursesButton();
        Assert.assertTrue(ss.validateCoursePage());
        ss.clickCourseName();
        ss.clickThreeDots();
        ss.clickEditButton();
        ss.clickSectionButton();
        ss.clickToDeleteThreeDots();
        ss.clickDeleteButton();
        ss.textDeleteField(p.getProperty("deleteField"));
        ss.clicksScenarioDeleteButton();
        Assert.assertTrue(ss.validateSectionPage());

    }


}