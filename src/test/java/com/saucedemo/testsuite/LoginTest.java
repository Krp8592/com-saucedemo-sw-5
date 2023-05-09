package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.MainPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public  void inIt(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPage() {

        String expectedText = "Products";
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String actualText = loginPage.getActualText();
        Assert.assertEquals(expectedText, actualText, "Expected text is not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyErrorMessageWithInvalidCredentials(){

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = mainPage.numberOfProductsDisplayed();
        Assert.assertEquals(expectedNumberOfProducts, actualNumberOfProducts, "Expected number of products are not displayed");
    }
}
