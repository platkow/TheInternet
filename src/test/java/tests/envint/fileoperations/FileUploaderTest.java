package tests.envint.fileoperations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static pages.envint.fileoperations.FileUploadedPage.FILE_UPLOADED_PAGE_TITLE;

public class FileUploaderTest extends TestBase {
    @Test
    @Tag("ENV_INT")
    public void shouldUploadFile(){
        mainPage.navigateFileUploaderPage();
        String uploadedFileName = fileUploaderPage.uploadFileViaChooseFileBtn();
        String actualFileUploadedPageTitle = fileUploadedPage.getFileUploadedPageTitle();
        String actualUploadedFileName = fileUploadedPage.getUploadedFileName();

        Assertions.assertEquals(actualFileUploadedPageTitle, FILE_UPLOADED_PAGE_TITLE);
        Assertions.assertEquals(actualUploadedFileName, uploadedFileName);

    }
}
