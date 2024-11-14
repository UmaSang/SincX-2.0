package testCases;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

public class TC_SXAdmin034 extends Baseclass{

    @Test
    public void Ex_domainTest() throws TimeoutException, java.util.concurrent.TimeoutException
    {
    	Homepage lp=new Homepage(driver);
        lp.externalDomain(p.getProperty("exdomainName"));
        lp.click_firstcontiunebutton();
        Assert.assertTrue(lp.pop_alert());

    }
}


