package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class JavaScriptAlertsPage {

	WebDriver driver;
	
	@FindBy(css = "div p:nth-of-type(1)")
	WebElement eleJSMsg;
	
	@FindBy(css = "button[onclick='jsAlert()']")
	WebElement eleJSAlert;
	
	@FindBy(css = "button[onclick='jsConfirm()']")
	WebElement eleJSConfirm;
	
	@FindBy(css = "button[onclick='jsPrompt()']")
	WebElement eleJSPrompt;
	
	@FindBy(id = "result")
	WebElement eleJSResultMsg;
	
	public JavaScriptAlertsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void validateJSAlertsPageMsg() throws IOException {
		utils.validateMessage(driver, eleJSMsg, "Here are some examples of different JavaScript alerts");
	}
	
	public void clickJSAlert() throws IOException {
		utils.clickBtn(driver, eleJSAlert);
		utils.alertSimple(driver);
	}
	
	public void validateJSAlertMsg() throws IOException {
		utils.validateMessage(driver, eleJSResultMsg, "You successfully clicked an alert");
	}
	
	public void clickJSAlertConfirm(String action) throws IOException {
		utils.clickBtn(driver, eleJSConfirm);
		utils.alertConfirm(driver, action);
	}
	
	public void validateJSAlertConfirmMsg(String action) throws IOException {
		if(action.toLowerCase().contains("accept")) {
			utils.validateMessage(driver, eleJSResultMsg, "You clicked: Ok");
		} else if (action.toLowerCase().contains("dismiss")) {
			utils.validateMessage(driver, eleJSResultMsg, "You clicked: Cancel");
		}
	}
	
	public void clickJSAlertPrompt(String text, String action) throws IOException {
		utils.clickBtn(driver, eleJSPrompt);
		utils.alertPrompt(driver, text, action);
	}
	
	public void validateJSAlertPromptMsg(String text, String action) throws IOException {
		if(action.toLowerCase().contains("accept")) {
			utils.validateMessage(driver, eleJSResultMsg, "You entered: " + text);
		} else if (action.toLowerCase().contains("dismiss")) {
			utils.validateMessage(driver, eleJSResultMsg, "You entered: null");
		}
	}
	
}
