package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends BasePage {
    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    private String msgPartOne = "You entered: ";

    @FindBy(css = "#target")
    private WebElement inputFld;

    @FindBy(css = "#result")
    private WebElement msg;

    public String pressKey(Keys key) {
        click(inputFld);
        sendKeys(inputFld, key);
        return key.name();
    }

    public String getMsg() {
        return msg.getText();
    }
}
