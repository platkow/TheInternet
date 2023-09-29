package tests.contextmenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;
import tests.testBase.TestBase;

public class ContextMenuTest extends TestBase {
    @Test
    public void shouldVerifyContextMenuText() {
        mainPage.navigateContextMenuPage();
        String actualContextMenuText = contextMenuPage.getContextMenuText();
        contextMenuPage.closeContextMenu();

        Assertions.assertEquals(ContextMenuPage.ALERT_MSG, actualContextMenuText);
    }
}
