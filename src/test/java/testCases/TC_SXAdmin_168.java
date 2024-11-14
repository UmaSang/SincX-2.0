package testCases;

import testBase.Baseclass;
import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_168 extends Baseclass {

    @Test
    public void verifyAddKnowledgeCheck() throws InterruptedException, TimeoutException {
        SectionPage addKC = new SectionPage(driver);
        CoursesPage cp=new CoursesPage(driver);
        
        
        
        addKC.setTxtDomain(p.getProperty("domainName"));
        addKC.continueClick();
        addKC.setEmailField(p.getProperty("userName"));
        addKC.getEmailContinueButton();
        addKC.setPasswordField(p.getProperty("passWord"));
        addKC.loginButton();
        cp.clickSincxButton();
        addKC.clickCourseButton();
        Assert.assertTrue(addKC.validateCoursePage());
        addKC.clickCourseName();
        addKC.clickThreeDots();
        addKC.clickEditButton();
        addKC.clickSectionButton();
        Assert.assertTrue(addKC.validateSectionPage());
        SubSectionPage KC = new SubSectionPage(driver);
        KC.clickThreeDotSubSection();
        KC.clickKCThreeDots();
        KC.clickKCAddButton();
        KC.clickKCTitleField(p.getProperty("KCTitleField"));
        KC.clickKCOrderField(p.getProperty("KCOrderField"));
        KC.clickKCOueField();
        KC.clickKCSaveButton();
        Assert.assertTrue(KC.validateQuizPage());


    }


}