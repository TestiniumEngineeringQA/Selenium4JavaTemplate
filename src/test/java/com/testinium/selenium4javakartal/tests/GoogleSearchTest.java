package com.testinium.selenium4javakartal.tests;

import com.testinium.selenium4javakartal.baseTest.BaseTest;
import com.testinium.driver.TestiniumSeleniumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void searchSelenium() {
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Dismiss cookie consent if present
        try {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
            consentButton.click();
        } catch (Exception ignored) {}

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        assertTrue(results.isDisplayed());
        assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @Test
    public void runDefaultTest2() throws MalformedURLException, InterruptedException {
        ChromeOptions options =  new ChromeOptions();
        // Testinium anahtarı gerekiyorsa Options üstünden ver:

        // İstersen browser'ı env'den oku
        //String browserName = System.getenv("browser");

        // RemoteWebDriver yerine kendi TestiniumSeleniumDriver'ını options ile başlat

        driver.get("https://www.amazon.com");
        System.out.println("Page title: " + driver.getTitle());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();


        driver.quit();
    }

    @Test
    public void runDefaultTest3() throws MalformedURLException, InterruptedException {
        ChromeOptions options =  new ChromeOptions();
        // Testinium anahtarı gerekiyorsa Options üstünden ver:

        // İstersen browser'ı env'den oku
        //String browserName = System.getenv("browser");

        // RemoteWebDriver yerine kendi TestiniumSeleniumDriver'ını options ile başlat

        driver.get("https://www.google.com");
        System.out.println("Page title: " + driver.getTitle());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();


        driver.quit();
    }

    @Test
    public void runDefaultTest4() throws MalformedURLException, InterruptedException {
        ChromeOptions options =  new ChromeOptions();
        // Testinium anahtarı gerekiyorsa Options üstünden ver:

        // İstersen browser'ı env'den oku
        //String browserName = System.getenv("browser");

        // RemoteWebDriver yerine kendi TestiniumSeleniumDriver'ını options ile başlat

        driver.get("https://www.microsoft.com");
        System.out.println("Page title: " + driver.getTitle());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();


        driver.quit();
    }

}
