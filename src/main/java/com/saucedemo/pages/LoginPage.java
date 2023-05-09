package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userNameField;
    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement actualText;


    //Send text to username field
    public void enterUserName(String userName) {
        Reporter.log("Entering Username " + userNameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter username " + userName);
        sendTextToElement(userNameField, userName);
    }

    //Send text to password field
    public void enterPassword(String password) {
        Reporter.log("Entering Password " + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter password " + password);
        sendTextToElement(passwordField, password);
    }

    //Click on login button
    public void clickOnLoginButton() {
        Reporter.log("Clicking on login button" + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on login button " + loginButton);
        clickOnElement(loginButton);
    }


    //Get text from the element
    public String getActualText() {
        Reporter.log("Getting the text from the element" + actualText.toString());
        CustomListeners.test.log(Status.PASS, "Actual text displayed " + actualText.toString());
        return getTextFromElement(actualText);
    }
}
