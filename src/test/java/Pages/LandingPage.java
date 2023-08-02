package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilitiesPackage.Utilities;

public class LandingPage {
	
	WebDriver driver;
	
	@FindBy(className = "heading")
	WebElement eleLandPageWelcome;
	
	@FindBy(xpath = "//li/a")
	List<WebElement> eleAllPageLinks;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void confirmLandPageMessage() throws IOException {
		String actualMessage = utils.getText(driver, eleLandPageWelcome);
		String ExpectedMessage = "Welcome to the-internet";
		Assert.assertTrue(actualMessage.contains(ExpectedMessage), "Something wrong with the landing page");
		System.out.println("Present in Landing page");
	}
	
	public void selectPage(String Page) throws IOException {
		for(WebElement i : eleAllPageLinks) {
			if(i.getText().contains(Page)) {
				utils.clickBtn(driver, i);
				break;
			}
		}
	}
	
}
