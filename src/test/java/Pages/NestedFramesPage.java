package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class NestedFramesPage {

	WebDriver driver;

	@FindBy(xpath = "//frame")
	List<WebElement> eleFrames;

	@FindBy(xpath = "//frame[@name='frame-top']/parent::frameset")
	WebElement eleFrameMaster;

	@FindBy(tagName = "body")
	List<WebElement> eleLeftMsg;

	public NestedFramesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utilities utils = new Utilities();

	public void validateNestedFramePage() throws IOException {
		utils.validateMessage(driver, driver.getCurrentUrl(), "nested_frames");
	}

	public void getFrame(String frameName) throws IOException {
		for (WebElement i : eleFrames) {
			System.out.println(i.getAttribute("name"));
			// String frameMsg = driver.findElement(By.xpath("//body[contains(.,'" +
			// frameName +"')]")).getText();
			if (i.getAttribute("name").contains(frameName)) {
				utils.getFrame(driver, i.getAttribute("name"));
				System.out.println(i.getAttribute("name"));
				utils.validateMessage(driver, i.getAttribute("name"), frameName);
			} else {
				utils.getFrame(driver, i.getAttribute("name"));
				;
			}
		}
	}

	public void getFramesNames() {
		for (WebElement i : eleFrames) {
			System.out.println(i.getAttribute("name"));
		}
		driver.switchTo().frame("frame-top");
		for (WebElement i : eleFrames) {
			System.out.println(i.getAttribute("name"));
		}
		driver.switchTo().defaultContent();
	}
	
	public void getIntoFrame(String frameName) {
		if(frameName == "frame-left" || frameName == "frame-right" || frameName == "frame-middle") {
			driver.switchTo().frame("frame-top");
			driver.switchTo().frame(frameName);
			System.out.println("You entered frame: " + frameName);
		} else if (frameName == "frame-bottom") {
			driver.switchTo().frame(frameName);
			System.out.println("You entered frame: " + frameName);
		}
	}
	
	public void getDefaultContentFrame() throws IOException {
		utils.getDefaultContentFrame(driver);
	}
	
	public void getFrameText(String frame) throws IOException {
		for(WebElement i : eleLeftMsg) {
			if(frame.contains(i.getText().toLowerCase())) {
				String expected[] = frame.split("-");
				utils.validateMessage(driver, i.getText().toLowerCase(), expected[1]);
			}
		}
	}
	
	public void goBackToPreviousPage() throws IOException {
		utils.goBackPreviousPage(driver);
	}
}
