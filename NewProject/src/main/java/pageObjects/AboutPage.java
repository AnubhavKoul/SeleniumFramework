package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage {

	public WebDriver driver;

	/* Constructor will bring the driver reference from the test to PageName class.*/

	public AboutPage(WebDriver driver) {
		this.driver = driver;
	}

	/* User will add the locators of the particular page here. */
	String about = "//a[text()='About']";

	public void clickAbout() {
		driver.findElement(By.xpath(about)).click();
	}
}
