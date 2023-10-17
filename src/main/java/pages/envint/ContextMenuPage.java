package pages.envint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ContextMenuPage extends BasePage {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public static final String ALERT_MSG = "You selected a context menu";

    @FindBy(css = "div#hot-spot")
    private WebElement hotSpot;

    public String getContextMenuText() {
        rightClick(hotSpot);
        return getDriver().switchTo().alert().getText();
    }

    public void closeContextMenu() {
        getDriver().switchTo().alert().accept();
    }
}
