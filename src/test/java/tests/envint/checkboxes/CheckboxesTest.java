package tests.envint.checkboxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

public class CheckboxesTest extends TestBase {
    @BeforeEach
    public void navigateCheckboxesPage() {
        mainPage.navigateCheckboxesPage();
    }

    @Test
    @Tag("ENV_INT")
    public void shouldCheckFirstCbx() {
        boolean isChecked = checkboxesPage.checkFirstCheckbox();

        Assertions.assertTrue(isChecked);
    }

    @Test
    @Tag("ENV_INT")
    public void shouldUncheckSecondCbx() {
        boolean isChecked = checkboxesPage.uncheckSecondCheckbox();

        Assertions.assertFalse(isChecked);
    }
}
