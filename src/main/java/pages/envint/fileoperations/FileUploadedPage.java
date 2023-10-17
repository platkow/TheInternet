package pages.envint.fileoperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FileUploadedPage extends BasePage {
    public FileUploadedPage(WebDriver driver) {
        super(driver);
    }

    public static final String FILE_UPLOADED_PAGE_TITLE = "File Uploaded!";

    @FindBy(css = "#content h3")
    private WebElement pageTitle;

    @FindBy(css = "#uploaded-files")
    private WebElement uploadedFileName;

    public String getFileUploadedPageTitle(){
        waitForElementToBeVisible(getDriver(), pageTitle);
       return getText(pageTitle);
    }

    public String getUploadedFileName(){
        return getText(uploadedFileName);
    }

}
