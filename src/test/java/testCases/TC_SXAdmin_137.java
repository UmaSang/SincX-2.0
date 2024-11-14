package testCases;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.SectionPage;
import testBase.Baseclass;

public class TC_SXAdmin_137 extends Baseclass {

    @Test
    public void verifyTotalNumOfCourse() throws InterruptedException, TimeoutException {
    	 SectionPage addOp = new SectionPage(driver);
         addOp.setTxtDomain(p.getProperty("domainName"));
         addOp.continueClick();
         addOp.setEmailField(p.getProperty("passWord"));
         addOp.getEmailContinueButton();
         addOp.setPasswordField(p.getProperty("passWord"));
         addOp.loginButton();
       

        DashboardPage dp=new DashboardPage(driver);
        dp.clickLogoButton();
        dp.clickCourseButton();
        dp.clickTotalNoOfCourse();
        Assert.assertTrue(dp.validateCoursePage());

    }

}