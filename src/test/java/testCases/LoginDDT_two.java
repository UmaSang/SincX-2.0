package testCases;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.Homepage;
import pageObjects.Logoutpage;
import testBase.Baseclass;
import utilities.XLUtilites;

public class LoginDDT_two extends Baseclass {

	Object[][] data;

	Homepage dd = new Homepage(driver);

	int sheetindex = dd.sheetindex;

	@DataProvider(name = "login-data")
	public Object[][] loginDataProvider() throws IOException {

		data = XLUtilites.getExceldata(sheetindex);

		return data;
	}

	@Test(dataProvider = "login-data")
	public void sincxlogin(String dName, String email, String pwd, String tType)
			throws TimeoutException, java.util.concurrent.TimeoutException, InterruptedException {
		Homepage dd = new Homepage(driver);

		if (Objects.equals(tType, "vdomain"))
			try {
				{
					dd.set_domainname(dName);
					dd.click_firstcontiunebutton();
					logger.info("valid domain");
					System.out.println("Valid domain");
					SoftAssert softAssert = new SoftAssert();
					softAssert.assertTrue(dd.validDomain());
					Thread.sleep(2000);
					dd.clickStartOverLink();
					softAssert.assertAll();

				}
			} catch (java.util.concurrent.TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if (Objects.equals(tType, "indomain")) {
			dd.set_domainname(dName);
			dd.click_firstcontiunebutton();
			logger.info("invalid domain");
			System.out.println("invalid domain");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(dd.InvalidDomain());
			dd.click_dismissButton();
			dd.domainPageisDisplayed();
			Thread.sleep(1000);
			softAssert.assertTrue(dd.domainpageisDisplayed());
			softAssert.assertAll();

		}

		else if (Objects.equals(tType, "vemail")) {

			dd.set_domainname(dName);
			dd.click_firstcontiunebutton();

			dd.set_username(email);
			logger.info("valid email");
			System.out.println("valid email");
			dd.click_secondcontiunebutton();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(dd.validUsername());
			Thread.sleep(2000);
			dd.clickStartOverLink();
			softAssert.assertAll();
		}

		else if (Objects.equals(tType, "inemail")) {

			dd.set_domainname(dName);
			dd.click_firstcontiunebutton();

			dd.set_username(email);
			dd.click_secondcontiunebutton();
			logger.info("invalid email");
			System.out.println("invalid email");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(dd.invalidEmail());
			dd.clickStartOverLink();
			softAssert.assertAll();

		} else if (Objects.equals(tType, "allvalid")) {
			dd.set_domainname(dName);
			dd.click_firstcontiunebutton();

			dd.set_username(email);
			dd.click_secondcontiunebutton();
			dd.set_pwd(pwd);
			dd.click_loginbutton();

			logger.info("allvalid");
			System.out.println("allvalid");
			dd.click_profilebutton();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(dd.verify_profilepage());
			dd.click_logout();
			System.out.println("Logged out");
			//softAssert.assertAll();

		}

		else if (Objects.equals(tType, "inpwd")) {

			dd.set_domainname(dName);
			dd.click_firstcontiunebutton();
			logger.info("invalid pwd");
			System.out.println("invalid pwd");
			dd.set_username(email);
			dd.click_secondcontiunebutton();
			dd.set_pwd(pwd);
			dd.click_loginbutton();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(dd.pop_alert());
			dd.clickStartOverLink();
			softAssert.assertAll();

		}

	}

}
