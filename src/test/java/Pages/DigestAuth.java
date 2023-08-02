package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class DigestAuth {

	WebDriver driver;
	
	public DigestAuth(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	String user = "admin";
	String pass = "admin";
	
	public void logIn() throws IOException {
		utils.popUpBasicAuth(driver, user, pass, driver.getCurrentUrl());
		utils.goBackPreviousPage(driver);
		utils.goBackPreviousPage(driver);
	}
	
}
