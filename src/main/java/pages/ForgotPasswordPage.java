package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#forgot_password input")
    private WebElement emailInput;

    @FindBy(css = "#form_submit")
    private WebElement retrievePasswordBtn;

    @FindBy(css = ".example #restart-ad")
    private WebElement restartAdLnk;

    public void fillEmail(String email){
        sendKeys(emailInput, email);
    }

    public void clickRetrievePassword(){
        click(retrievePasswordBtn);
    }

    //vpn on - finish when off
}
