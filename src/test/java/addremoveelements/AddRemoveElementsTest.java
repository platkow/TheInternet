package addremoveelements;

import org.junit.jupiter.api.Test;
import pages.AddRemoveElementsPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AddRemoveElementsTest extends TestBase {
    @Test
    public void shouldCheckAddedElements(){
        AddRemoveElementsPage addRemove = new AddRemoveElementsPage(driver);
        int expectedElementsToBeAddedCount = addRemove.addRandomCountOfElements(5);
        int actualElementsCount = addRemove.countElements();

        assertThat(expectedElementsToBeAddedCount, equalTo(actualElementsCount));
    }

    @Test
    public void shouldCountElementsAfterDelete(){
        AddRemoveElementsPage addRemove = new AddRemoveElementsPage(driver);

        if(addRemove.countElements() == 0){
           addRemove.addSixElements();
        }

        int elementsCountBeforeRemove = addRemove.countElements();
        int removedElementsCount = addRemove.deleteRandomCountOfElements();

        int expectedElementsLeftCount = elementsCountBeforeRemove - removedElementsCount;
        int actualElementsLeftCount = addRemove.countElements();

        assertThat(expectedElementsLeftCount, equalTo(actualElementsLeftCount));
        
    }
}
