package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    private static Logger logger = LoggerFactory.getLogger(BasePage.class);
    private WebDriver driver;
    private EventFiringMouse eventFiringMouse;
    protected WebListener listener;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void click(WebElement element) {
        waitForElementToBeClickable(getDriver(), element).click();
    }

    public void sendKeys(WebElement element, String text) {
        logger.info("######## Sending text: " + text + " to element: " + element.getTagName());
        waitForElementToBeVisible(getDriver(), element).sendKeys(text);
    }

    public boolean isChecked(WebElement element){
        boolean isChecked = false;
        try{
            String attributeValue = element.getAttribute("checked");
            if(attributeValue == null){
                isChecked = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return isChecked;
    }

    public void selectCbx(WebElement element) {
        logger.info("######## Mark checkbox: " + element.getTagName() + " " + element.getText());
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void mouseHover(WebElement element) {
        logger.info("######## mouseHover perform on the object: " + element.getText());
        eventFiringMouse = new EventFiringMouse(driver, listener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
    }

    public WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait;
        WebElement visibleElement;
        try {
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("fluent.webelement.timout"))))
                    .pollingEvery(Duration.ofSeconds(Integer.parseInt(System.getProperty("pooling.every"))))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(TimeoutException.class);
            logger.info("######### Checking if element " + element.getTagName() + " " + element.getText() + " is visible.");
            visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            return visibleElement;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("######### Element is not visible.");
            return null;
        }
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait;
        WebElement clickableElement;
        try {
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("fluent.webelement.timout"))))
                    .pollingEvery(Duration.ofSeconds(Integer.parseInt(System.getProperty("pooling.every"))))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(TimeoutException.class);
            logger.info("######### Checking if element " + element.getTagName() + " " + element.getText() + " is clickable.");
            clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            return clickableElement;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("######### Element is not clickable.");
            return null;
        }
    }

    public void waitForLoadedPage(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(System.getProperty("explicit.webelement.timout")));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Explicit wait for element: " + element.getText() + " " + element.getTagName() + " works.");
        } catch (Exception e) {
            logger.info("Explicit wait for element dose not work");
        }
    }
}
