package tests.dropdownlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DropdownListPage;
import tests.testBase.TestBase;

public class DropdownListTest extends TestBase {
    @Test
    public void shouldSelectOptionEndsWithOne() {
        mainPage.navigateDropdownPage();
        dropdownListPage.selectOptionEndsWithOne();
        String selectedOption = dropdownListPage.getSelectedOption();
        int lastCharIndex = selectedOption.length() - 1;
        Character selectedOptionLastCharacter = selectedOption.charAt(lastCharIndex);
        Assertions.assertEquals('1', selectedOptionLastCharacter);
    }

    @Test
    public void shouldSelectOptionByValueTwo() {
        mainPage.navigateDropdownPage();
        dropdownListPage.selectOptionEndsWithOne();
        dropdownListPage.selectOptionByValueTwo();
        String selectedOptionValue = dropdownListPage.getSelectedOption();
        Assertions.assertEquals(DropdownListPage.OPTION_TWO, selectedOptionValue);
    }
}
