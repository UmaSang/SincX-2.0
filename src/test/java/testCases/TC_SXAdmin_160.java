package testCases;

import testBase.Baseclass;
import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_160 extends Baseclass {

    @Test
    public void verifyAddKeyTakeaways() throws InterruptedException, TimeoutException {
        SectionPage KT = new SectionPage(driver);
        CoursesPage cp= new CoursesPage(driver);
        
        KT.setTxtDomain(p.getProperty("domainName"));
        KT.continueClick();
        KT.setEmailField(p.getProperty("userName"));
        KT.getEmailContinueButton();
        KT.setPasswordField(p.getProperty("passWord"));
        KT.loginButton();
        KT.clickLogoButton();
        cp.clickCoursesButton();
        Assert.assertTrue(KT.validateCoursePage());
        KT.clickCourseName();
        KT.clickThreeDots();
        KT.clickSectionButton();
        Assert.assertTrue(KT.validateSectionPage());
        SubSectionPage addKT = new SubSectionPage(driver);
        addKT.clickThreeDotSubSection();
        addKT.clickKTThreeDots();
        addKT.clickSubSectionAddButton();
        addKT.clickKTTileField(p.getProperty("KTTileOne"));
        addKT.clickKOrderField(p.getProperty("KTOrderOne"));
        addKT.clickSubSectionSaveButton();
        Assert.assertTrue(addKT.validateKnowledgeCheckPage());



    }


}