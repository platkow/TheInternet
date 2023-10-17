package pages.envint.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public static final String LEFT_FRAME = "LEFT";
    public static final String MIDDLE_FRAME = "MIDDLE";
    public static final String RIGHT_FRAME = "RIGHT";
    public static final String BOTTOM_FRAME = "BOTTOM";

    String topFrameName = "frame-top";
    String leftFrameName = "frame-left";
    String middleFrameName = "frame-middle";
    String rightFrameName = "frame-right";
    String bottomFrameName = "frame-bottom";
    String bodyTag = "body";

    public String getLeftFrameText() {
        return getText(getDriver()
                .switchTo().frame(topFrameName)
                .switchTo().frame(leftFrameName)
                .findElement(By.tagName(bodyTag)));
    }

    public String getMiddleFrameText() {
        return getText(getDriver()
                .switchTo().defaultContent()
                .switchTo().frame(topFrameName)
                .switchTo().frame(middleFrameName)
                .findElement(By.tagName(bodyTag)));
    }

    public String getRightFrameTxt() {
        return getText(getDriver()
                .switchTo().defaultContent()
                .switchTo().frame(topFrameName)
                .switchTo().frame(rightFrameName)
                .findElement(By.tagName(bodyTag)));
    }

    public String getBottomFrameText() {
        return getText(getDriver()
                .switchTo().defaultContent()
                .switchTo().frame(bottomFrameName)
                .findElement(By.tagName(bodyTag)));
    }
}
