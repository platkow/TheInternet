package tests.frames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static pages.frames.IFramePage.PAGE_TITLE;
import static pages.frames.IFramePage.TEXTAREA_CONTENT;
import static pages.frames.NestedFramesPage.*;

public class FramesTest extends TestBase {
    @Test
    public void shouldSwitchBetweenFramesAndCompareText(){
        mainPage.navigateFramesPage();
        framesPage.navigateNestedFramesPage();
        String actualLeftFrameText = nestedFramesPage.getLeftFrameText();
        Assertions.assertEquals(LEFT_FRAME, actualLeftFrameText);

        String actualMiddleFrameText = nestedFramesPage.getMiddleFrameText();
        Assertions.assertEquals(MIDDLE_FRAME, actualMiddleFrameText);

        String actualRightFrameText = nestedFramesPage.getRightFrameTxt();
        Assertions.assertEquals(RIGHT_FRAME, actualRightFrameText);

        String actualBottomFrameText = nestedFramesPage.getBottomFrameText();
        Assertions.assertEquals(BOTTOM_FRAME, actualBottomFrameText);
    }

    @Test
    public void shouldSwitchBetweenFrameContentAndChangeTextProperties(){
        mainPage.navigateFramesPage();
        framesPage.navigateIFramesPage();
        String actualPageTitle = iFramePage.getPageTitle();
        Assertions.assertEquals(PAGE_TITLE, actualPageTitle);

        String actualTextAreaContent = iFramePage.getTextareaContent();
        Assertions.assertEquals(TEXTAREA_CONTENT, actualTextAreaContent);

        iFramePage.createNewDocumentAndFill("Test comment");
        boolean isBoldPressed = iFramePage.pressBoldButton();
        Assertions.assertTrue(isBoldPressed);

        String textAreaStyle = iFramePage.changeTextColorToBlue();
        boolean isColorBlue = iFramePage.verifyTextColor(textAreaStyle);

        Assertions.assertTrue(isColorBlue);
    }
}
