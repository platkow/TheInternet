package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage{ //check if working
    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    //Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left.
    //Or click and drag the slider with your mouse. It will indicate the value of the slider to the right.

    @FindBy(css = ".sliderContainer input")
    private WebElement slider;

    @FindBy(css = "span#range")
    private WebElement sliderValue;

    public double getCurrentSliderRange(){
        return Double.parseDouble(sliderValue.getText());
    }

    public double moveSliderByKeys(Double expectedSliderRange){
        double currentRange = getCurrentSliderRange();

        if(currentRange < expectedSliderRange){
            do {
                sendKeys(slider, Keys.ENTER);
            } while (currentRange == expectedSliderRange);
        }

        if(currentRange > expectedSliderRange){
            do {
                sendKeys(slider, Keys.ARROW_LEFT);
            } while (currentRange == expectedSliderRange);
        }

        if (currentRange == expectedSliderRange){
            System.out.println("Current slider position is the same as expected");
        }
        return currentRange;
    }

    public void moveSliderBySendingValue(Double expectedSliderRange){
        sendKeys(slider, String.valueOf(expectedSliderRange));
    }
}
