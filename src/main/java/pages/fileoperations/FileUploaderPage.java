package pages.fileoperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FileUploaderPage extends BasePage {
    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    //to update fields
    @FindBy(css = "div.modal-title h3")
    private WebElement modalTitle;

    @FindBy(css = "div.modal-footer p")
    private WebElement close;

    @FindBy(css = ".example #restart-ad")
    private WebElement restartAdLnk;
}
