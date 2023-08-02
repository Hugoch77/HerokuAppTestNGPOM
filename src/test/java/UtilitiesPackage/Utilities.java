package UtilitiesPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	public static void Take_A_ScreenShot(WebDriver driver, String fileName) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot,
				new File("D:\\Eclipse\\Projects\\HerokuAppE2E\\test-output\\Screenshots\\Error_Screenshot.jpg"));
	}

	public void sendText(WebDriver driver, WebElement element, String text) throws IOException {
		try {
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void clickBtn(WebDriver driver, WebElement element) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			System.out.println("You clicked the element: " + element.getText());
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			// element.click();;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getTitle());
		}
	}

	public void submitBtn(WebDriver driver, WebElement element) throws IOException {
		try {
			element.submit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getTitle());
		}
	}

	public void dropdown(WebDriver driver, WebElement element, String value) throws IOException {
		try {
			Select select = new Select(element);
			select.selectByValue(value.toUpperCase());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public String getText(WebDriver driver, WebElement element) throws IOException {
		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
			return e.getMessage();
		}
	}

	public void goBackPreviousPage(WebDriver driver) throws IOException {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void popUpBasicAuth(WebDriver driver, String user, String pass, String url) throws IOException {
		try {
			String splitUrl[] = url.split("//");
			driver.get(splitUrl[0] + "//" + user + ":" + pass + "@" + splitUrl[1]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void alertsOptions(WebDriver driver, String optionToPerform) throws IOException {
		try {
			if (optionToPerform.toLowerCase() == "accept") {
				driver.switchTo().alert().accept();
				System.out.println("Alert accepted");
			} else if (optionToPerform.toLowerCase() == "dismiss") {
				driver.switchTo().alert().dismiss();
				System.out.println("Alert Dismissed");
			} else if (optionToPerform.toLowerCase() == "gettext") {
				System.out.println("Alert text: " + driver.switchTo().alert().getText());
			} else
				System.out.println("Your option to perform should be one of the following: accept / dismiss / gettext");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void contextClick(WebDriver driver, WebElement element) throws IOException {
		try {
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void dragAndDrop(WebDriver driver, WebElement dragElement, WebElement dropElement) throws IOException {
		try {
			// Actions action = new Actions(driver);
			// action.dragAndDrop(dragElement, dropElement).build().perform();
			// action.dragAndDropBy(dragElement, 100, 0).build().perform();
			// action.clickAndHold(dragElement).moveToElement(dropElement).release(dragElement).build().perform();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("function createEvent(typeOfEvent) {\n"
					+ "var event =document.createEvent(\"CustomEvent\");\n"
					+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
					+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
					+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
					+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
					+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
					+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
					+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
					+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
					+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
					+ "var dropEvent = createEvent('drop');\n"
					+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
					+ "var dragEndEvent = createEvent('dragend');\n"
					+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
					+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
					+ "simulateHTML5DragAndDrop(source,destination);", dragElement, dropElement);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void selectDropdown(WebDriver driver, WebElement element, String option, String value) throws IOException {
		try {
			Select dropdown = new Select(element);
			if (option == "index") {
				dropdown.selectByIndex(Integer.parseInt(value));
			} else if (option == "value") {
				dropdown.selectByValue(value);
			} else if (option == "visible text") {
				dropdown.selectByVisibleText(value);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void validateMessage(WebDriver driver, WebElement element, String expected) throws IOException {
		try {
			if (element.getText().contains(expected)) {
				System.out.println("The expected message is correct: " + "'" + element.getText() + "'");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void validateMessage(WebDriver driver, String pageTitle, String expected) throws IOException {
		try {
			if (pageTitle.contains(expected)) {
				System.out.println("The expected message is correct: " + "'" + pageTitle + "'");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void checkIfWritable(WebDriver driver, WebElement elementImputText) throws IOException {
		try {
			if (!elementImputText.isEnabled()) {
				System.out.println("Input text Element is NOT enabled");
			} else {
				System.out.println("Input text Element is already enabled");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void fileUpload(WebDriver driver, WebElement element) throws IOException {
		// D:\Eclipse\Projects\HerokuAppE2E\test-output\FileUpload
		try {
			element.sendKeys(
					"D:\\Eclipse\\Projects\\HerokuAppE2E\\test-output\\FileUpload\\C. V. Alejandro Castellanos_EN.pdf");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void getFrame(WebDriver driver, String frameName) throws IOException {
		try {
			driver.switchTo().frame(frameName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void getFrame(WebDriver driver, WebElement frameName) throws IOException {
		try {
			driver.switchTo().frame(frameName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void getDefaultContentFrame(WebDriver driver) throws IOException {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

	public void slider(WebDriver driver, WebElement currentRange, WebElement slider, float level) throws IOException {
		try {
			float currentLevel = Float.parseFloat(currentRange.getText());
			if (level <= 5 && level >= 0 && level > currentLevel) {
				int times = (int) ((level - currentLevel) / 0.5);
				for (int i = 0; i < times; i++) {
					slider.sendKeys(Keys.ARROW_RIGHT);
				}
				System.out.println("Level was set to: " + currentRange.getText());
			} else if (level <= 5 && level >= 0 && level < currentLevel) {
				int times = (int) ((currentLevel - level) / 0.5);
				for (int i = 0; i < times; i++) {
					slider.sendKeys(Keys.ARROW_LEFT);
				}
				System.out.println("Level was set to: " + currentRange.getText());
			} else {
				System.out.println("You entered Level: " + level + ". Level should be between 0 and 5 (.5 allowed)");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}
	
	public void hoverOver(WebDriver driver, WebElement element) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			Actions action = new Actions(driver);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.moveToElement(element).build().perform();
			System.out.println("Hover Over element: " + element.getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}
	
	public void alertSimple(WebDriver driver) throws IOException {
		try {
			System.out.println("Alert Message: " + driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}
	
	public void alertConfirm(WebDriver driver, String action) throws IOException {
		try {
			System.out.println("Alert Message: " + driver.switchTo().alert().getText());
			if(action.toLowerCase().contains("accept")) {
				driver.switchTo().alert().accept();
			} else if (action.toLowerCase().contains("dismiss")) {
				driver.switchTo().alert().dismiss();
			} else {
				System.out.println("Your action: '" + action + "' is not allowed. Allowed actions are: Accept or Dismiss");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}
	
	public void alertPrompt(WebDriver driver, String text, String action) throws IOException {
		try {
			System.out.println("Alert Message: " + driver.switchTo().alert().getText());
			driver.switchTo().alert().sendKeys(text);
			if(action.toLowerCase().contains("accept")) {
				driver.switchTo().alert().accept();
			} else if (action.toLowerCase().contains("dismiss")) {
				driver.switchTo().alert().dismiss();
			} else {
				System.out.println("Your action: '" + action + "' is not allowed. Allowed actions are: Accept or Dismiss");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Take_A_ScreenShot(driver, driver.getCurrentUrl());
		}
	}

}
