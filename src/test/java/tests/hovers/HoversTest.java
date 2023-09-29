package tests.hovers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static pages.HoversPage.*;

public class HoversTest extends TestBase {
    @Test
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
