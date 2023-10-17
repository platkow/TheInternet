package pages.envint.fileoperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class FileUploaderPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(FileUploaderPage.class);

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#file-upload")
    private WebElement chooseFileBtn;

    @FindBy(css = "#file-submit")
    private WebElement uploadBtn;

    @FindBy(css = "div #drag-drop-upload")
    private WebElement uploadArea;

    public String uploadFileViaChooseFileBtn() {
        String filePath = "C:\\Projects\\TheInternet\\src\\main\\resources\\file.txt";
        String fileName = "file.txt";
        sendKeys(chooseFileBtn, filePath);
        click(uploadBtn);
        return fileName;
    }
}

