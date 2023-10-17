package pages.envint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class DropdownListPage extends BasePage {

    public DropdownListPage(WebDriver driver) {
        super(driver);
    }

    public static final String OPTION_TWO = "Option 2";
    @FindBy(css = ".example #dropdown")
    private WebElement dropdown;
    @FindBy(css = ".example #dropdown option")
    private List<WebElement> dropdownOptions;

    public void selectOptionEndsWithOne() {
        for (WebElement dropdownOption : dropdownOptions) {
            if (dropdownOption.getText().endsWith("1")) {
                dropdownOption.click();
                waitForTextToBePresentInElement(getDriver(), dropdown, "1");
            }
        }
    }

    public void selectOptionByValueTwo() {
        Select select = new Select(dropdown);
        select.selectByValue("2");
    }

    public String getSelectedOption() {
        String selectedOption = "";
        for (WebElement option : dropdownOptions) {
            String optAtt = option.getAttribute("selected");
            if (optAtt == null) {
                selectedOption = "";
            } else if (optAtt.equalsIgnoreCase("true")) {
                selectedOption = getText(option);
                break;
            }
        }
        return selectedOption;
    }
}
