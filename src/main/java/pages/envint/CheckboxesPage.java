package pages.envint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CheckboxesPage extends BasePage {
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form//input[1]")
    private WebElement firstCheckbox;

    @FindBy(xpath = "//form//input[2]")
    private WebElement secondCheckbox;


    public boolean checkFirstCheckbox() {
        boolean isChecked = isChecked(firstCheckbox);

        if (!isChecked) {
            click(firstCheckbox);
        }
        return isChecked(firstCheckbox);
    }

    public boolean uncheckSecondCheckbox() {
        boolean isChecked = isChecked(secondCheckbox);

        if (isChecked) {
            click(secondCheckbox);
        }
        return isChecked(secondCheckbox);
    }
}
