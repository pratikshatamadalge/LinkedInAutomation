package com.bridgelabz.selenium.LinkedInAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LinkedInTest {
	public WebDriver driver;
	ATUTestRecorder recorder;

	@BeforeClass
	public void initDriver() throws ATUTestRecorderException {
		// To set the path of chrome driver
		System.setProperty("webdriver.chrome.driver", "/home/admin1/Downloads/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		// To open the chrome in incognitto
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		// To maximize window
		driver.manage().window().maximize();

		// To start screen recording
//		recorder = new ATUTestRecorder("./VideoOutput", "LinkedInRecording", true);
//		recorder.start();
		// To launch browser
		driver.get("https://www.linkedin.com/login");
	}

	@Test
	public void linkedInTest() throws InterruptedException, AWTException {
		// To create object of robot class
		Robot robot = new Robot();

		// To cast driver to javascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Initialize the page factory
		LinkedInPOM test = PageFactory.initElements(driver, LinkedInPOM.class);

		// Enter email id
		test.setUsername("pratikshatamadalge21@gmail.com");
		Thread.sleep(1000);

		// Enter password
		test.setPassword("Pratiksha21!");
		Thread.sleep(1000);

		// Click on signin
		test.clickSignIn();
		Thread.sleep(2000);

		test.clickPost();
		Thread.sleep(1000);

		// To scroll down window
		js.executeScript("window.scrollBy(0,300)");

		test.setTitle("Automation Test");
		Thread.sleep(2000);

		test.clickOnPrivacy();
		Thread.sleep(2000);

		test.selectConnectionOnly();
		Thread.sleep(2000);

		test.clickOnDone();
		Thread.sleep(2000);

		// Mouse hovering to click on add image icon
		robot.mouseMove(480, 695);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		Thread.sleep(4000);

		// To add image
		// Path to select add image
		String image = "/home/admin1/Pictures/image.jpeg";

		// To transfer a string in simple format
		StringSelection Imagepath = new StringSelection(image);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Imagepath, null);

		Thread.sleep(2000);
		// ctrl+v to paste copied string
		// press key
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		// release key
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		test.clickOnNext();
		Thread.sleep(2000);

		test.clickOnPost();
		Thread.sleep(4000);
	}

	@AfterClass
	public void tearDown() throws ATUTestRecorderException {
		// recorder.stop();
		driver.close();
	}
}
