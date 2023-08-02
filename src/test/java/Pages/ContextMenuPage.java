package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class ContextMenuPage {

	WebDriver driver;
	
	@FindBy(id = "hot-spot")
	WebElement eleContextBox;
	
	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void clickContextBox() throws IOException {
		utils.contextClick(driver, eleContextBox);
		
	}
	
	public void alertsOptions(String option) throws IOException {
		utils.alertsOptions(driver, option);
	}
	
	public void goBackPreviousPage() throws IOException {
		utils.goBackPreviousPage(driver);
	}
	
}
