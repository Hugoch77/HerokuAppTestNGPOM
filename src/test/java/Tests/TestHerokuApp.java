package Tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import Pages.ABTestingPage;
import Pages.AddRemoveElementsPage;
import Pages.BasicAuthPage;
import Pages.BrokenImagesPage;
import Pages.CheckboxesPage;
import Pages.ContextMenuPage;
import Pages.DigestAuth;
import Pages.DinamicControlsPage;
import Pages.DragAndDropPage;
import Pages.DropdownPage;
import Pages.EntryAddPage;
import Pages.FileUploaderPage;
import Pages.FramesPage;
import Pages.HorizontalSliderPage;
import Pages.JQueryMenuPage;
import Pages.JavaScriptAlertsPage;
import Pages.LandingPage;
import Pages.NestedFramesPage;
import Pages.iFramePage;
import TestNGUtils.TestNGBeforeAfter;

public class TestHerokuApp extends TestNGBeforeAfter {

	String pagesArray[] = { "A/B Testing", "Add/Remove Elements", "Basic Auth", "Broken Images", "Challenging DOM",
			"Checkboxes", "Context Menu", "Digest Authentication", "Disappearing Elements", "Drag and Drop", "Dropdown",
			"Dynamic Content", "Dynamic Controls", "Dynamic Loading", "Entry Ad", "Exit Intent", "File Download",
			"File Upload", "Floating Menu", "Forgot Password", "Form Authentication", "Frames", "Geolocation",
			"Horizontal Slider", "Hovers", "Infinite Scroll", "Inputs", "JQuery UI Menus", "JavaScript Alerts",
			"JavaScript onload event error", "Key Presses", "Large & Deep DOM", "Multiple Windows", "Nested Frames",
			"Notification Messages", "Redirect Link", "Secure File Download", "Shadow DOM", "Shifting Content",
			"Slow Resources", "Sortable Data Tables", "Status Codes", "Typos", "WYSIWYG Editor" };
	List<String> pages = Arrays.asList(pagesArray);

	@Test
	public void testHerokuApp1() throws InterruptedException, IOException {

		LandingPage lanPage = new LandingPage(driver);
		ABTestingPage abTestinPage = new ABTestingPage(driver);
		AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);
		//BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
		BrokenImagesPage brokenImgPage = new BrokenImagesPage(driver);
		CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
		ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
		DigestAuth digestAuth = new DigestAuth(driver);
		DragAndDropPage dragAndDrop = new DragAndDropPage(driver);
		DropdownPage dropdown = new DropdownPage(driver);
		DinamicControlsPage dinamicControls = new DinamicControlsPage(driver);
		EntryAddPage entryAdd = new EntryAddPage(driver);
		FileUploaderPage fileUpload = new FileUploaderPage(driver);
		FramesPage frames = new FramesPage(driver);
		NestedFramesPage nestedFrames = new NestedFramesPage(driver);

		lanPage.confirmLandPageMessage();
		lanPage.selectPage("A/B Testing");

		abTestinPage.confirmABTestingPageMessage();

		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Add/Remove Elements");

		addRemovePage.confirmAddRemovePageMessage();
		addRemovePage.clickAddElementBtn();
		addRemovePage.confirmDeleteBtn();
		addRemovePage.clickDeleteBtn();

		//lanPage.confirmLandPageMessage();
		//lanPage.selectPage("Basic Auth");

		//basicAuthPage.submitUserPass();
		//basicAuthPage.confirmLogInSuccess();

		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Broken Images");

		//brokenImgPage.checkIfImageBrokenRequests();
		brokenImgPage.checkIfImageBrokenWidth();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Checkboxes");
		
		checkboxesPage.checkIfChecked();
		checkboxesPage.selectAllCheckboxes();
		checkboxesPage.checkIfChecked();
		checkboxesPage.deSelectAllCheckboxes();
		checkboxesPage.checkIfChecked();
		checkboxesPage.selectSpecificCheckbox(1);
		checkboxesPage.checkIfChecked();
		checkboxesPage.deSelectSpecificCheckbox(1);
		checkboxesPage.checkIfChecked();
		checkboxesPage.goBackToPreviousPage();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Context Menu");
		
		contextMenuPage.clickContextBox();
		contextMenuPage.alertsOptions("gettext");
		contextMenuPage.alertsOptions("accept");
		contextMenuPage.goBackPreviousPage();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Digest");
		digestAuth.logIn();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Drag and Drop");
		
		dragAndDrop.dragAndDrop();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Dropdown");
		
		dropdown.dropdown("visible text", "Option 2");
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Dynamic Controls");
		
		//Remove Message: It's gone! / Add Message: It's back!
		dinamicControls.selectCheckbox();
		dinamicControls.clickRemoveAddBtn();
		dinamicControls.removeAddBtnMessage("It's gone!");
		dinamicControls.clickRemoveAddBtn();
		dinamicControls.removeAddBtnMessage("It's back!");
		dinamicControls.selectCheckbox();
		dinamicControls.checkInputText();
		dinamicControls.clickEnableDisbaleBtn();
		//Enable Message: It's enabled! / Disable Message: It's disabled!
		dinamicControls.checkEnableDisabelMessage("It's enabled!");
		dinamicControls.writeEnableDisableInput("Now is Enabled");
		dinamicControls.clickEnableDisbaleBtn();
		dinamicControls.checkEnableDisabelMessage("It's disabled!");
		dinamicControls.goBackToPreviousPage();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Entry Ad");
		
