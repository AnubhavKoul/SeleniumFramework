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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Setup {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {
		// Getting the values from properties file.

		FileInputStream fis = new FileInputStream(
				"C:\\My Data\\Git_Master_Repo\\NewProject\\src\\main\\java\\Resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		// Fetching the browserName from data.properties file
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\My Data\\GIT Repo\\Dependency\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\My Data\\GIT Repo\\Dependency\\IEdriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\My Data\\GIT Repo\\Dependency\\Edgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
	public String getUrl()
	{
		return prop.getProperty("url");
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot shot = (TakesScreenshot)driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}