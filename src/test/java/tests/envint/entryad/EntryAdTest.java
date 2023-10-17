package tests.envint.entryad;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static pages.envint.EntryAdPage.MODAL_TITLE;

public class EntryAdTest extends TestBase {
    @Test
    @Tag("ENV_INT")
    public void shouldVerifyClosedAndReopenedEntryAd() {
        mainPage.navigateEntryAdPage();

        entryAdPage.closeModal();
        entryAdPage.refreshPage();
        String actualTitle = entryAdPage.getModalTitle();

        assertThat(MODAL_TITLE, equalToIgnoringCase(actualTitle));

        entryAdPage.closeModal();
        boolean isModalClosed = !entryAdPage.isModalDisplayed();

        assertThat(isModalClosed, is(true));
    }
}
