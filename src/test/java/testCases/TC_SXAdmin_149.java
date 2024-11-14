package testCases;

import testBase.Baseclass;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_149  extends Baseclass {


    @Test
    public void verifyCreateSubSectionYTField() throws InterruptedException, TimeoutException {
        SectionPage YT = new SectionPage(driver);
        YT.setTxtDomain(p.getProperty("domainName"));
        YT.continueClick();
        YT.setEmailField(p.getProperty("userName"));
        YT.getEmailContinueButton();
        YT.setPasswordField(p.getProperty("passWord"));
        YT.loginButton();
        YT.clickLogoButton();
        YT.clickCourseButton();
        Assert.assertTrue(YT.validateCoursePage());
        YT.clickCourseName();
        YT.clickThreeDots();
        YT.clickEditButton();
        YT.clickSectionButton();
        Assert.assertTrue(YT.validateSectionPage());
        SubSectionPage ssYT = new SubSectionPage(driver);
        ssYT.clickSSectionThreeDots();
       // ssYT.clickSubSectionButton();
        ssYT.clickSubSectionAddButton();
        ssYT.clickSubSectionTitle(p.getProperty("subTitleOne"));
        ssYT.clickSubSectionOrderField(p.getProperty("subOrder"));
        ssYT.clickSubSectionYTTypeField();
        ssYT.clickSubSectionYTField(p.getProperty("youtubeURL"));
        ssYT.clickSubSectionSaveButton();
        Assert.assertTrue(ssYT.validateChaptersPage());

    }


}