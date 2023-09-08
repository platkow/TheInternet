package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.WebListener;

public class BrowserEnvironment {
    private String browserName = "chrome";
    private int webElementTimeOut;
    private int webBrowserImplicitTimeOut;
    private boolean attachScreenshot;
    private boolean headlessBrowser;
    private Logger logger;
    private WebDriver webDriver;
    private WebListener webListener;
    private EventFiringWebDriver driver;

    public BrowserEnvironment() {
        this.headlessBrowser = false;
        this.webElementTimeOut = 10;
        this.webBrowserImplicitTimeOut = 20;
        this.attachScreenshot = true;
        logger = LoggerFactory.getLogger("BrowserEnvironment.class");
        this.browserName = PropertyStore.BROWSER.isSpecified() ? PropertyStore.BROWSER.getPropertyValue() : this.browserName;
        this.intBrowserSettings();
    }

    private void intBrowserSettings() {
        this.webElementTimeOut = PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue() : this.webElementTimeOut;
        this.webBrowserImplicitTimeOut = PropertyStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.webBrowserImplicitTimeOut;
        this.attachScreenshot = PropertyStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertyStore.BROWSER_ATTACH_SCREENSHOT.getBoolean() : this.attachScreenshot;
        this.headlessBrowser = PropertyStore.BROWSER_HEADLESS.isSpecified() ? PropertyStore.BROWSER_HEADLESS.getBoolean() : this.headlessBrowser;
    }

    public WebDriver getDriver() {
        EventFiringWebDriver driver;

        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("Start-maximized");
                webDriver = new ChromeDriver(optionsChrome);
                driver = new EventFiringWebDriver(webDriver);
                webListener = new WebListener();
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("Start-maximized");
                webDriver = new FirefoxDriver(optionsFirefox);
                driver = new EventFiringWebDriver(webDriver);
                webListener = new WebListener();
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
                break;
            default:
                InternetExplorerOptions optionsIE = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver(optionsIE);
                driver = new EventFiringWebDriver(webDriver);
                webListener = new WebListener();
                driver.register(webListener);
                driver.get(System.getProperty("appUrl"));
        }
        this.driver = driver;
        return this.driver;
    }

    public String getBrowserName() {
        return browserName;
    }

    public int getWebElementTimeOut() {
        return webElementTimeOut;
    }

    public int getWebBrowserImplicitTimeOut() {
        return webBrowserImplicitTimeOut;
    }

    public boolean isAttachScreenshot() {
        return attachScreenshot;
    }

    public boolean isHeadlessBrowser() {
        return headlessBrowser;
    }

    public Logger getLogger() {
        return logger;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebListener getWebListener() {
        return webListener;
    }
}
