package testCases;

import testBase.Baseclass;
import pageObjects.AssessmentPage;
import pageObjects.SectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_194 extends Baseclass {

    @Test
    public void verifyEditQues() throws InterruptedException, TimeoutException {
        SectionPage EditQue = new SectionPage(driver);
        EditQue.setTxtDomain(p.getProperty("domainName"));
        EditQue.continueClick();
        EditQue.setEmailField(p.getProperty("userName"));
        EditQue.getEmailContinueButton();
        EditQue.setPasswordField(p.getProperty("passWord"));
        EditQue.loginButton();
        EditQue.clickLogoButton();
        EditQue.clickCourseButton();
        Assert.assertTrue(EditQue.validateCoursePage());
        EditQue.clickCourseName();
        EditQue.clickThreeDots();
        EditQue.clickEditButton();
        AssessmentPage EQues = new AssessmentPage(driver);
        EQues.clickAssessmentTab();
        EQues.clickAssessEditThreeDots();
       
        EQues.clickEditQuesField(p.getProperty("EditQuesField"));
        EQues.clickSaveButton();
        Assert.assertTrue(EQues.validateAssessmentPage());



    }

}
