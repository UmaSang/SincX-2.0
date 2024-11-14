package testBase;

	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

	public class GridBaseclass {

		public static WebDriver driver;
		public Logger logger; // Log4j
		public Properties p;

		@SuppressWarnings("deprecation")
		@BeforeClass(groups = { "sanity", "Master" })
		@Parameters({ "os", "browser" })
		public void setup(String os, String br) throws IOException {

			String gridURL = "http://localhost:4444/wd/hub";
	        
			// Loading config.properties file
			try {
				FileReader file = new FileReader("./src//test//resources//config.properties");
				p = new Properties();
				p.load(file);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			logger = LogManager.getLogger(this.getClass());
			
			

			if (p.getProperty("execution_re").equalsIgnoreCase("remote"))
				;
			{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				// os
				if (os.equalsIgnoreCase("windows")) {
					capabilities.setPlatform(Platform.WIN10);
				} else if (os.equalsIgnoreCase("mac")) {
					capabilities.setPlatform(Platform.MAC);
				} else if (os.equalsIgnoreCase("linux")) {
					capabilities.setPlatform(Platform.LINUX);
					
				} else {
					System.out.println("No matching OS");
					return;
				}
				// browser

				switch (br.toLowerCase()) {
				case "chrome":
					capabilities.setBrowserName("chrome");
					break;
				case "edge":
					capabilities.setBrowserName("MicrosoftEdge");
					break;
				case "firefox":
					capabilities.setBrowserName("firefox");
				default:
					System.out.println("No matching browser");
					return;

				}

				driver = new RemoteWebDriver(new URL(gridURL), capabilities);

			}

			if (p.getProperty("execution_lo").equalsIgnoreCase("local")) {
				switch (br.toLowerCase()) {
				case "chrome":
					driver = new ChromeDriver();
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				default:
					System.out.println("Invalid browser name..");

				}

				// driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(80));

				driver.get(p.getProperty("baseUrl")); // reading URL from Properties File
				driver.manage().window().maximize();

			}

		}

		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

			if (driver != null) {
				TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
				File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

				String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_ " + timeStamp
						+ ".png";
				File targetFile = new File(targetFilePath);
				sourceFile.renameTo(targetFile);
				return targetFilePath;
			} else {
				System.out.println("Driver is not initialized.");
			}
			return tname;

		}

		@AfterClass(groups = { "sanity", "Master" })
		public void teardown() {
			driver.quit();
		}

	}





	//try {
//	    // Create a URI first
//	    URI uri = new URI("http://localhost:4444/wd/hub");
//	    // Convert it to URL
//	    URL url = uri.toURL();
	//    
//	    DesiredCapabilities capabilities = new DesiredCapabilities();
//	    RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
	//    
//	    // Your code here
	//    
//	    driver.quit();
	//} catch (URISyntaxException | MalformedURLException e) {
//	    e.printStackTrace();
	//}




