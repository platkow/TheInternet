package tests.dynamiccontrols;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DynamicControlsPage;
import tests.testBase.TestBase;

public class DynamicControlsTest extends TestBase {
    @Test
    public void shouldRemoveAndAddCbx() {
        mainPage.navigateDynamicControlsPage();
        String actualRemoveMsg = dynamicControlsPage.selectCbx()
                .clickRemoveAddBtn()
                .getAddRemoveMessage();

        Assertions.assertEquals(DynamicControlsPage.REMOVE_MSG, actualRemoveMsg);
        String actualAddMsg = dynamicControlsPage.clickRemoveAddBtn().getAddRemoveMessage();
        Assertions.assertEquals(DynamicControlsPage.ADD_MSG, actualAddMsg);
    }

    @Test
    public void shouldFillEnabledFldDisableItAndVerifyText() {
        mainPage.navigateDynamicControlsPage();
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
        Assertions.assertEquals(DynamicControlsPage.ENABLE_DISABLE_MSG, actualMsg);
    }
}
