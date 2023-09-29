package pages.dynamicallyloadedelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HiddenElementPage extends BasePage {
    public HiddenElementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div #start button")
    private WebElement startBtn;
    @FindBy(css = "div #loading")
    private WebElement loadingBar;
    @FindBy(css = "div #finish")
    private WebElement hiddenElement;

    public void clickStartBtn() {
        click(startBtn);
    }

    public String getHiddenElementText() {
        waitForInvisibilityOfElement(getDriver(), loadingBar);
        return getText(hiddenElement);
    }
}
