package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilitiesPackage.Utilities;

public class ABTestingPage {

	WebDriver driver;
	
	@FindBy(xpath = "//p")
	WebElement eleMessage;
	
	public ABTestingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void confirmABTestingPageMessage() throws IOException {
		String expectedMessage = "This is a way in which businesses";
		String actualMessage = utils.getText(driver, eleMessage);
		
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Yes you are in the A/B test Variation 1 page");
		utils.goBackPreviousPage(driver);
	}
	
}
