package testCases;

import testBase.Baseclass;
import pageObjects.AssessmentPage;
import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_184 extends Baseclass {

    @Test
    public void verifyAddQuestionInAssessPage() throws InterruptedException, TimeoutException {
        SectionPage addQ = new SectionPage(driver);
        CoursesPage cp=new CoursesPage(driver);
        addQ.setTxtDomain(p.getProperty("domainName"));
        addQ.continueClick();
        addQ.setEmailField(p.getProperty("userName"));
        addQ.getEmailContinueButton();
        addQ.setPasswordField(p.getProperty("passWord"));
        addQ.loginButton();
        cp.clickSincxButton();
        addQ.clickCourseButton();
        Assert.assertTrue(addQ.validateCoursePage());
        addQ.clickCourseName();
        addQ.clickThreeDots();
        
        AssessmentPage ap = new AssessmentPage(driver);
        ap.clickAssessmentTab();
        Assert.assertTrue(ap.validateAssessmentPage());
        ap.clickAddButton();
        ap.clickQuesField(p.getProperty("quesField"));
        ap.clickOrderField(p.getProperty("OrderField"));
        ap.clickQuesTypeField();
        ap.clickSaveButton();
        Assert.assertTrue(ap.validateAssessmentPage());

    }


}