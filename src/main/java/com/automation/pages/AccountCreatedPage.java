package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {

    WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    By accountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public void verifyAccountCreated() {

        String text = driver.findElement(accountCreatedText).getText();

        if(text.equals("ACCOUNT CREATED!")) {
            System.out.println("Account Created Successfully");
        } else {
            System.out.println("Account Creation Failed");
        }

    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
}