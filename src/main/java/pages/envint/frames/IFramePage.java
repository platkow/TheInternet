package pages.envint.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class IFramePage extends BasePage {
    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public static final String PAGE_TITLE = "An iFrame containing the TinyMCE WYSIWYG Editor";
    public static final String TEXTAREA_CONTENT = "Your content goes here.";

    @FindBy(css = ".example h3")
    private WebElement pageTitle;

    @FindBy(css = "#mce_0_ifr")
    private WebElement iFrame;

    @FindBy(css = "#tinymce p")
    private WebElement textArea;

    @FindBy(xpath = "//div[@class='tox-menubar']//button[1]")
    private WebElement fileBtn;

    @FindBy(xpath = "//div[@class='tox-menubar']//button[4]")
    private WebElement formatBtn;

    @FindBy(xpath = "//div[@title='New document']")
    private WebElement newDocumentBtn;

    @FindBy(xpath = "//div[@title='Text color']")
    private WebElement textColorBtn;

    @FindBy(xpath = "//button[@aria-label='Bold']")
    private WebElement boldBtn;

    @FindBy(xpath = "//div[@class='tox-swatches__row'][2]//div[@title='Blue']")
    private WebElement blueBtn;

    String textAreaSel = "#tinymce p";
    String textAreaStyleSel = "#tinymce span";

    public String getPageTitle() {
        waitForElementToBeVisible(getDriver(), pageTitle);
        return getText(pageTitle);
    }

    public String getTextareaContent() {
        return getText(getDriver().switchTo().frame(iFrame).findElement(By.cssSelector(textAreaSel)));
    }

    public void createNewDocumentAndFill(String text) {
        getDriver().switchTo().defaultContent();
        click(fileBtn);
        click(newDocumentBtn);
        sendKeys(getDriver().switchTo().frame(iFrame).findElement(By.cssSelector(textAreaSel)), text);
    }

    public boolean pressBoldButton() {
        boolean isPressedBln = false;
        getDriver().switchTo().defaultContent();
        click(boldBtn);
        String isPressed = boldBtn.getAttribute("aria-pressed");

        if(isPressed.equals("true")) {
            isPressedBln = true;
        } else {
            isPressedBln = false;
        }
        return isPressedBln;
    }

    public String changeTextColorToBlue() {
        getDriver().switchTo().defaultContent();
        click(formatBtn);
        click(textColorBtn);
        String blueBtnStyle = blueBtn.getAttribute("style");
        click(blueBtn);
        return blueBtnStyle;
    }

    public boolean verifyTextColor(String color) {
        boolean isColorBlue = false;
        String textAreaStyle = getDriver().switchTo().frame(iFrame).findElement(By.cssSelector(textAreaStyleSel)).getAttribute("style");
        if (color.contains(textAreaStyle)) {
            isColorBlue = true;
        }
        click(textArea);
        return isColorBlue;
    }

    public void highlightText() {
        textArea.sendKeys(Keys.CONTROL, "a");
    }
}
