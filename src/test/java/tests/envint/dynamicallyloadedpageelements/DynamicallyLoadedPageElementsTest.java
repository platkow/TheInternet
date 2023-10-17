package tests.envint.dynamicallyloadedpageelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static pages.envint.dynamicallyloadedelements.DynamicallyLoadedPageElementsPage.HIDDEN_TEXT;

public class DynamicallyLoadedPageElementsTest extends TestBase {
    @BeforeEach
    public void navigateDynamicLoadingPage() {
        mainPage.navigateDynamicLoadingPage();
    }
    @Test
    @Tag("ENV_INT")
    public void shouldWaitForHiddenElement() {
        dynamicallyLoadedPageElementsPage.navigateHiddenElementsPage();
        hiddenElementPage.clickStartBtn();
        String actualHiddenText = hiddenElementPage.getHiddenElementText();
        Assertions.assertEquals(HIDDEN_TEXT, actualHiddenText);
    }

    @Test
    @Tag("ENV_INT")
    public void shouldWaitForRenderedElement() {
        dynamicallyLoadedPageElementsPage.navigateRenderedElementsPage();
        renderedElementPage.clickStartBtn();
        renderedElementPage.waitForLoadingBar();
        String actualHiddenText = renderedElementPage.getHiddenElementText();
        Assertions.assertEquals(HIDDEN_TEXT, actualHiddenText);
    }
}
