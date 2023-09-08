package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(WebListener.class);

    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info(">>>>>>>>>>> Before clicking on element: " + element.getTagName() + " " + element.getText() + " <<<<<<<<<<<");
    }
}
