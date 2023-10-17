package pages.envint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DynamicControlsPage extends BasePage {
    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    //Remove/add section
    public static final String REMOVE_MSG = "It's gone!";
    public static final String ADD_MSG = "It's back!";
    @FindBy(css = "div #checkbox input")
    private WebElement aCbx;

    @FindBy(css = "#checkbox-example input")
    private WebElement aCbxLabel;

    @FindBy(css = "form#checkbox-example button")
    private WebElement removeAddBtn;

    @FindBy(css = "div#loading")
    private WebElement addLoadingBar;

    @FindBy(css = "form #message")
    private WebElement addRemoveMsg;


    public DynamicControlsPage selectCbx(){
        selectCbx(aCbx);
        return new DynamicControlsPage(getDriver());
    }

    public DynamicControlsPage clickRemoveAddBtn(){
        click(removeAddBtn);
        return new DynamicControlsPage(getDriver());
    }

    public String getAddRemoveMessage(){
        waitForInvisibilityOfElement(getDriver(), addLoadingBar);
        return addRemoveMsg.getText();
    }

    //Enable/disable
    public static final String ENABLE_DISABLE_MSG = "It's disabled!";
    @FindBy(css = "form#input-example input")
    private WebElement editFld;

    @FindBy(css = "div #input-example button")
    private WebElement enableDisableBtn;

    @FindBy(css = "div #loading")
    private WebElement enableLoadingBar;

    @FindBy(css = "form#input-example #message")
    private WebElement enableDisableMsg;

    public boolean isFldDisabled(){
        return !editFld.isEnabled();
    }

    public boolean isFldEnabled(){
        waitForLoader();
        return editFld.isEnabled();
    }

    public void clickEnableDisableBtn(){
        click(enableDisableBtn);
    }
    public void fillField(String text){
        sendKeys(editFld, text);
    }

    public String getEnableDisableMsg(){
        waitForLoader();
        return enableDisableMsg.getText();
    }

    public void waitForLoader(){
        waitForInvisibilityOfElement(getDriver(), enableLoadingBar);
    }
}
