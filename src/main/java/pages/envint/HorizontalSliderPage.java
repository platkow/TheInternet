package pages.envint;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class HorizontalSliderPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(HorizontalSliderPage.class);

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sliderContainer input")
    private WebElement slider;

    @FindBy(css = "span#range")
    private WebElement sliderValue;

    public double getCurrentSliderRange() {
        return Double.parseDouble(sliderValue.getText());
    }

    public double moveSliderByKeys(Double expectedSliderRange) {
        double startingSliderRange = getCurrentSliderRange();
        double movedSliderRange = 0.0;

        if (startingSliderRange < expectedSliderRange) {
            do {
                sendKeys(slider, Keys.ARROW_RIGHT);
                movedSliderRange = getCurrentSliderRange();
            } while (movedSliderRange < expectedSliderRange);
        }

        if (startingSliderRange > expectedSliderRange) {
            do {
                sendKeys(slider, Keys.ARROW_LEFT);
                movedSliderRange = getCurrentSliderRange();
            } while (movedSliderRange > expectedSliderRange);
        }

        if (startingSliderRange == expectedSliderRange) {
            logger.info("Current slider position is the same as expected. Current position: " + startingSliderRange
                    + " Expected position: " + expectedSliderRange);
        }
        return movedSliderRange;
    }
}
