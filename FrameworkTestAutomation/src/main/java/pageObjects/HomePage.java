package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;

	/* Constructor will bring the driver reference from the test to PageName class.*/

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/* User will add the locators of the particular page here. */
	String contactUs = "//a[text()='Contact']";

	public void clickContactUs() {
		driver.findElement(By.xpath(contactUs)).click();
	}
}
