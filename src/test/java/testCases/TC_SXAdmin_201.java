package testCases;

import testBase.Baseclass;
import pageObjects.AssessmentPage;
import pageObjects.OptionPage;
import pageObjects.SectionPage;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_201 extends Baseclass {

    @Test
    public void verifyOrderAcceptLongString() throws InterruptedException, TimeoutException {
        SectionPage addOp = new SectionPage(driver);
        addOp.setTxtDomain(p.getProperty("domainName"));
        addOp.continueClick();
        addOp.setEmailField(p.getProperty("userName"));
        addOp.getEmailContinueButton();
        addOp.setPasswordField(p.getProperty("passWord"));
        addOp.loginButton();
        addOp.clickLogoButton();
        addOp.clickCourseButton();
        Assert.assertTrue(addOp.validateCoursePage());
        addOp.clickCourseName();
        addOp.clickThreeDots();
        addOp.clickEditButton();
        AssessmentPage addOption = new AssessmentPage(driver);
        addOption.clickAssessmentTab();
        OptionPage op = new OptionPage(driver);
        op.clickthreeDots();
        op.clickOptionButton();
        op.clickOptionAddButton();
        op.clickOptionTitleField(p.getProperty("EditQuesField"));
        op.clickOptionOrderField(p.getProperty("longString"));
        op.clickOptionAnswerField();
        op.clickOptionSaveButton();
        Assert.assertTrue(op.validateAssessmentPage());

        }


    }