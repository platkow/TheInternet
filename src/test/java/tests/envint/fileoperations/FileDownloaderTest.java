package tests.envint.fileoperations;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class FileDownloaderTest extends TestBase {
    @Test
    @Tag("ENV_INT")
    public void shouldDownloadFileWritAndReadFromIt() {
        mainPage.navigateFileDownloaderPage();
        fileDownloaderPage.downloadTxtFile();
        String expectedTextToWrite = fileDownloaderPage.writeInTxtFile();
        String actualTextWritten = fileDownloaderPage.readFromTxtFile();

        assertThat(actualTextWritten, containsString(expectedTextToWrite));
    }
}
