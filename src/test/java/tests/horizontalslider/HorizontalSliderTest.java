package tests.horizontalslider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

public class HorizontalSliderTest extends TestBase {
    @Test
    public void shouldMoveSliderInBothDirections() {
        mainPage.navigateHorizontalSliderPage();
        double startingSliderRange = horizontalSliderPage.getCurrentSliderRange();
        horizontalSliderPage.moveSliderByKeys(3.0);
        double middleSliderRange = horizontalSliderPage.getCurrentSliderRange();

        Assertions.assertNotEquals(startingSliderRange, middleSliderRange);

        horizontalSliderPage.moveSliderBySendingValue(1.0);
        double endingSliderRange = horizontalSliderPage.getCurrentSliderRange();

        Assertions.assertNotEquals(startingSliderRange, endingSliderRange);
    }
}
