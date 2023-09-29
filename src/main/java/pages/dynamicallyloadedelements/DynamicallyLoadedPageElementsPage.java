package pages.dynamicallyloadedelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DynamicallyLoadedPageElementsPage extends BasePage {
    public DynamicallyLoadedPageElementsPage(WebDriver driver) {
        super(driver);
    }

    public static final String HIDDEN_TEXT = "Hello World!";

    @FindBy(xpath = "//a[contains(text(),'Example 1')]")
    private WebElement hiddenElementLnk;
    @FindBy(xpath = "//a[contains(text(),'Example 2')]")
    private WebElement renderedElementLnk;

    public void navigateHiddenElementsPage(){
        click(hiddenElementLnk);
    }
    public void navigateRenderedElementsPage(){
        click(renderedElementLnk);
    }
}
