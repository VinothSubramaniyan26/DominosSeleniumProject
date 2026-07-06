package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By loginEmail = By.xpath("//input[@data-qa='login-email']");
    By loginPassword = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");

    // Login Method
    public void login(String email, String password) {

        driver.findElement(loginEmail).sendKeys(email);

        driver.findElement(loginPassword).sendKeys(password);

        driver.findElement(loginBtn).click();
    }

}