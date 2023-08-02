package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class DragAndDropPage {

	WebDriver driver;

	@FindBy(id = "column-a")
	WebElement eleA;
	
	@FindBy(id = "column-b")
	WebElement eleB;
	
	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utilities utils = new Utilities();
	
	public void dragAndDrop() throws IOException {
		utils.dragAndDrop(driver, eleA, eleB);
		utils.goBackPreviousPage(driver);
	}
	
}
