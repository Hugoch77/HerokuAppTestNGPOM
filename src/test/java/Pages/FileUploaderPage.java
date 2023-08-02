package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class FileUploaderPage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='example']/child::p")
	WebElement eleFuleUploaderPageMsg;
	
	@FindBy(id = "file-upload")
	WebElement eleSelectArch;
	
	@FindBy(id = "file-submit")
	WebElement eleUploadBtn;
	
	@FindBy(id = "uploaded-files")
	WebElement eleUploadedFileMsg;
	
	public FileUploaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void validateFileUploaderPage() throws IOException {
		utils.validateMessage(driver, eleFuleUploaderPageMsg, "Choose a file on your system");
	}
	
	public void sendFile() throws IOException {
		utils.fileUpload(driver, eleSelectArch);
	}
	
	public void clickUploadBtn() throws IOException {
		utils.clickBtn(driver, eleUploadBtn);
	}
	
	public void validateFileUploaded() throws IOException {
		utils.validateMessage(driver, eleUploadedFileMsg, "C. V. Alejandro Castellanos_EN");
	}
	
	public void goBackPreviousPage() throws IOException {
		utils.goBackPreviousPage(driver);
	}
	
}
