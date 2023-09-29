package tests.entryad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EntryAdPage;
import tests.testBase.TestBase;

public class EntryAdTest extends TestBase { //check if working
    @Test
    public void shouldVerifyClosedAndReopenedEntryAd() {
        mainPage.navigateEntryAdPage();

        entryAdPage.closeModal();
        entryAdPage.refreshPage();
        String actualTitle = entryAdPage.getModalTitle();

        Assertions.assertEquals(EntryAdPage.MODAL_TITLE, actualTitle);

        entryAdPage.closeModal();
        boolean isModalClosed = !entryAdPage.isModalDisplayed();

        Assertions.assertTrue(isModalClosed);
    }
}
