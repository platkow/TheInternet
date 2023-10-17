package tests.envint.dynamiccontrols;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.envint.DynamicControlsPage;
import tests.testBase.TestBase;

import static pages.envint.DynamicControlsPage.ADD_MSG;
import static pages.envint.DynamicControlsPage.ENABLE_DISABLE_MSG;

public class DynamicControlsTest extends TestBase {
    @BeforeEach
    public void navigateDynamicControlsPage() {
        mainPage.navigateDynamicControlsPage();
    }
    @Test
    @Tag("ENV_INT")
    public void shouldRemoveAndAddCbx() {
        String actualRemoveMsg = dynamicControlsPage.selectCbx()
                .clickRemoveAddBtn()
                .getAddRemoveMessage();

        Assertions.assertEquals(DynamicControlsPage.REMOVE_MSG, actualRemoveMsg);
        String actualAddMsg = dynamicControlsPage.clickRemoveAddBtn().getAddRemoveMessage();
        Assertions.assertEquals(ADD_MSG, actualAddMsg);
    }

    @Test
    @Tag("ENV_INT")
    public void shouldFillEnabledFldDisableItAndVerifyText() {
        boolean isDisabled = dynamicControlsPage.isFldDisabled();
        Assertions.assertEquals(true, isDisabled);

        dynamicControlsPage.clickEnableDisableBtn();
        boolean isEnabled = dynamicControlsPage.isFldEnabled();
        Assertions.assertEquals(true, isEnabled);

        dynamicControlsPage.fillField("Test comment");

        dynamicControlsPage.clickEnableDisableBtn();
        dynamicControlsPage.waitForLoader();
        boolean isDisabledAfterFill = dynamicControlsPage.isFldDisabled();
        Assertions.assertEquals(true, isDisabledAfterFill);

        String actualMsg = dynamicControlsPage.getEnableDisableMsg();
        Assertions.assertEquals(ENABLE_DISABLE_MSG, actualMsg);
    }
}
