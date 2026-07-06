package com.dominos.tests;

import com.dominos.base.BaseClass;
import com.dominos.pages.HomePage;

public class LaunchTest extends BaseClass {

    public static void main(String[] args) {

        LaunchTest test = new LaunchTest();

        test.launchBrowser();

        HomePage home = new HomePage(driver);
        home.clickLogin();

        // test.closeBrowser();
    }
}