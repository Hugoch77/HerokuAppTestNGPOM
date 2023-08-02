package Pages;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.Utilities;

public class BrokenImagesPage {

	WebDriver driver;

	@FindBy(xpath = "//img[contains(@src,'jpg')]")
	List<WebElement> eleImages;

	public BrokenImagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utilities utils = new Utilities();

	public void checkIfImageBrokenRequests() throws IOException {

		try {
			for (WebElement img : eleImages) {
				if (img != null) {
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(img.getAttribute("src"));
					HttpResponse response = client.execute(request);
					/* For valid images, the HttpStatus will be 200 */
					if (response.getStatusLine().getStatusCode() != 200) {
						System.out.println(img.getAttribute("outerHTML") + " is broken.");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Method failed" + e.getMessage());
		}
		utils.goBackPreviousPage(driver);
	}

	public void checkIfImageBrokenWidth() throws IOException {

		try {
			for (WebElement img : eleImages) {
				if (img != null) {
					if (img.getAttribute("naturalWidth").equals("0")) {
						System.out.println(img.getAttribute("outerHTML") + " is broken.");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Method failed" + e.getMessage());
		}
		utils.goBackPreviousPage(driver);
	}

}
