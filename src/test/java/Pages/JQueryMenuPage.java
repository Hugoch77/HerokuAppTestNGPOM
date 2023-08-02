package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class JQueryMenuPage {

	WebDriver driver;
	
	@FindBy(css = ".description > p:nth-of-type(1)")
	WebElement eleJQueryPageMsg;
	
	@FindBy(xpath = "//a[contains(.,'Enabled')]")
	WebElement eleEnabledBtn;
	
	@FindBy(xpath = "//a[contains(.,'Downloads')]")
	WebElement eleDownloadsBtn;
	
	@FindBy(xpath = "//a[contains(.,'Excel')]")
	WebElement eleExcelBtn;
	
	public JQueryMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void validateJQueryPageMsg() throws IOException {
		utils.validateMessage(driver, eleJQueryPageMsg, "UI element from a user perspective");
	}
	
	public void hoverOverEnabled() throws IOException {
		utils.hoverOver(driver, eleEnabledBtn);
	}
	
	public void hoverOverDownloads() throws IOException {
		utils.hoverOver(driver, eleDownloadsBtn);
	}
	
	public void clickExcelBtn() throws IOException {
		utils.clickBtn(driver, eleExcelBtn);
	}
	
}
