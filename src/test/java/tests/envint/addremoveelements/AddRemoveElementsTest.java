package tests.envint.addremoveelements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddRemoveElementsTest extends TestBase {
    @BeforeEach
    public void navigateAddRemoveElementsPage() {
        mainPage.navigateAddRemoveElementsPage();
    }

    @Test
    @Tag("ENV_INT")
    public void shouldCheckAddedElements() {
        int expectedElementsToBeAddedCount = addRemovePage.addRandomCountOfElements(5);
        int actualElementsCount = addRemovePage.countElements();

        assertThat(expectedElementsToBeAddedCount, equalTo(actualElementsCount));
    }

    @Test
    @Tag("ENV_INT")
    public void shouldCountElementsAfterDelete() {
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
