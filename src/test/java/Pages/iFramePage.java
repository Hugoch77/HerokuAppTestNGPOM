package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class iFramePage {

	WebDriver driver;
	
	@FindBy(css = "div[class='example'] h3")
	WebElement eleiFramePageMsg;
	
	@FindBy(xpath = "//span[contains(.,'File')]/parent::button")
	WebElement eleFileBtn;
	
	@FindBy(css = "div[class='tox-collection__item-label']")
	WebElement eleNewDocBtn;
	
	@FindBy(id = "mce_0_ifr")
	WebElement eleFrame;
	
	@FindBy(id = "tinymce")
	WebElement eleTextBox;
	
	@FindBy(css = "button[aria-label='Undo']")
	WebElement eleUndo;
	
	@FindBy(css = "button[aria-label='Redo']")
	WebElement eleRedo;
	
	public iFramePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void validateiFramePageMsg() throws IOException {
		utils.validateMessage(driver, eleiFramePageMsg, "An iFrame containing");
	}
	
	public void clickFileBtn() throws IOException {
		utils.clickBtn(driver, eleFileBtn);
	}
	
	public void clickNewDocBtn() throws IOException {
		utils.clickBtn(driver, eleNewDocBtn);
	}
	
	public void goToFrame() throws IOException {
		utils.getFrame(driver, eleFrame);
	}
	
	public void backToDefaultContent() throws IOException {
		utils.getDefaultContentFrame(driver);
	}
	
	public void sendKeys() throws IOException {
		utils.sendText(driver, eleTextBox, "Hugo Alberto Chavez Garcia");
	}
	
	public void undo() throws IOException {
		utils.clickBtn(driver, eleUndo);
	}
	public void redo() throws IOException {
		utils.clickBtn(driver, eleRedo);
	}
	
}
