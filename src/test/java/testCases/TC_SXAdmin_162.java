package testCases;

import testBase.Baseclass;
import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_162 extends Baseclass {

    @Test
    public void verifyKeyTakeawayLongOrder() throws InterruptedException, TimeoutException {
        SectionPage lo = new SectionPage(driver);
        CoursesPage cp= new CoursesPage(driver);
        
        
        lo.setTxtDomain(p.getProperty("domainName"));
        lo.continueClick();
        lo.setEmailField(p.getProperty("userName"));
        lo.getEmailContinueButton();
        lo.setPasswordField(p.getProperty("passWord"));
        lo.loginButton();
        lo.clickLogoButton();
        cp.clickCoursesButton();
        Assert.assertTrue(lo.validateCoursePage());
        lo.clickCourseName();
        lo.clickThreeDots();
     
        lo.clickSectionButton();
        Assert.assertTrue(lo.validateSectionPage());
        SubSectionPage ktLO = new SubSectionPage(driver);
        ktLO.clickThreeDotSubSection();
        ktLO.clickSubSectionButton();
        ktLO.clickKTThreeDots();
        ktLO.clickSubSectionAddButton();
        ktLO.clickKTTileField(p.getProperty("KTTileOne"));
        ktLO.clickKTLongOrderField(p.getProperty("KTLongOrder"));
        ktLO.clickSubSectionSaveButton();
        Assert.assertTrue(ktLO.validateTooLongOrderAlert());


    }


}