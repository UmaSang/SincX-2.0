package testCases;


import pageObjects.Homepage;
import testBase.Baseclass;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SXAdmin005 extends Baseclass {

    @Test(groups="sanity")
    public void Ex_domainTest() throws TimeoutException, java.util.concurrent.TimeoutException
    {
    	Homepage lp=new Homepage(driver);
        lp.externalDomain(p.getProperty("exdomainName"));
        lp.click_firstcontiunebutton();
        Assert.assertTrue(lp.pop_alert());

    }
}
