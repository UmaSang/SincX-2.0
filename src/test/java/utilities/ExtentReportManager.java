package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Baseclass;

public class ExtentReportManager extends Baseclass implements ITestListener {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	//WebDriver driver;
	
	String repName;
	
	
	public void onStart(ITestContext testContext) {
		
		//SimpleDateFormat df=new SimpleDateFormat("yyy.MM.dd.HH.mm.ss");
		//Date dt=new Date();
		//String currentdatetimestamp=df.format(dt);
		//
		
		String timeStamp=new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		repName= "Test-Report-" + timeStamp + ".html";
		sparkReporter =  new ExtentSparkReporter(".\\reports\\" + repName);
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Test Execution Report");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);	
		extent.setSystemInfo("Functional Testing","Sincx");
	    extent.setSystemInfo("Module", "Admin");
	    extent.setSystemInfo("Sub Module", "Dashboard");
	    extent.setSystemInfo("User name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
	
	    String os= testContext.getCurrentXmlTest().getParameter("os");
	    extent.setSystemInfo("Operating System", os);
	    
	    String browser= testContext.getCurrentXmlTest().getParameter("browser");
	    extent.setSystemInfo("Browser", browser);

	   List<String> includedGroups= testContext.getCurrentXmlTest().getIncludedGroups();
	   if(!includedGroups.isEmpty()) {
	   extent.setSystemInfo("Groups", includedGroups.toString());
	   }
	}   

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS, result.getName() + "got successfully executed");
		 try {
				test.addScreenCaptureFromPath(captureScreenshot(driver));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, result.getName() + "got failed");
        test.log(Status.INFO,result.getThrowable().getMessage());
       
        try {
        	String imgPath= new Baseclass().captureScreen(result.getName());
        	test.addScreenCaptureFromPath(imgPath);
        	}
        catch (IOException e1) {
        		e1.printStackTrace();
        	}
 	}
	   
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+ "got skipped", null);
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+ "\\reports\\"+repName;
	    File extentReport =new File(pathOfExtentReport);
	    try {
	    	Desktop.getDesktop().browse(extentReport.toURI()); // this method, open the report automatically in the desktop
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	
	}
	
	
}






/* try {
 * Url url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
 *Create the email message ImageHTMLEmail email =new ImageHtmlEmail();
 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
 * email.setAuthenticator(new DefaultAuthenticator("pavanontraining@gmail.com", "password"));
 * email.setSSLOnConnect(true); email.setFrom("pavanontraining@gmail.com");
 * Sender email.setSubject("Test Results");
 * email.setMsg("please find attached report..");
 * email.addTo("pavan kumar.busyqa@gmail.com");
 * "extent report", "please check report.."); email.send();// send the email
 * } catch (Exception e)
 * { e.printStackTrace();
 * }
 * 
 */
	