package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilitiesPackage.Utilities;

public class BasicAuthPage {

	WebDriver driver;

	@FindBy(xpath = "//p")
	WebElement eleCongratsMessage;
	
	public BasicAuthPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utilities utils = new Utilities();

	String user = "admin";
	String pass = "admin";

	public void submitUserPass() throws IOException {
		utils.popUpBasicAuth(driver, user, pass, driver.getCurrentUrl());
	}
	
	public void confirmLogInSuccess() throws IOException {
		String expectedMessage = "Congratulations";
		String actualMessage = utils.getText(driver, eleCongratsMessage);
		
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Yes, you are loged in to Basic Auth Page");
		utils.goBackPreviousPage(driver);
		utils.goBackPreviousPage(driver);
	}

}
