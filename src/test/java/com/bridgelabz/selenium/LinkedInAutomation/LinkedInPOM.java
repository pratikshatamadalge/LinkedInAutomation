package com.bridgelabz.selenium.LinkedInAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInPOM {

	WebDriver driver;

	public void linkedInPOM(WebDriver driver) {
		this.driver = driver;
	}

	// Login webpage
	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn__primary--large from__button--floating']")
	WebElement signIn;

	// Webelements to add post
	@FindBy(xpath = "//button[@class='share-box__open share-box__trigger p4 hoverable-link-text t-16 t-black--light t-bold'] ")
	WebElement startPost;

	@FindBy(xpath = "//p[@class='mentions-texteditor__content']")
	WebElement title;

	@FindBy(xpath = "//span[text()='Add hashtag']")
	WebElement hashtag;

	@FindBy(xpath = "//span[@class='ph1']")
	WebElement privacy;

	@FindBy(xpath = "//li[3]//button[1]//div[2]//label[1]")
	WebElement ClickConnectionOnly;

	@FindBy(xpath = "//span[text()='Done']")
	WebElement done;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement next;

	@FindBy(xpath = "//span[text()='Post']")
	WebElement postArticle;

	// To perform particular action on web element
	public void setUsername(String email) {
		userName.sendKeys(email);
	}

	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickSignIn() {
		signIn.click();
	}

	public void clickPost() {
		startPost.click();
	}

	public void setTitle(String text) {
		title.sendKeys(text);
	}

	public void addHashtag(String text) {
		hashtag.click();
		hashtag.sendKeys(text);
	}

	public void selectConnectionOnly() {
		ClickConnectionOnly.click();
	}

	public void clickOnDone() {
		done.click();
	}

	public void clickOnPrivacy() {
		privacy.click();
	}

	public void clickOnNext() {
		next.click();
	}

	public void clickOnPost() {
		postArticle.click();
	}
}
