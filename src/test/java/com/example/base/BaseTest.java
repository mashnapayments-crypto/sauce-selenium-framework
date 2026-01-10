package com.example.base;

import com.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        boolean headless = ConfigReader.getBoolean("headless");
        int wait = ConfigReader.getInt("implicitWait", 10);
        driver = WebDriverFactory.createChromeDriver(headless, wait);
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
