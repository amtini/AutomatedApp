package com.example;

import com.example.Test.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;

    @BeforeTest
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size-1400,800");
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }
    
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    public void test1()
    {
        Login.logInTest(driver);
        String titleOfPage = driver.findElement(By.className("ui-pdp-title")).getText();
        System.out.println(titleOfPage);
    }
    
    @Test
    public void test2()
    {
        driver.get("https://www.google.com");
        String fran = driver.findElement(By.className("gNO89b")).getText();
        System.out.println(fran);
    }
}
