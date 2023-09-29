package pages.fileoperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FileDownloaderPage extends BasePage {
    public FileDownloaderPage(WebDriver driver) {
        super(driver);
    }

    //to update fields
    @FindBy(css = "//a[contains(text(),'LambdaTest.txt')]")
    private WebElement downloadFile;

    @FindBy(css = "div.modal-footer p")
    private WebElement close;

    @FindBy(css = ".example #restart-ad")
    private WebElement restartAdLnk;

    //seek for file to download
    //download it
    //read from this file
    //write in file
    //save
    //go to upload file
    //upload modified file
    //go to download file
    //download modified file
    //verify if changes are present
    //sprawdz czy taki scenariusz jest mozliwy?
}
