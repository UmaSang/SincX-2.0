package testCases;

import testBase.Baseclass;
import pageObjects.SectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_133 extends Baseclass {

    @Test
    public void verifyAddValueInSectionPage () throws InterruptedException, TimeoutException {
        SectionPage av = new SectionPage(driver);

        av.setTxtDomain(p.getProperty("domainName"));
        av.continueClick();
        av.setEmailField(p.getProperty("userName"));
        av.getEmailContinueButton();
        av.setPasswordField(p.getProperty("passWord"));
        av.loginButton();
        av.clickLogoButton();
        av.clickCourseButton();
        Assert.assertTrue(av.validateCoursePage());
        av.clickCourseName();
        av.clickThreeDots();
        av.clickEditButton();
        av.clickSectionButton();
        Assert.assertTrue(av.validateSectionPage());
        av.clickAddButton();
        av.clickTileField(p.getProperty("titleField"));
        av.clickOrderField(p.getProperty("orderField"));
        av.clickSaveButton();
        Assert.assertTrue(av.validateSectionPage());

    }

}
