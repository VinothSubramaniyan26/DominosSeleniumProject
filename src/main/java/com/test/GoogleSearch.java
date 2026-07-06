package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium");

        Thread.sleep(2000);

        driver.quit();
    }
}