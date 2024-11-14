package testCases;

import testBase.Baseclass;
import pageObjects.AssessmentPage;
import pageObjects.SectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_185 extends Baseclass {

    @Test
    public void verifyAddMultipleOptions() throws InterruptedException, TimeoutException {
        SectionPage mo = new SectionPage(driver);
        mo.setTxtDomain(p.getProperty("domainName"));
        mo.continueClick();
        mo.setEmailField(p.getProperty("userName"));
        mo.getEmailContinueButton();
        mo.setPasswordField(p.getProperty("passWord"));
        mo.loginButton();
        mo.clickLogoButton();
        mo.clickCourseButton();
        Assert.assertTrue(mo.validateCoursePage());
        mo.clickCourseName();
        mo.clickThreeDots();
        mo.clickEditButton();
        AssessmentPage addmo = new AssessmentPage(driver);
        addmo.clickAssessmentTab();
        addmo.clickThreeDots();
        addmo.clickOptionButton();
        addmo.clickddButton();
        addmo.clickOptionField(p.getProperty("OF"));
        addmo.clickorderfield(p.getProperty("ON"));
        addmo.clickAnsField();
        addmo.clicksavButton();
        Assert.assertTrue(addmo.validateAssessmentPage());
    }


}
