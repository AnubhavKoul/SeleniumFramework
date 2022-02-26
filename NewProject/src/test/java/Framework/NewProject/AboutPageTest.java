package Framework.NewProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.AboutPage;

public class AboutPageTest extends Base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(AppTest.class.getName());

	@BeforeTest
	public void StartUp() throws IOException {
		/* Initialize browser and hitting Url will be set up here. */
		driver = initializeBrowser();
		log.info("Browser is successfully invoked.");
		String url = getUrl();
		driver.get(url);
		log.info("Successfully launched the website.");
		driver.manage().window().maximize();
	}

	@Test
	public void navigateToAnubhavHomePage() throws IOException, InterruptedException {

		AboutPage about = new AboutPage(driver);
		about.clickAbout();
		log.info("About link is working fine");
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearDown() {
		/* Closing the browser, connections etc would be set here. */
		driver.close();
		log.info("Successfully closed the browser.");
	}
}
