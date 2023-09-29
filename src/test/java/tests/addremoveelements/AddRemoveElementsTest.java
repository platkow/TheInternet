package tests.addremoveelements;

import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddRemoveElementsTest extends TestBase {
    @Test
    public void shouldCheckAddedElements() {
        mainPage.navigateAddRemoveElementsPage();
        int expectedElementsToBeAddedCount = addRemovePage.addRandomCountOfElements(5);
        int actualElementsCount = addRemovePage.countElements();

        assertThat(expectedElementsToBeAddedCount, equalTo(actualElementsCount));
    }

    @Test
    public void shouldCountElementsAfterDelete() {
        mainPage.navigateAddRemoveElementsPage();

        if (addRemovePage.countElements() == 0) {
            addRemovePage.addSixElements();
        }

        int elementsCountBeforeRemove = addRemovePage.countElements();
        int removedElementsCount = addRemovePage.deleteRandomCountOfElements();

        int expectedElementsLeftCount = elementsCountBeforeRemove - removedElementsCount;
        int actualElementsLeftCount = addRemovePage.countElements();

        assertThat(expectedElementsLeftCount, equalTo(actualElementsLeftCount));
    }
}
