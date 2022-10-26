package org.example.enumeration;

import org.example.invoker.WebDriverInvoker;
import org.example.invoker.implementation.LocalChromeInvoker;
import org.example.invoker.implementation.LocalFirefoxInvoker;
import org.example.invoker.implementation.RemoteChromeInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers
{
    LOCAL_CHROME(new LocalChromeInvoker()),
    LOCAL_FIREFOX(new LocalFirefoxInvoker()),
    REMOTE_CHROME(new RemoteChromeInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver(){
        return webDriverInvoker.invokeWebDriver();
    }
}
