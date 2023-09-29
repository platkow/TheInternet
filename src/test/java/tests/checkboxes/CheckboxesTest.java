package tests.checkboxes;

import org.junit.jupiter.api.Test;
import tests.testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckboxesTest extends TestBase {
    @Test
    public void shouldCheckFirstCbx() {
        mainPage.navigateCheckboxesPage();
        boolean isChecked = checkboxesPage.checkFirstCheckbox();

        assertThat(isChecked, equalTo(true));
    }

    @Test
    public void shouldUncheckSecondCbx() {
        mainPage.navigateCheckboxesPage();
        boolean isChecked = checkboxesPage.uncheckSecondCheckbox();

        assertThat(isChecked, equalTo(false));
    }
}
