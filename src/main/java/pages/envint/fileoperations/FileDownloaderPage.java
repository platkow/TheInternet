package pages.envint.fileoperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDownloaderPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(FileDownloaderPage.class);
    public FileDownloaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'file.txt')][1]")
    private WebElement txtFileLnk;

    String txtFilePath = "C:\\Users\\" + System.getProperty("user.name") + "\\Downloads\\text.txt";

    public void downloadTxtFile() {
        click(txtFileLnk);
    }

    public String writeInTxtFile() {
        String textToBeWritten = "Test comment";
        FileWriter fileWriter = null;


        try {
            fileWriter = new FileWriter(txtFilePath);
            fileWriter.write(textToBeWritten);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Text to be written in file: " + textToBeWritten);
        logger.info("Actual written text: " + textToBeWritten);
        return textToBeWritten;
    }

    public String readFromTxtFile() {
        String readText = "";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(txtFilePath));
            readText = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Actual text read from the file: " + readText);
        return readText;
    }
}
