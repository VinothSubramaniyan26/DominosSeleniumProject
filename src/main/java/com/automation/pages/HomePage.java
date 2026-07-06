package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By signupLogin = By.xpath("//a[@href='/login']");

    public void clickSignupLogin() {
        driver.findElement(signupLogin).click();
    }
}
