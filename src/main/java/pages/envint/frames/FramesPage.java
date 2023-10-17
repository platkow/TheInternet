package pages.envint.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FramesPage extends BasePage{
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Nested')]")
    private WebElement nestedFrameLnk;

    @FindBy(xpath = "//a[contains(text(),'iFrame')]")
    private WebElement iFrameLnk;

    public void navigateNestedFramesPage(){
        click(nestedFrameLnk);
    }

    public void navigateIFramesPage(){
        click(iFrameLnk);
    }
}
