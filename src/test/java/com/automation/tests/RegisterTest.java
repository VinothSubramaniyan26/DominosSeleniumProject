package com.automation.tests;

import com.automation.base.BaseClass;
import com.automation.pages.HomePage;
import com.automation.pages.SignupPage;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.LoginPage;
import com.automation.pages.LoggedInPage;

public class RegisterTest extends BaseClass {

    public static void main(String[] args) {

        RegisterTest test = new RegisterTest();

        test.launchBrowser();

        HomePage home = new HomePage(driver);
        home.clickSignupLogin();

        SignupPage signup = new SignupPage(driver);

        // Use a new email each time you run
        signup.signup("Saranya", "Vinoth005@gmail.com");

        signup.accountInformation();

        signup.addressInformation();
        AccountCreatedPage account = new AccountCreatedPage(driver);

        account.verifyAccountCreated();

        account.clickContinue();
        LoggedInPage logged = new LoggedInPage(driver);

        logged.verifyLogin();

        logged.clickLogout();

    }

}