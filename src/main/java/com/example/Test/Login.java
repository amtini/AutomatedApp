package com.example.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
    
    @Test
    public static void logInTest(WebDriver driver){
        
        String url = "https://www.mercadolibre.com.ar/";
        
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cb1-edit']")));

        driver.findElement(By.xpath("//*[@id='cb1-edit']")).sendKeys("barbijos");
        driver.findElement(By.xpath("//*[@id='cb1-edit']")).sendKeys(Keys.ENTER);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("andes-dropdown__display-values")));

        driver.findElement(By.className("andes-dropdown__display-values")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='andes-dropdown-más-relevantes-list-option-price_asc']")));

        driver.findElement(By.xpath("//*[@id='andes-dropdown-más-relevantes-list-option-price_asc']")).click();;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-search-item__title")));

        driver.findElement(By.className("ui-search-item__title")).click();
        
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[4]/div/div[1]/div/div[1]/div")));

        String expectedConfirmationMessage = "50";

        String actualConfirmationMessage = driver.findElement(By.className("andes-money-amount__fraction")).getText();

        Assert.assertTrue(actualConfirmationMessage.equals(expectedConfirmationMessage), "Expected value is different from actual Value \n Expected Value: " + expectedConfirmationMessage + " \n Actual Value: " + actualConfirmationMessage);
    }
}