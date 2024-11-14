package testCases.KnowledgeSet;


import testBase.Baseclass;
import pageObjects.CoursesPage;
import pageObjects.DashboardPage;
import pageObjects.SectionPage;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin_40 extends Baseclass {

    @Test
    public void verifyCourseAndRecurrenceStatus() throws InterruptedException, TimeoutException {



    	SectionPage lp = new SectionPage(driver);
        lp.setTxtDomain(p.getProperty("domainName"));
        lp.continueClick();
        lp.setEmailField(p.getProperty("userName"));
        lp.getEmailContinueButton();
        lp.setPasswordField(p.getProperty("passWord"));
        lp.loginButton();


        DashboardPage dp=new DashboardPage(driver);
        CoursesPage cp=new CoursesPage(driver);
        cp.clickSincxButton();
        dp.clickSortButton();
        dp.clickResetButton();
        dp.clickCourseStatusButton();
        dp.clickRecurrenceButton();
        dp.clickApplyButton();
        Assert.assertTrue(dp.validateAdminPage());




    }

}
