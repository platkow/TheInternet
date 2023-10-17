package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    private static Logger logger = LoggerFactory.getLogger(BasePage.class);
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void click(WebElement element) {
        String elementTag = element.getTagName();
        waitForElementToBeClickable(driver, element).click();
        logger.info("######## Click on element: " + elementTag);
    }

    public void doubleClick(WebElement element) {
        String elementTag = element.getTagName();
        waitForElementToBeClickable(driver, element);
        Actions action = new Actions(driver);
        action.doubleClick(element).build().perform();
        logger.info("######## Double click on element: " + elementTag);
    }

    public void rightClick(WebElement element) {
        String elementText = element.getText();
        waitForElementToBeClickable(driver, element);
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
        logger.info("######## Right click on element: " + elementText);
    }

    public void sendKeys(WebElement element, String text) {
        String elementTag = element.getTagName();
        waitForElementToBeVisible(getDriver(), element).sendKeys(text);
        logger.info("######## Sending text: " + text + " to element: " + elementTag);
    }

    public void sendKeys(WebElement element, Keys keys) {
        String elementTag = element.getTagName();
        waitForElementToBeVisible(getDriver(), element).sendKeys(keys);
        logger.info("######## Sending : " + keys.name() + " to element: " + elementTag);
    }

    public boolean isChecked(WebElement element) {
        logger.info("######## Checking if checkbox is checked");
        boolean isChecked = false;
        try {
            String attributeValue = element.getAttribute("checked");
            if (attributeValue == null) {
                isChecked = false;
            } else if (attributeValue.equals("true")) {
                isChecked = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("######## Checkbox is checked: " + isChecked);
        return isChecked;
    }

    public void selectCbx(WebElement element) {
        logger.info("######## Selecting checkbox: " + element.getTagName() + " " + element.getText());
        if (!element.isSelected()) {
            element.click();
            boolean isSelected = element.isSelected();
            logger.info("######## Checkbox selected: " + isSelected);
        }
    }

    public String getText(WebElement element) {
        waitForElementToBeVisible(getDriver(), element);
        logger.info("######## Getting text from element: " + element.getTagName());
        String text = element.getText();
        logger.info("######## Text is: " + text);
        return text;
    }

    public void mouseHover(WebElement element) {
        String elementText = element.getText();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        logger.info("######## mouseHover perform on the object: " + elementText);
    }

    public WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        logger.info(">>>>>>>>>>>>>>>>>> Waiting for element to be visible: " + element.getText());
        Wait<WebDriver> wait;
        WebElement visibleElement;
        try {
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("fluent.webelement.timeout"))))
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

    public boolean waitForInvisibilityOfElement(WebDriver driver, WebElement element) {
        logger.info(">>>>>>>>>>>>>>>>>> Waiting for invisibility of element: " + element.getTagName());
        Wait<WebDriver> wait;
        Boolean isElementVisible;
        try {
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("fluent.webelement.timeout"))))
                    .pollingEvery(Duration.ofSeconds(Integer.parseInt(System.getProperty("pooling.every"))))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(TimeoutException.class);
            logger.info("######### Checking if element " + element.getTagName() + " " + element.getText() + " is invisible.");
            isElementVisible = wait.until(ExpectedConditions.invisibilityOf(element));
            return isElementVisible;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("######### Element is still visible.");
            return false;
        }
    }

    public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        logger.info(">>>>>>>>>>>>>>>>>> Waiting for element to be clickable: " + element.getText());
        Wait<WebDriver> wait;
        WebElement clickableElement;
        try {
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("fluent.webelement.timeout"))))
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

    public void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
        logger.info(">>>>>>>>>>>>>>>>>> Waiting for text: " + text + " to be present in element: " + element.getTagName());
        Wait<WebDriver> wait;
        boolean isTextPresent;
        try {
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(Integer.parseInt(System.getProperty("fluent.webelement.timeout"))))
                    .pollingEvery(Duration.ofSeconds(Integer.parseInt(System.getProperty("pooling.every"))))
                    .ignoring(TimeoutException.class);
            isTextPresent = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            logger.info(">>>>>>>>>>>>>>>>>> Is text present in element: " + isTextPresent);
        } catch (Exception e) {
            logger.info("Wait for text to be present in element does not work");
        }
    }
}

