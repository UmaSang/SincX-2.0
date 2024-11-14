package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

public class Loginpage extends Baseclass {

	// public WebDriver driver;

	@Test(groups="sanity")
	public void TC001_verifyloginpage() {

		logger.info("....Starting LoginPage.....");
		try {

			Homepage hp = new Homepage(driver);
			hp.set_domainname(p.getProperty("domainName"));
			hp.click_firstcontiunebutton();
			hp.set_username(p.getProperty("userName"));
			hp.click_secondcontiunebutton();
			hp.set_pwd(p.getProperty("passWord"));
			hp.click_loginbutton();

			logger.info("... Loginpage Assertion Success .....");
			
			String confmsg = hp.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Welcome, SincXadmi !");
			
			hp.click_profilebutton();
			hp.click_adminmode();

 
		} catch (Exception e) {
			logger.error("...Login failed...");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info(" Loginpage is Finished");
		logger.info(" Dashboard Verified");
	}


@Test

public void TC002_verifylogout() {

	logger.info("....Starting Logout.....");
	
	try {
		
		Homepage lo=new Homepage(driver);
		lo.click_settingbutton();
		lo.click_logout();
		
		logger.info("... Logout success .....");
	}catch(Exception e) {
	
			logger.error("...Logout failed...");
	}
	
}

}