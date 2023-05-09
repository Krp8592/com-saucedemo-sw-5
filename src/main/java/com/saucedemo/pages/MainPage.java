package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class MainPage extends Utility {
    By listOfProducts = By.xpath("//div[@class='inventory_item']");

    //List of displayed web elements
    public int numberOfProductsDisplayed() {
        Reporter.log("Verifying size of the displayed number of products " + listOfProducts.toString());
        CustomListeners.test.log(Status.PASS, "Actual products displayed " + listOfProducts.toString());
        List<WebElement> numberOfProducts = driver.findElements(listOfProducts);
        return numberOfProducts.size();
    }
}

