package Framework.NewProject;
import java.io.IOException;
import org.apache.logging.log4j.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.PageName;


public class AppTest extends Base {
	private static Logger log = LogManager.getLogger(AppTest.class.getName());

	@BeforeTest
	public void StartUp() throws IOException
	{
		/*Initialize browser and hitting Url will be set up here.*/
		driver = initializeBrowser();
		String url = getUrl();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void navigateToAnubhavHomePage() throws IOException, InterruptedException {

		PageName pageObject = new PageName(driver);
		pageObject.clickContactUs();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		/*Closing the browser, connections etc would be set here.*/
		driver.close();
	}
}
