package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAdPage extends BasePage{
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
        return modalTitle.getText();
    }

    public void closeModal(){
        click(close);
    }

    public boolean verifyIfModalIsClosed(){
       return !modalTitle.isDisplayed();
    }

    public void refreshPage(){
        getDriver().navigate().refresh();
    }

    public boolean isModalDisplayed(){
        return modalTitle.isDisplayed();
    }


    //get modal title
    //verify is is as expected
    //close
    //verify if closed
    //refresh page

    //verify id modal is displayed
}
