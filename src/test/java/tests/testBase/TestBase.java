package tests.testBase;


import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.envint.*;
import pages.envint.dynamicallyloadedelements.DynamicallyLoadedPageElementsPage;
import pages.envint.dynamicallyloadedelements.HiddenElementPage;
import pages.envint.dynamicallyloadedelements.RenderedElementPage;
import pages.envint.fileoperations.FileDownloaderPage;
import pages.envint.fileoperations.FileUploadedPage;
import pages.envint.fileoperations.FileUploaderPage;
import pages.envint.frames.FramesPage;
import pages.envint.frames.IFramePage;
import pages.envint.frames.NestedFramesPage;
import pages.envtest.HomePage;
import pages.envtest.ScrollingPage;


public class TestBase {
    protected static WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    private static BrowserEnvironment browserEnvironment;
    private static EnvironmentProperty environmentProperty;

    //Pages
    protected static MainPage mainPage;
    protected static AddRemoveElementsPage addRemovePage;
    protected static CheckboxesPage checkboxesPage;
    protected static ContextMenuPage contextMenuPage;
    protected static DropdownListPage dropdownListPage;
    protected static DynamicControlsPage dynamicControlsPage;
    protected static EntryAdPage entryAdPage;
    protected static FileDownloaderPage fileDownloaderPage;
    protected static FileUploaderPage fileUploaderPage;
    protected static FileUploadedPage fileUploadedPage;
    protected static HorizontalSliderPage horizontalSliderPage;
    protected static KeyPressesPage keyPressesPage;
    protected static FramesPage framesPage;
    protected static NestedFramesPage nestedFramesPage;
    protected static IFramePage iFramePage;
    protected static DynamicallyLoadedPageElementsPage dynamicallyLoadedPageElementsPage;
    protected static HiddenElementPage hiddenElementPage;
    protected static RenderedElementPage renderedElementPage;
    protected static HoversPage hoversPage;
    protected static HomePage homePage;
    protected static ScrollingPage scrollingPage;

    public static WebDriver getDriver() {
        return driver;
    }

    public static Logger getLogger() {
        return logger;
    }

    @BeforeEach
    void setUp() {
        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver initialization.");

        mainPage = new MainPage(driver);
        addRemovePage = new AddRemoveElementsPage(driver);
        checkboxesPage = new CheckboxesPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        dropdownListPage = new DropdownListPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        entryAdPage = new EntryAdPage(driver);
        fileDownloaderPage = new FileDownloaderPage(driver);
        fileUploaderPage = new FileUploaderPage(driver);
        fileUploadedPage = new FileUploadedPage(driver);
        horizontalSliderPage = new HorizontalSliderPage(driver);
        keyPressesPage = new KeyPressesPage(driver);
        framesPage = new FramesPage(driver);
        nestedFramesPage = new NestedFramesPage(driver);
        iFramePage = new IFramePage(driver);
        dynamicallyLoadedPageElementsPage = new DynamicallyLoadedPageElementsPage(driver);
        hiddenElementPage = new HiddenElementPage(driver);
        renderedElementPage = new RenderedElementPage(driver);
        hoversPage = new HoversPage(driver);
        homePage = new HomePage(driver);
        scrollingPage = new ScrollingPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.debug("Driver quit.");
        logger.info(">>>>>>>>>>   End test   >>>>>>>>>>");
    }
}
