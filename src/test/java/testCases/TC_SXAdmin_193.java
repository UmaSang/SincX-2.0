package testCases;

import testBase.Baseclass;
import pageObjects.AssessmentPage;
import pageObjects.SectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_193 extends Baseclass {

    @Test
    public void verifyDeleteQuestion() throws InterruptedException, TimeoutException {
        SectionPage dq = new SectionPage(driver);
        dq.setTxtDomain(p.getProperty("domainName"));
        dq.continueClick();
        dq.setEmailField(p.getProperty("userName"));
        dq.getEmailContinueButton();
        dq.setPasswordField(p.getProperty("passWord"));
        dq.loginButton();
        dq.clickLogoButton();
        dq.clickCourseButton();
        Assert.assertTrue(dq.validateCoursePage());
        dq.clickCourseName();
        dq.clickThreeDots();
      
        AssessmentPage deleteQues = new AssessmentPage(driver);
        deleteQues.clickAssessmentTab();
        deleteQues.clickAssessThreeDots();
        //deleteQues.clickDeleteButton();
        deleteQues.clickDeleteField(p.getProperty("deleteField"));
        deleteQues.clickDeleteButton();
        deleteQues.clickRedDeleteButton();
        Assert.assertTrue(deleteQues.validateAssessmentPage());
    }
}