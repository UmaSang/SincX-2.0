package testCases;

import testBase.Baseclass;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_150 extends Baseclass {

    @Test
    public void verifySSYTFieldErrorMsg() throws InterruptedException, TimeoutException {
        SectionPage em = new SectionPage(driver);
        em.setTxtDomain(p.getProperty("domainName"));
        em.continueClick();
        em.setEmailField(p.getProperty("userName"));
        em.getEmailContinueButton();
        em.setPasswordField(p.getProperty("passWord"));
        em.loginButton();
        em.clickLogoButton();
        em.clickCourseButton();
        Assert.assertTrue(em.validateCoursePage());
        em.clickCourseName();
        em.clickThreeDots();
        em.clickEditButton();
        em.clickSectionButton();
        Assert.assertTrue(em.validateSectionPage());
        SubSectionPage errorMsg = new SubSectionPage(driver);
        errorMsg.clickThreeDotSubSection();
        //errorMsg.clickSubSectionButton();
        errorMsg.clickSubSectionAddButton();
        errorMsg.clickSubSectionTileYTField(p.getProperty("subTileTwo"));
        errorMsg.clickSubSectionYTTypeField();
        errorMsg.clickSubSectionOrderField(p.getProperty("subOrder"));
        errorMsg.clickSubSectionYouTubeField();
        errorMsg.clickSubSectionSaveButton();
        errorMsg.validateAlertPopup();
        Assert.assertTrue(errorMsg.validateAlertPopup());


    }


}
