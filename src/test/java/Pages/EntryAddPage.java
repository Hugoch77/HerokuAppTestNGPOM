package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class EntryAddPage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='modal-footer']/child::p")
	WebElement eleCloseModalWindowBtn;
	
	@FindBy(xpath = "//div[@class='modal-title']/child::h3")
	WebElement eleModalWindowMsg;
	
	@FindBy(xpath = "//div[@class='example']/child::p[contains(.,'To re-enable it, ')]")
	WebElement eleAddPageMsg;
	
	@FindBy(id = "restart-ad")
	WebElement eleReEnableAdd;
	
	Utilities utils = new Utilities();
	
	public EntryAddPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateMessageAdd() throws IOException {
		utils.validateMessage(driver, eleModalWindowMsg, "THIS IS A MODAL WINDOW");
	}
	
	public void closeModalWindow() throws IOException {
		utils.clickBtn(driver, eleCloseModalWindowBtn);
	}
	
	public void validateMessageMainAddPage() throws IOException {
		utils.validateMessage(driver, eleAddPageMsg, "To re-enable it,");
	}
	
	public void reOpenAdd() throws IOException {
		utils.clickBtn(driver, eleReEnableAdd);
	}
	
	public void goBackToPreviousPage() throws IOException {
		utils.goBackPreviousPage(driver);
	}
	
}
