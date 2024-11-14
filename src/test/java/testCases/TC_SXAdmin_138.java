package testCases;

import testBase.Baseclass;
import pageObjects.CoursesPage;
import pageObjects.SectionPage;
import pageObjects.SubSectionPage;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_138 extends Baseclass {


    @Test
    public void verifyEditOrderField() throws InterruptedException, TimeoutException {
        SectionPage OF = new SectionPage(driver);
        SubSectionPage ss=new SubSectionPage(driver);
        CoursesPage cp=new CoursesPage(driver);
        OF.setTxtDomain(p.getProperty("domainName"));
        OF.continueClick();
        OF.setEmailField(p.getProperty("userName"));
        OF.getEmailContinueButton();
        OF.setPasswordField(p.getProperty("passWord"));
        OF.loginButton();
        cp.clickSincxButton();
        cp.clickCoursesButton();
        Assert.assertTrue(OF.validateCoursePage());
        OF.clickCourseName();
        OF.clickThreeDots();
       // OF.clickEditButton();
        OF.clickSectionButton();
        ss.clickSSectionThreeDots();
        ss.clickSSThreeDotsToEdit();
        ss.clickTextOrderField(p.getProperty("textOrderField"));
        OF.clickSaveButton();
        Assert.assertTrue(ss.validateSSectionPage());
    }


}