		entryAdd.validateMessageAdd();
		entryAdd.closeModalWindow();
		entryAdd.validateMessageMainAddPage();
		entryAdd.reOpenAdd();
		entryAdd.reOpenAdd();
		entryAdd.validateMessageAdd();
		entryAdd.closeModalWindow();
		entryAdd.goBackToPreviousPage();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("File Upload");
		
		System.out.println("----------------------");
		
		fileUpload.validateFileUploaderPage();
		fileUpload.sendFile();
		fileUpload.clickUploadBtn();
		fileUpload.validateFileUploaded();
		fileUpload.goBackPreviousPage();
		fileUpload.goBackPreviousPage();
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Frames");
		
		System.out.println("----------------------");
		
		frames.validateFramesPage();
		frames.goNestedFramesPage();
		
		System.out.println("----------------------");
		
		String frame = "frame-bottom";
		nestedFrames.validateNestedFramePage();
		nestedFrames.getFramesNames();
		nestedFrames.getIntoFrame(frame);
		nestedFrames.getFrameText(frame);
		nestedFrames.getDefaultContentFrame();
		nestedFrames.goBackToPreviousPage();
		nestedFrames.goBackToPreviousPage();

		//lanPage.confirmLandPageMessage();
		//lanPage.selectPage("Frames");
		
	}
	
	@Test
	public void testHerokuApp2() throws InterruptedException, IOException {
		LandingPage lanPage = new LandingPage(driver);
		FramesPage frames = new FramesPage(driver);
		NestedFramesPage nestedFrames = new NestedFramesPage(driver);
		iFramePage iFrame = new iFramePage(driver);
		HorizontalSliderPage horizPage = new HorizontalSliderPage(driver);
		JQueryMenuPage jQuery = new JQueryMenuPage(driver);
		JavaScriptAlertsPage javaScriptalerts = new JavaScriptAlertsPage(driver);
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Frames");
		
		System.out.println("----------------------");
		
		frames.validateFramesPage();
		frames.goNestedFramesPage();
		
		System.out.println("----------------------");
		
		String frame = "frame-bottom";
		nestedFrames.validateNestedFramePage();
		nestedFrames.getFramesNames();
		nestedFrames.getIntoFrame(frame);
		nestedFrames.getFrameText(frame);
		nestedFrames.getDefaultContentFrame();
		nestedFrames.goBackToPreviousPage();
		
		System.out.println("----------------------");
		
		frames.validateFramesPage();
		frames.goIFramesPage();
		
		System.out.println("----------------------");
		
		iFrame.validateiFramePageMsg();
		iFrame.clickFileBtn();
		iFrame.clickNewDocBtn();
		iFrame.goToFrame();
		iFrame.sendKeys();
		iFrame.backToDefaultContent();
		iFrame.undo();
		iFrame.redo();
		nestedFrames.goBackToPreviousPage();
		nestedFrames.goBackToPreviousPage();
		
		System.out.println("----------------------");
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("Horizontal Slider");
		
		System.out.println("----------------------");
		
		horizPage.validateHorizontalSliderMsg();
		horizPage.moveSlider(4);
		horizPage.moveSlider(4.5f);
		horizPage.moveSlider(1);
		nestedFrames.goBackToPreviousPage();
		
		System.out.println("----------------------");
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("JQuery UI Menus");
		
		System.out.println("----------------------");
		
		jQuery.validateJQueryPageMsg();
		jQuery.hoverOverEnabled();
		jQuery.hoverOverDownloads();
		jQuery.clickExcelBtn();
		nestedFrames.goBackToPreviousPage();
		
		System.out.println("----------------------");
		
		lanPage.confirmLandPageMessage();
		lanPage.selectPage("JavaScript Alerts");
		
		System.out.println("----------------------");
		
		String JSConfirmAction1 = "Accept";
		String JSConfirmAction2 = "Dismiss";
		String JSPromptText = "Hugo Alberto Chavez";
		String JSPromptAction1 = "Accept";
		String JSPromptAction2 = "Dismiss";
		javaScriptalerts.validateJSAlertsPageMsg();
		javaScriptalerts.clickJSAlert();
		javaScriptalerts.validateJSAlertMsg();
		System.out.println("----------------------");
		javaScriptalerts.clickJSAlertConfirm(JSConfirmAction1);
		javaScriptalerts.validateJSAlertConfirmMsg(JSConfirmAction1);
		System.out.println("----------------------");
		javaScriptalerts.clickJSAlertConfirm(JSConfirmAction2);
		javaScriptalerts.validateJSAlertConfirmMsg(JSConfirmAction2);
		System.out.println("----------------------");
		javaScriptalerts.clickJSAlertPrompt(JSPromptText, JSPromptAction1);
		javaScriptalerts.validateJSAlertPromptMsg(JSPromptText, JSPromptAction1);
		System.out.println("----------------------");
		javaScriptalerts.clickJSAlertPrompt(JSPromptText, JSPromptAction2);
		javaScriptalerts.validateJSAlertPromptMsg(JSPromptText, JSPromptAction2);
		nestedFrames.goBackToPreviousPage();
		
		System.out.println("----------------------");
		
		lanPage.confirmLandPageMessage();		
		
	}
}
