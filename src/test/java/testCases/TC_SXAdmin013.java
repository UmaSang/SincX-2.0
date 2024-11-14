package testCases;


import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

import java.util.Set;

public class TC_SXAdmin013 extends Baseclass {

    @Test(groups={"sanity","Master"})
    public void privacyLink() throws TimeoutException {
    	
    	try
    	{
    	Homepage pl = new Homepage(driver);
        pl.set_domainname(p.getProperty("domainName"));
        pl.click_firstcontiunebutton();

        pl.setPrivacyLinkClick();
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    	}     
        catch(Exception e)
        {
        	logger.error("...Window Handled...");
        }
       
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle, "SincX");

    }

    }
    

