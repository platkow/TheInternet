package tests.keypresses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.testBase.TestBase;

import static org.openqa.selenium.Keys.*;

public class KeyPressesTest extends TestBase {
    @Test
    @DisplayName("Press RIGHT, ENTER, TAB")
    @ParameterizedTest
    @ValueSource(strings = {})
    public void shouldPressKeysSequence() {//zobaczy czy tego nie da się jednak przerobić
        mainPage.navigateKeyPresses();
        String arrowRight = keyPressesPage.pressKey(RIGHT);
        String msgOne = keyPressesPage.getMsg();

        Assertions.assertTrue(msgOne.contains(arrowRight));

        String enter = keyPressesPage.pressKey(ENTER);
        String msgTwo = keyPressesPage.getMsg();

        Assertions.assertTrue(enter.contains(msgTwo));

        String tab = keyPressesPage.pressKey(TAB);
        String msgThree = keyPressesPage.getMsg();

        Assertions.assertTrue(msgThree.contains(tab));
    }
}
