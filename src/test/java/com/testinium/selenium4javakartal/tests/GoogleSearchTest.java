package com.testinium.selenium4javakartal.tests;

import com.testinium.selenium4javakartal.baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void runDefaultTest2() {
        driver.get("https://www.amazon.com");
        System.out.println("Page title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
        searchButton.click();
    }

    @Test
    public void runDefaultTest3() {
        driver.get("https://www.google.com");
        System.out.println("Page title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        assertTrue(searchBox.isDisplayed());
    }

    @Test
    public void runDefaultTest4() {
        driver.get("https://www.microsoft.com");
        System.out.println("Page title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.titleContains("Microsoft")));
    }

}
