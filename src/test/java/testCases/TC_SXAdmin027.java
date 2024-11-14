package testCases;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

public class TC_SXAdmin027 extends Baseclass {

    @Test(groups={"sanity","Master"})
    public void setInvalidDomain() throws TimeoutException, java.util.concurrent.TimeoutException {
        Homepage id = new Homepage(driver);
        id.inDomainName(p.getProperty("InvaliddomainName"));

        id.click_firstcontiunebutton();
        try {
			Assert.assertTrue(id.InvalidDomain());
		} catch (java.util.concurrent.TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}