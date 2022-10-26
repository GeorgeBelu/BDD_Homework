package org.example.factory;

import org.example.properties.converters.SupportedBrowserConverter;
import org.example.properties.holder.PropertyHolder;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory
{
    public WebDriver getWebDriver() {
//        String propertyValue = new PropertyHolder().readProperty("browser");
//        SupportedBrowsers browser = SupportedBrowserConverter.valueOfWebBrowser(propertyValue);
//
//        return browser.getWebDriver();
        return SupportedBrowserConverter.valueOfWebBrowser(
                new PropertyHolder().readProperty("browser"))
                .getWebDriver();
    }
}
