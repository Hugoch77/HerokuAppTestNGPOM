package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class DinamicControlsPage {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement eleCheckbox;
	
	@FindBy(xpath = "//button[@onclick='swapCheckbox()']")
	WebElement eleRemoveBtn;
	
	@FindBy(xpath = "//form[@id='checkbox-example']/p")
	WebElement eleRemoveMessage;
	
	@FindBy(xpath = "//form[@id='input-example']/input")
	WebElement eleEnableDisableInput;
	
	@FindBy(xpath = "//button[@onclick='swapInput()']")
	WebElement eleEnableBtn;
	
	@FindBy(xpath = "//form[@id='input-example']/p")
	WebElement eleEnableDisableInputMessage;

	public DinamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void selectCheckbox() throws IOException {
		utils.clickBtn(driver, eleCheckbox);
	}
	
	public void clickRemoveAddBtn() throws IOException {
		utils.clickBtn(driver, eleRemoveBtn);
	}
	
	public void removeAddBtnMessage(String message) throws IOException {
		utils.validateMessage(driver, eleRemoveMessage, message);
	}
	
	public void checkInputText() throws IOException {
		utils.checkIfWritable(driver, eleEnableDisableInput);
	}
	
	public void clickEnableDisbaleBtn() throws IOException{
		utils.clickBtn(driver, eleEnableBtn);
	}
	
	public void checkEnableDisabelMessage(String message) throws IOException {
		utils.validateMessage(driver, eleEnableDisableInputMessage, message);
	}
	
	public void writeEnableDisableInput(String text) throws IOException {
		utils.sendText(driver, eleEnableDisableInput, text);
	}
	
	public void goBackToPreviousPage() throws IOException {
		utils.goBackPreviousPage(driver);
	}
}
