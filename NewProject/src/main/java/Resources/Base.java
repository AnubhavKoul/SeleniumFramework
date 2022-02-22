package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;

	public WebDriver initializeBrowser() throws IOException {
		// Getting the values from properties file.

		FileInputStream fis = new FileInputStream(
				"C:\\My Data\\Git_Master_Repo\\NewProject\\src\\main\\java\\Resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);

		// Fetching the browserName from data.properties file
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
