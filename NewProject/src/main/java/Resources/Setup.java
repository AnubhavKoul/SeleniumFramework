package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {
		// Getting the values from properties file.

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		// Fetching the browserName from data.properties file
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			/*
			 * Traditional way of providing the driver path
			 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 * + "\\src\\main\\java\\Resources\\chromedriver.exe");
			 */

			/*
			 * To Run chrome in headless mode, make the below changes. ChromeOptions options
			 * = new ChromeOptions(); options.addArguments("headless"); driver = new
			 * ChromeDriver(options);
			 */

			// Using webdriver Manager dependency
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			/*
			 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 * + "\\src\\main\\java\\Resources\\IEdriver.exe");
			 */
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		else if (browserName.equalsIgnoreCase("Edge")) {

			/*
			 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 * + "\\src\\main\\java\\Resources\\Edgedriver.exe");
			 */
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public String getUrl() {
		
		return prop.getProperty("url");
		
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
