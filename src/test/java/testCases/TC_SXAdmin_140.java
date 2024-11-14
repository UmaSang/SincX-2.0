package testCases;

import testBase.Baseclass;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_140  extends Baseclass {

    @Test
    public void verifyCreateSubSection() throws InterruptedException, TimeoutException {
        SectionPage ss = new SectionPage(driver);
        
        
        ss.setTxtDomain(p.getProperty("domainName"));
        ss.continueClick();
        ss.setEmailField(p.getProperty("userName"));
        ss.getEmailContinueButton();
        ss.setPasswordField(p.getProperty("passWord"));
        ss.loginButton();
        ss.clickLogoButton();
        ss.clickCourseButton();
        Assert.assertTrue(ss.validateCoursePage());
        ss.clickCourseName();
        ss.clickThreeDots();
        ss.clickEditButton();
        ss.clickSectionButton();
        Assert.assertTrue(ss.validateSectionPage());
        SubSectionPage ssp = new SubSectionPage(driver);
        ssp.clickSSectionThreeDots();
        ssp.clickSubSectionButton();
        ssp.clickSubSectionAddButton();
        ssp.clickSubSectionTitle(p.getProperty("subTitleOne"));
        ssp.clickSubSectionYTTypeFieldss();
        ssp.clickSubSectionTextField(p.getProperty("subText"));
        ssp.clickSubSectionOrderField(p.getProperty("subOrder"));
        ssp.clickSubSectionSaveButton();
        Assert.assertTrue(ssp.validateChaptersPage());

    }

    }
