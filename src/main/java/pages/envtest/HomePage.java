package pages.envtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#scrolling-around")
    private WebElement scrollingAroundLnk;

    public void navigateScrollingAround(){
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(scrollingAroundLnk).perform();
        click(scrollingAroundLnk);
    }
}
