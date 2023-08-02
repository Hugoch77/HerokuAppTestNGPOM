package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class CheckboxesPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> eleCheckboxes;

	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utilities utils = new Utilities();

	public void checkIfChecked() {
		for (WebElement i : eleCheckboxes) {
			if (i.isSelected()) {
				System.out.println(i.getText() + " Is checked");
			} else {
				System.out.println(i.getText() + " Is not checked");
			}
		}
	}

	public void selectAllCheckboxes() throws IOException {
		for (WebElement i : eleCheckboxes) {
			if (!i.isSelected()) {
				utils.clickBtn(driver, i);
				System.out.println(i.getText() + " Was checked");
			} else {
				System.out.println(i.getText() + " Is already checked");
			}
		}
	}

	public void deSelectAllCheckboxes() throws IOException {
		for (WebElement i : eleCheckboxes) {
			if (i.isSelected()) {
				utils.clickBtn(driver, i);
				System.out.println(i.getText() + " Was un-checked");
			} else {
				System.out.println(i.getText() + " Is already un-checked");
			}
		}
	}

	public void selectSpecificCheckbox(int checkbox) throws IOException {
		if (checkbox == 1 && !eleCheckboxes.get(0).isSelected()) {
			utils.clickBtn(driver, eleCheckboxes.get(0));
			System.out.println(eleCheckboxes.get(0).getText() + " Was checked");
		} else if (checkbox == 2 && !eleCheckboxes.get(1).isSelected()) {
			utils.clickBtn(driver, eleCheckboxes.get(1));
			System.out.println(eleCheckboxes.get(1).getText() + " Was checked");
		} else {
			System.out.println("Is already checked");
		}
	}

	public void deSelectSpecificCheckbox(int checkbox) throws IOException {
		if (checkbox == 1 && eleCheckboxes.get(0).isSelected()) {
			utils.clickBtn(driver, eleCheckboxes.get(0));
			System.out.println(eleCheckboxes.get(0).getText() + " Was un-checked");
		} else if (checkbox == 2 && eleCheckboxes.get(1).isSelected()) {
			utils.clickBtn(driver, eleCheckboxes.get(1));
			System.out.println(eleCheckboxes.get(1).getText() + " Was un-checked");
		} else {
			System.out.println("Is already un-checked");
		}
	}
	
	public void goBackToPreviousPage() throws IOException {
		utils.goBackPreviousPage(driver);
	}

}
