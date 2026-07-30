package com.testinium.selenium4javakartal.baseTest;

import com.testinium.driver.TestiniumSeleniumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected static RemoteWebDriver driver;

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");

        String remoteUrl = Stream.of(
                        System.getProperty("selenium.remote.url"),
                        System.getProperty("hubUrl"),
                        System.getenv("SELENIUM_REMOTE_URL"),
                        System.getenv("HUB_URL")
                )
                .filter(value -> value != null && !value.isBlank())
                .findFirst()
                .orElse("http://localhost:4444/wd/hub");

        driver = new TestiniumSeleniumDriver(new URL(remoteUrl), options);
    }

    @AfterAll
    protected static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
