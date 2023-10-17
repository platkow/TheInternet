package tests.envint.hovers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static pages.envint.HoversPage.*;

public class HoversTest extends TestBase {
    @Test
    @Tag("ENV_INT")
    public void shouldVerifyFiguresNamesAndViewProfile() {
        mainPage.navigateHoversPage();
        String actualFigureOneName = hoversPage.getFigureOneName();
        Assertions.assertEquals(FIGURE_ONE_NAME, actualFigureOneName);

        String actualFigureTwoName = hoversPage.getFigureTwoName();
        Assertions.assertEquals(FIGURE_TWO_NAME, actualFigureTwoName);

        String actualFigureThreeName = hoversPage.getFigureThreeName();
        Assertions.assertEquals(FIGURE_THREE_NAME, actualFigureThreeName);

        boolean isDisplayed = hoversPage.viewFigureThreeProfile();
        Assertions.assertTrue(isDisplayed);
    }
}
