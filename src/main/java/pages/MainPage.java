package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Add/Remove Elements')]")
    private WebElement addRemoveElements;

    @FindBy(xpath = "//a[contains(text(),'Checkboxes')]")
    private WebElement checkboxes;
}
