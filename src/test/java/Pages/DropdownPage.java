package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class DropdownPage {

	WebDriver driver;
	
	@FindBy(id = "dropdown")
	WebElement eleDropdown;
	
	public DropdownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void dropdown(String option, String value) throws IOException {
		utils.selectDropdown(driver, eleDropdown, option, value);
		utils.goBackPreviousPage(driver);
		System.out.println("Dropdown page test complete");
	}
}
