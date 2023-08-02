package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilitiesPackage.Utilities;

public class AddRemoveElementsPage {

	WebDriver driver;

	@FindBy(xpath = "//h3")
	WebElement eleAddRemovePageMessage;

	@FindBy(xpath = "//button[@onclick='addElement()']")
	WebElement eleAddElementBtn;

	@FindBy(xpath = "//button[@onclick='deleteElement()']")
	WebElement eleDeleteBtn;

	public AddRemoveElementsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utilities utils = new Utilities();

	public void confirmAddRemovePageMessage() throws IOException {
		String expectedMessage = "Add/Remove Elements";
		String actualMessage = utils.getText(driver, eleAddRemovePageMessage);

		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Yes you are in the Add/Remove Elements page");
		// utils.goBackPreviousPage(driver);
	}

	public void clickAddElementBtn() throws IOException {
		utils.clickBtn(driver, eleAddElementBtn);
	}

	public void confirmDeleteBtn() {
		if (eleDeleteBtn.isDisplayed()) {
			System.out.println("Yes Delete button is present");
		} else {
			System.out.println("There is an issue");
		}
	}
	
	public void clickDeleteBtn() throws IOException {
		utils.clickBtn(driver, eleDeleteBtn);
		utils.goBackPreviousPage(driver);
	}
}
