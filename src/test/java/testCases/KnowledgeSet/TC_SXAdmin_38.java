package testCases.KnowledgeSet;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.DashboardPage;
import pageObjects.SectionPage;
import testBase.Baseclass;

public class TC_SXAdmin_38 extends Baseclass {

    @Test
    public void verifySortFilter() throws InterruptedException, TimeoutException {



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
        dp.clickGroupButton();
        dp.clickListOfCourse();
        dp.clickApplyButton();
        Assert.assertTrue(dp.validateAdminPage());

    }

    }
