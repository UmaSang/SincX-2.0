package testCases;

import testBase.Baseclass;
import pageObjects.AssessmentPage;
import pageObjects.CoursesPage;
import pageObjects.OptionPage;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_177 extends Baseclass {

    @Test
    public void verifyEditKnowledgeCheck() throws InterruptedException, TimeoutException {
        SectionPage editKC = new SectionPage(driver);
        CoursesPage cp=new CoursesPage(driver);
        
        
        editKC.setTxtDomain(p.getProperty("domainName"));
        editKC.continueClick();
        editKC.setEmailField(p.getProperty("userName"));
        editKC.getEmailContinueButton();
        editKC.setPasswordField(p.getProperty("passWord"));
        editKC.loginButton();
        cp.clickSincxButton();
        editKC.clickCourseButton();
        Assert.assertTrue(editKC.validateCoursePage());
        editKC.clickCourseName();
        editKC.clickThreeDots();
        editKC.clickSectionButton();
        SubSectionPage EKC = new SubSectionPage(driver);
        EKC.clickThreeDotSubSection();
        EKC.clickKCThreeDots();
        EKC.clickEditKCThreeDots();
       AssessmentPage ap=new AssessmentPage(driver);
       OptionPage op= new OptionPage(driver);
        op.clickOptionTitleField(p.getProperty("optionTitle"));
        op.clickOptionOrderField(p.getProperty("optionOrder"));
        op.clickOptionAnswerField();
        ap.clickKCSaveButton();
        Assert.assertTrue(op.validateQuizPage());




    }


}