package Framework.NewProject;
import java.io.IOException;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.Setup;
import pageObjects.HomePage;


public class AppTest extends Setup {
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(AppTest.class.getName());

	@BeforeTest
	public void StartUp() throws IOException
	{
		/*Initialize browser and hitting Url will be set up here.*/
		driver = initializeBrowser();
		log.info("Browser is successfully invoked.");
		String url = getUrl();
		driver.get(url);
		log.info("Successfully launched the website.");
		driver.manage().window().maximize();
	}
	
	@Test
	public void navigateToAnubhavHomePage() throws IOException, InterruptedException {

		HomePage pageObject = new HomePage(driver);
		//verify the page title, Failing to get the screenshot
		Assert.assertEquals("Anubhav Koul1", driver.getTitle(),"Title is not Anubhav Koul");
		pageObject.clickContactUs();
		log.info("Contact us link is working fine");
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown()
	{
		/*Closing the browser, connections etc would be set here.*/
		driver.close();
		log.info("Successfully closed the browser.");
	}
}
