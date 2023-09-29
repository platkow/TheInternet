package tests.dynamicallyloadedpageelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static pages.dynamicallyloadedelements.DynamicallyLoadedPageElementsPage.HIDDEN_TEXT;

public class DynamicallyLoadedPageElementsTest extends TestBase {
    @Test
    public void shouldWaitForHiddenElement() {
        mainPage.navigateDynamicLoadingPage();
        dynamicallyLoadedPageElementsPage.navigateHiddenElementsPage();
        hiddenElementPage.clickStartBtn();
        String actualHiddenText = hiddenElementPage.getHiddenElementText();
        Assertions.assertEquals(HIDDEN_TEXT, actualHiddenText);
    }

    @Test
    public void shouldWaitForRenderedElement() {
        mainPage.navigateDynamicLoadingPage();
        dynamicallyLoadedPageElementsPage.navigateRenderedElementsPage();
        renderedElementPage.clickStartBtn();
        renderedElementPage.waitForLoadingBar();
        String actualHiddenText = renderedElementPage.getHiddenElementText();
        Assertions.assertEquals(HIDDEN_TEXT, actualHiddenText);
    }
}
