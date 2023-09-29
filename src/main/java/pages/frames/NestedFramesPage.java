package pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }
    public static final String LEFT_FRAME = "LEFT";
    public static final String MIDDLE_FRAME = "MIDDLE";
    public static final String RIGHT_FRAME = "RIGHT";
    public static final String BOTTOM_FRAME = "BOTTOM";
    @FindBy(xpath = "//frame[@name='frame-left']")
    private WebElement leftFrame;

    @FindBy(xpath = "//frame[@name='frame-middle']")
    private WebElement middleFrame;

    @FindBy(xpath = "//frame[@name='frame-right']")
    private WebElement rightFrame;

    @FindBy(xpath = "//frame[@name='frame-bottom']")
    private WebElement bottomFrame;

    String bodyTag = "body";

    public String getLeftFrameText(){
        return getDriver().switchTo().frame(leftFrame).findElement(By.tagName(bodyTag)).getText();
    }

    public String getMiddleFrameText(){
        return getDriver().switchTo().frame(middleFrame).findElement(By.tagName(bodyTag)).getText();
    }

    public String getRightFrameTxt(){
        return getDriver().switchTo().frame(rightFrame).findElement(By.tagName(bodyTag)).getText();
    }

    public String getBottomFrameText(){
        return getDriver().switchTo().frame(bottomFrame).findElement(By.tagName(bodyTag)).getText();
    }
}
