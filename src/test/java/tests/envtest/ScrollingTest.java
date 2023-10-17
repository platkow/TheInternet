package tests.envtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static pages.envtest.ScrollingPage.PAGE_TITLE;
import static pages.envtest.ScrollingPage.TOP_OBJECT_TEXT;

public class ScrollingTest extends TestBase {
    @Test
    @Tag("ENV_TEST")
    @Disabled
    public void shouldScrollBetweenElementsAndVerifyContent() {
        homePage.navigateScrollingAround();
        String actualPageTitle = scrollingPage.getPageTitle();
        Assertions.assertEquals(PAGE_TITLE, actualPageTitle);

        String actualTopObjectText = scrollingPage.scrollTopObjectAndGetText();
        Assertions.assertEquals(TOP_OBJECT_TEXT, actualTopObjectText);

        String entries = "Entries";
        String actualLeftObjectText = scrollingPage.scrollLeftObjectAndGetText();
        assertThat(actualLeftObjectText, containsString(entries));

        String actualRightObjectText = scrollingPage.scrollRightObjectAndGetText();
        assertThat(actualRightObjectText, containsString(entries));

        String y = "Y";
        String actualBottomObjectText = scrollingPage.scrollBottomObjectAndGetText();
        assertThat(actualBottomObjectText, containsString(y));
    }
}
