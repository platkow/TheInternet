package pages.envint;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class KeyPressesPage extends BasePage {
    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    private String msgPartOne = "You entered: ";

    @FindBy(css = ".example h3")
    private WebElement pageTitle;

    @FindBy(css = "#target")
    private WebElement inputFld;

    @FindBy(css = "#result")
    private WebElement msg;

    public String pressKey(Keys key) {
        click(inputFld);
        sendKeys(inputFld, key);
        click(pageTitle);
        return key.name();
    }

    public String getMsg() {
        return getText(msg);
    }
}
