package Framework.NewProject;
import java.io.IOException;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.PageName;


public class AppTest extends Base {
	private static Logger log = LogManager.getLogger(AppTest.class.getName());

	@Test
	public void navigateToAnubhavHomePage() throws IOException, InterruptedException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		
		PageName pageObject = new PageName(driver);
		pageObject.clickContactUs();
		
	}
}
