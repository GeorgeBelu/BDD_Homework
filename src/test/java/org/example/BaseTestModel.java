package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestModel
{
    protected WebDriver webDriver;

    @BeforeClass
    public void driverSetup() {
        System.setProperty(
                "webdriver.chrome.driver",
                ".\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void quitSession() {
        webDriver.quit();
    }
}
