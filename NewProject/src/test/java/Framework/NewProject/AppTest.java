package Framework.NewProject;
import java.io.IOException;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;
import Resources.Base;


public class AppTest extends Base {
	private static Logger log = LogManager.getLogger(AppTest.class.getName());

	@Test
	public void navigateToAnubhavHomePage() throws IOException {
		driver = initializeBrowser();
		driver.get("https://www.anubhavkoul.com");
		log.info("Trace");
	}
}
