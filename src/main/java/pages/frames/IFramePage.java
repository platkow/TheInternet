package pages.frames;

import org.openqa.selenium.By;
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
    String textAreaStyleSel = "#tinymce p span span";

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getTextareaContent() {
        return getDriver().switchTo().frame(iFrame).findElement(By.cssSelector(textAreaSel)).getText();
    }

    public void createNewDocumentAndFill(String text) {
        getDriver().switchTo().defaultContent();
        click(fileBtn);
        click(newDocumentBtn);
        sendKeys(getDriver().switchTo().frame(iFrame).findElement(By.cssSelector(textAreaSel)), text);
    }

    public boolean pressBoldButton() {
        getDriver().switchTo().defaultContent();
        click(boldBtn);
        String isPressed = boldBtn.getAttribute("aria-pressed");
        boolean isPressedBln = false;
        if (isPressed == "true") {
            isPressedBln = true;
        } else {
            isPressedBln = false;
        }
        return isPressedBln;
    }

    public String changeTextColorToBlue() {
        click(fileBtn);
        click(textColorBtn);
        click(blueBtn);
        return boldBtn.getAttribute("style");
    }

    public boolean verifyTextColor(String color) {
        boolean isColorBlue = false;
        String textAreaStyle = getDriver().switchTo().frame(iFrame).findElement(By.cssSelector(textAreaStyleSel)).getAttribute("style");
        if (color.contains(textAreaStyle)) {
            isColorBlue = true;
        }
        return isColorBlue;
    }
}
