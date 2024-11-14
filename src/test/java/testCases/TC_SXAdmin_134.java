package testCases;

import testBase.Baseclass;
import pageObjects.SectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_134  extends Baseclass {

    @Test
    public void verifyEmptyTitle () throws InterruptedException, TimeoutException {
        SectionPage ET = new SectionPage(driver);
        ET.setTxtDomain(p.getProperty("domainName"));
        ET.continueClick();
        ET.setEmailField(p.getProperty("userName"));
        ET.getEmailContinueButton();
        ET.setPasswordField(p.getProperty("passWord"));
        ET.loginButton();
        ET.clickLogoButton();
        ET.clickCourseButton();
        Assert.assertTrue(ET.validateCoursePage());
        ET.clickCourseName();
        ET.clickThreeDots();
        ET.clickEditButton();
        ET.clickSectionButton();
        Assert.assertTrue(ET.validateSectionPage());
        ET.clickAddButton();
        ET.clickEmptyTitleField(p.getProperty("emptyTitleField"));
        ET.clickOrderField(p.getProperty("orderField"));
        ET.clickSaveButton();
        Assert.assertTrue(ET.provideTitlePopup());
    }

}
