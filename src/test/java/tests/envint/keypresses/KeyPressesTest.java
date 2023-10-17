package tests.envint.keypresses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.Keys;
import tests.testBase.TestBase;

public class KeyPressesTest extends TestBase {
    @BeforeEach
    public void navigateKeyPressesPage() {
        mainPage.navigateKeyPresses();
    }
    @Tag("ENV_INT")
    @ParameterizedTest
    @EnumSource(value = Keys.class, names = {"RIGHT", "TAB"})
    public void shouldPressKeysSequence(Keys keys) {

        String arrowRight = keyPressesPage.pressKey(keys);
        String msgOne = keyPressesPage.getMsg();
        Assertions.assertTrue(msgOne.contains(arrowRight));
    }
}
