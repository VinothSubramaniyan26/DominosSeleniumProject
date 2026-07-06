package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Signup Page
    By name = By.name("name");
    By email = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    // Account Information
    By title = By.id("id_gender2");
    By password = By.id("password");
    By day = By.id("days");
    By month = By.id("months");
    By year = By.id("years");
    By newsletter = By.id("newsletter");
    By offers = By.id("optin");

    // Address Information
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobile = By.id("mobile_number");
    By createAccount = By.xpath("//button[@data-qa='create-account']");

    // Signup
    public void signup(String username, String emailid) {

        driver.findElement(name).sendKeys(username);
        driver.findElement(email).sendKeys(emailid);
        driver.findElement(signupBtn).click();
    }

    // Account Information
    public void accountInformation() {

        driver.findElement(title).click();

        driver.findElement(password).sendKeys("Password@123");

        Select daySelect = new Select(driver.findElement(day));
        daySelect.selectByVisibleText("10");

        Select monthSelect = new Select(driver.findElement(month));
        monthSelect.selectByVisibleText("May");

        Select yearSelect = new Select(driver.findElement(year));
        yearSelect.selectByVisibleText("1998");

        driver.findElement(newsletter).click();

        driver.findElement(offers).click();
    }

    // Address Information
    public void addressInformation() {

        driver.findElement(firstName).sendKeys("Saranya");

        driver.findElement(lastName).sendKeys("Pandiyan");

        driver.findElement(company).sendKeys("ABC Technologies");

        driver.findElement(address1).sendKeys("123 Main Street");

        driver.findElement(address2).sendKeys("Near Bus Stand");

        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByVisibleText("India");

        driver.findElement(state).sendKeys("Tamil Nadu");

        driver.findElement(city).sendKeys("Chennai");

        driver.findElement(zipcode).sendKeys("600001");

        driver.findElement(mobile).sendKeys("9876543210");

        driver.findElement(createAccount).click();
    }

}