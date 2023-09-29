package pages.frames;

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

    public NestedFramesPage navigateNestedFramesPage(){
        click(nestedFrameLnk);
        return new NestedFramesPage(getDriver());
    }

    public IFramePage navigateIFramesPage(){
        click(iFrameLnk);
        return new IFramePage(getDriver());
    }
}
