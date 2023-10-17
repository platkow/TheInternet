package pages.envtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;

public class ScrollingPage extends BasePage {
    public static final String PAGE_TITLE = "Just Scrolling Around!";
    public static final String TOP_OBJECT_TEXT = "Well done for scrolling to me!";

    public ScrollingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#main-header h1")
    private WebElement scrollingPageTitle;

    @FindBy(css = "div #zone1")
    private WebElement objectToScrollTop;

    @FindBy(css = "div #zone2")
    private WebElement objectToScrollLeft;

    @FindBy(css = "h1#zone2-entries")
    private WebElement objectToScrollLeftEntries;

    @FindBy(css = "div #zone3")
    private WebElement objectToScrollRight;

    @FindBy(css = "h1#zone3-entries")
    private WebElement objectToScrollRightEntries;

    @FindBy(css = "div #zone4")
    private WebElement objectToScrollBottom;


    public String getPageTitle() {
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        return getText(scrollingPageTitle);
    }

    public String scrollTopObjectAndGetText() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(objectToScrollTop).build().perform();
        return getText(objectToScrollTop);
    }

    public String scrollLeftObjectAndGetText() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(objectToScrollLeft).build().perform();
        return getText(objectToScrollLeftEntries);
    }

    public String scrollRightObjectAndGetText() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(objectToScrollRight).build().perform();
        return getText(objectToScrollRightEntries);
    }

    public String scrollBottomObjectAndGetText() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(objectToScrollBottom).build().perform();
        return getText(objectToScrollBottom);
    }
}
