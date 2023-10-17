package tests.envint.contextmenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.envint.ContextMenuPage;
import tests.testBase.TestBase;

public class ContextMenuTest extends TestBase {
    @Test
    @Tag("ENV_INT")
    public void shouldVerifyContextMenuText() {
        mainPage.navigateContextMenuPage();
        String actualContextMenuText = contextMenuPage.getContextMenuText();
        contextMenuPage.closeContextMenu();

        Assertions.assertEquals(ContextMenuPage.ALERT_MSG, actualContextMenuText);
    }
}
