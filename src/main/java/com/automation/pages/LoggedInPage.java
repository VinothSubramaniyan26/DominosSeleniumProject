package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {

    WebDriver driver;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");
    By logout = By.xpath("//a[contains(text(),'Logout')]");

    // Verify Login
    public void verifyLogin() {

        String text = driver.findElement(loggedInUser).getText();

        System.out.println(text);

        if (text.contains("Logged in as")) {
            System.out.println("Login Verified Successfully");
        } else {
            System.out.println("Login Verification Failed");
        }
    }

    // Logout
    public void clickLogout() {
        driver.findElement(logout).click();
    }
}