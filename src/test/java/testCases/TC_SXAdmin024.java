package testCases;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

public class TC_SXAdmin024 extends Baseclass{
	
	@Test
	 public void verify_twocompwd() throws TimeoutException {
		
		try
		{
		 Homepage cp=new Homepage(driver);
	     cp.set_domainname(p.getProperty("domainName"));
	     cp.click_firstcontiunebutton();
	     cp.set_username(p.getProperty("userName"));
	     cp.click_secondcontiunebutton();
	     cp.setTwoComPwd(p.getProperty("twoComPwd"));
	     cp.click_loginbutton();
	     Assert.assertTrue(cp.twoCombinationPwd());
	}
		catch(Exception e)
        {
        	logger.error("...Verified...");
        }
}
	
}
