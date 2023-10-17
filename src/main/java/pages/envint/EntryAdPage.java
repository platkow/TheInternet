package pages.envint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class EntryAdPage extends BasePage {
    public EntryAdPage(WebDriver driver) {
        super(driver);
    }

    public static final String MODAL_TITLE = "This is a modal window";

    @FindBy(css = "div.modal-title h3")
    private WebElement modalTitle;

    @FindBy(css = "div.modal-footer p")
    private WebElement close;

    @FindBy(css = ".example #restart-ad")
    private WebElement restartAdLnk;

    public String getModalTitle(){
        waitForElementToBeVisible(getDriver(), modalTitle);
        return getText(modalTitle);
    }

    public void closeModal(){
        click(close);
    }

    public void refreshPage(){
        getDriver().navigate().refresh();
    }

    public boolean isModalDisplayed(){
        return modalTitle.isDisplayed();
    }
}
