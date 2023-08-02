package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class FramesPage {

	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'Nested Frames')]")
	WebElement eleNestedFrames;
	
	@FindBy(xpath = "//a[contains(.,'iFrame')]")
	WebElement eleIFrames;
	
	@FindBy(xpath = "//h3")
	WebElement eleFramesMsg;
	
	public FramesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void validateFramesPage() throws IOException {
		utils.validateMessage(driver, eleFramesMsg, "Frames");
	}
	
	public void goNestedFramesPage() throws IOException {
		utils.clickBtn(driver, eleNestedFrames);
	}
	
	public void goIFramesPage() throws IOException {
		utils.clickBtn(driver, eleIFrames);
	}
	
}
