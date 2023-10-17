package tests.envint.dropdownlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.envint.DropdownListPage;
import tests.testBase.TestBase;

public class DropdownListTest extends TestBase {
    @BeforeEach
    public void navigateDropdownPage() {
        mainPage.navigateDropdownPage();
    }
    @Test
    @Tag("ENV_INT")
    public void shouldSelectOptionEndsWithOne() {
        dropdownListPage.selectOptionEndsWithOne();
        String selectedOption = dropdownListPage.getSelectedOption();
        int lastCharIndex = selectedOption.length() - 1;
        Character selectedOptionLastCharacter = selectedOption.charAt(lastCharIndex);
        Assertions.assertEquals('1', selectedOptionLastCharacter);
    }

    @Test
    @Tag("ENV_INT")
    public void shouldSelectOptionByValueTwo() {
        dropdownListPage.selectOptionByValueTwo();
        String selectedOptionValue = dropdownListPage.getSelectedOption();
        Assertions.assertEquals(DropdownListPage.OPTION_TWO, selectedOptionValue);
    }
}
