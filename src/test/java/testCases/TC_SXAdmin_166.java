package testCases;

import testBase.Baseclass;
import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_166 extends Baseclass {

    @Test
    public void verifyEditKeyTakeaway() throws InterruptedException, TimeoutException {
        SectionPage editKT = new SectionPage(driver);
        CoursesPage cp=new CoursesPage(driver);
        
        editKT.setTxtDomain(p.getProperty("domainName"));
        editKT.continueClick();
        editKT.setEmailField(p.getProperty("userName"));
        editKT.getEmailContinueButton();
        editKT.setPasswordField(p.getProperty("passWord"));
        editKT.loginButton();
        cp.clickSincxButton();
        editKT.clickCourseButton();
        Assert.assertTrue(editKT.validateCoursePage());
        editKT.clickCourseName();
        editKT.clickThreeDots();
     
        editKT.clickSectionButton();
        Assert.assertTrue(editKT.validateSectionPage());
        SubSectionPage EKT = new SubSectionPage(driver);
        EKT.clickThreeDotSubSection();
        EKT.clickKTThreeDots();
        EKT.clickEditKTThreeDots();
        EKT.clickKeyTTileField(p.getProperty("EditKTTitle"));
        EKT.clickKeyOrderField(p.getProperty("EditKTOrder"));
        EKT.clickSubSectionSaveButton();
        Assert.assertTrue(EKT.validateKnowledgeCheckPage());


    }


}