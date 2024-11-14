package testCases;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SectionPage;
import testBase.Baseclass;

public class TC_SXAdmin_132 extends Baseclass  {


    @Test
    public void clickSectionPage () throws InterruptedException, TimeoutException {
        SectionPage sp = new SectionPage(driver);

        sp.setTxtDomain(p.getProperty("domainName"));
        sp.continueClick();
        sp.setEmailField(p.getProperty("userName"));
        sp.getEmailContinueButton();
        sp.setPasswordField(p.getProperty("passWord"));
        sp.loginButton();
        sp.clickLogoButton();
        sp.clickCourseButton();
        Assert.assertTrue(sp.validateCoursePage());
        sp.clickCourseName();
        sp.clickThreeDots();
       // sp.clickEditButton();
        sp.clickSectionButton();
        Assert.assertTrue(sp.validateSectionPage());

    }
}
