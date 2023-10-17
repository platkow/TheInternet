package tests.envint.horizontalslider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

public class HorizontalSliderTest extends TestBase {
    @Test
    @Tag("ENV_INT")
    public void shouldMoveSliderInBothDirections() {
        double expMoveSliderRightValue = 3.0;
        double expMoveSliderLeftValue = 0.5;
        double expSliderNotMovedValue = 0.5;

        mainPage.navigateHorizontalSliderPage();
        horizontalSliderPage.moveSliderByKeys(expMoveSliderRightValue);
        double movedRightSliderRange = horizontalSliderPage.getCurrentSliderRange();

        Assertions.assertTrue(expMoveSliderRightValue == movedRightSliderRange);

        horizontalSliderPage.moveSliderByKeys(expMoveSliderLeftValue);
        double movedLeftSliderRange = horizontalSliderPage.getCurrentSliderRange();

        Assertions.assertTrue(expMoveSliderLeftValue == movedLeftSliderRange);

        horizontalSliderPage.moveSliderByKeys(expSliderNotMovedValue);
        double sliderNotMovedRange = horizontalSliderPage.getCurrentSliderRange();
        Assertions.assertTrue(expMoveSliderLeftValue == sliderNotMovedRange);
    }
}
