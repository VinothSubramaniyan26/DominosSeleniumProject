package com.dominos.test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DominosEndToEndTest {

    public static void main(String[] args) throws Exception {

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Domino's Login Page
        driver.get("https://pizzaonline.dominos.co.in/postorder-ui/login");

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Enter Mobile Number
        WebElement mobile = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input")));

        mobile.sendKeys("9626540865"); // Replace with your mobile number

        // Click Send OTP
        driver.findElement(By.xpath("//button")).click();

        System.out.println("Enter OTP Manually");

        // Wait for manual OTP entry
        Thread.sleep(30000);

        // Wait for home page to load
        Thread.sleep(10000);

        // Click Non-Veg Pizza Category
        WebElement nonVegPizza = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Non-Veg Pizza']")));

        nonVegPizza.click();

        Thread.sleep(3000);

        // Find all Add buttons
        List<WebElement> addButtons = driver.findElements(
                By.xpath("//button[contains(@class,'cta-add')]"));

        System.out.println("Total Add Buttons : " + addButtons.size());

        // Click first visible Add button
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement button : addButtons) {

            if (button.isDisplayed() && button.isEnabled()) {

                js.executeScript("arguments[0].scrollIntoView({block:'center'});", button);

                Thread.sleep(1000);

                js.executeScript("arguments[0].click();", button);

                System.out.println("Pizza Added Successfully");

                break;
            }
        }

        Thread.sleep(3000);
     // Wait for 2 seconds after adding pizza
       // Thread.sleep(2000);

        // Click View Cart
        WebElement viewCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='View Cart']")));

        viewCart.click();

        System.out.println("View Cart Clicked Successfully");

        Thread.sleep(5000);
     // Product Name
        String productName = driver.findElement(
                By.xpath("//span[text()='Chicken Maxxx - Shawarma']")).getText();

        System.out.println("Product Name : " + productName);

        // Product Price
        String productPrice = driver.findElement(
                By.xpath("//span[text()='329']")).getText();

        System.out.println("Product Price : " + productPrice);

        // Quantity
        String quantity = driver.findElement(
                By.xpath("//span[contains(@class,'item-quantity')]")).getText();

        System.out.println("Quantity : " + quantity);
        WebElement selectAddress = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class,'sel-add-btn')]")));

        selectAddress.click();

        System.out.println("Select Address Clicked Successfully");
        Thread.sleep(3000);
        //Click first Deliver Here button
        WebElement deliverHere = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//button[contains(text(),'Deliver Here')])[1]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deliverHere);

        System.out.println("Deliver Here Clicked Successfully");

        // Wait for Cart page
        Thread.sleep(5000);
     // Click Pay ₹375 button
        WebElement payButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Pay ₹')]")));

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", payButton);

        System.out.println("Pay Button Clicked Successfully");

        // Wait for Payment Page
        Thread.sleep(8000);

        // Verify Payment Page
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);

        if (url.toLowerCase().contains("payment")) {
            System.out.println("Payment Page Reached Successfully");
        } else {
            System.out.println("Payment Page Not Reached");
        }

        // Stop execution before making payment
        System.out.println("Assignment Completed Successfully");
        System.out.println("Payment Not Initiated");

      

     

        // Keep browser open
        // driver.quit();
    }
}