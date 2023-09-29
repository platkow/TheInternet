package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Add/Remove Elements')]")
    private WebElement addRemoveElements;
    @FindBy(xpath = "//a[contains(text(),'Checkboxes')]")
    private WebElement checkboxes;
    @FindBy(xpath = "//a[contains(text(),'Context Menu')]")
    private WebElement contextMenu;
    @FindBy(xpath = "//a[contains(text(),'Dropdown')]")
    private WebElement dropdown;
    @FindBy(xpath = "//a[contains(text(),'Dynamic Loading')]")
    private WebElement dynamicLoading;
    @FindBy(xpath = "//a[contains(text(),'Dynamic Controls')]")
    private WebElement dynamicControls;
    @FindBy(xpath = "//a[contains(text(),'Entry Ad')]")
    private WebElement entryAd;
    @FindBy(xpath = "//a[contains(text(),'File Download')]")
    private WebElement fileDownload;
    @FindBy(xpath = "//a[contains(text(),'File Upload')]")
    private WebElement fileUpload;
    @FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
    private WebElement forgotPassword;
    @FindBy(xpath = "//a[contains(text(),'Frames')]")
    private WebElement frames;
    @FindBy(xpath = "//a[contains(text(),'Horizontal Slider')]")
    private WebElement horizontalSlider;
    @FindBy(xpath = "//a[contains(text(),'Hovers')]")
    private WebElement hovers;
    @FindBy(xpath = "//a[contains(text(),'Login Page')]")
    private WebElement login;
    @FindBy(xpath = "//a[contains(text(),'Key Presses')]")
    private WebElement keyPresses;

    public void navigateAddRemoveElementsPage() {
        click(addRemoveElements);
    }

    public void navigateCheckboxesPage() {
        click(checkboxes);
    }

    public void navigateContextMenuPage() {
        click(contextMenu);
    }

    public void navigateDropdownPage() {
        click(dropdown);
    }

    public void navigateDynamicLoadingPage() {
        click(dynamicLoading);
    }

    public void navigateDynamicControlsPage() {
        click(dynamicControls);
    }

    public void navigateEntryAdPage() {
        click(entryAd);
    }

    public void navigateFileDownloadPage() {
        click(fileDownload);
    }

    public void navigateFileUploadPage() {
        click(fileUpload);
    }

    public void navigateForgotPasswordPage() {
        click(forgotPassword);
    }

    public void navigateFramesPage() {
        click(frames);
    }

    public void navigateHorizontalSliderPage() {
        click(horizontalSlider);
    }

    public void navigateHoversPage() {
        click(hovers);
    }

    public void navigateLoginPage() {
        click(login);
    }

    public void navigateKeyPresses() {
        click(keyPresses);
    }
}
