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

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://pizzaonline.dominos.co.in/postorder-ui/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Enter Mobile Number
        WebElement mobile = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input")));

        mobile.sendKeys("9884579188"); 

        driver.findElement(By.xpath("//button")).click();

        System.out.println("Enter OTP Manually");

        Thread.sleep(30000);

        Thread.sleep(10000);

        WebElement nonVegPizza = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Non-Veg Pizza']")));

        nonVegPizza.click();

        Thread.sleep(3000);

        List<WebElement> addButtons = driver.findElements(
                By.xpath("//button[contains(@class,'cta-add')]"));

        System.out.println("Total Add Buttons : " + addButtons.size());

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

        WebElement viewCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='View Cart']")));

        viewCart.click();

        System.out.println("View Cart Clicked Successfully");

        Thread.sleep(5000);
        String productName = driver.findElement(
                By.xpath("//span[text()='Chicken Maxxx - Shawarma']")).getText();

        System.out.println("Product Name : " + productName);

        String productPrice = driver.findElement(
                By.xpath("//span[text()='329']")).getText();

        System.out.println("Product Price : " + productPrice);

        String quantity = driver.findElement(
                By.xpath("//span[contains(@class,'item-quantity')]")).getText();

        System.out.println("Quantity : " + quantity);
        WebElement selectAddress = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class,'sel-add-btn')]")));

        selectAddress.click();

        System.out.println("Select Address Clicked Successfully");
        Thread.sleep(3000);
        WebElement deliverHere = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//button[contains(text(),'Deliver Here')])[1]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deliverHere);

        System.out.println("Deliver Here Clicked Successfully");

        Thread.sleep(5000);

        WebElement payButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='bottomBarSectionModule']/div/div[2]/div/div[1]/div")
            )
        );

        System.out.println(payButton.isDisplayed());
        System.out.println(payButton.isEnabled());

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", payButton);

        System.out.println("Pay Button Clicked Successfully");

        Thread.sleep(8000);

        WebElement upiLabel = wait.until(
        	    ExpectedConditions.elementToBeClickable(
        	        By.xpath("//label[@for='Pay-by-any-UPI-App-0']")
        	    )
        	);

        	((JavascriptExecutor)driver).executeScript("arguments[0].click();", upiLabel);

        	System.out.println("UPI Selected Successfully");

        	Thread.sleep(3000);

     
        WebElement placeOrder = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'Place Order')]")
            )
        );

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", placeOrder);

        System.out.println("Place Order Clicked");

       
        System.out.println("Assignment Completed Successfully");
        System.out.println("Payment Not Initiated");

      
    

        
    }
}