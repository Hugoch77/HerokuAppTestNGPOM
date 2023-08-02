package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class HorizontalSliderPage {

	WebDriver driver;
	
	@FindBy(css = "input[type='range']")
	WebElement eleSlider;
	
	@FindBy(id = "range")
	WebElement eleCurrentRange;
	
	@FindBy(css = "h4")
	WebElement eleHorizontalSliderPageMsg;
	
	public HorizontalSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utilities utils = new Utilities();
	
	public void validateHorizontalSliderMsg() throws IOException {
		utils.validateMessage(driver, eleHorizontalSliderPageMsg, "Set the focus on the slider");
	}
	
	public void moveSlider(float level) throws IOException {
		utils.slider(driver, eleCurrentRange, eleSlider, level);
	}
	
}
