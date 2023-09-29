package tests.testBase;


import pages.*;
import pages.dynamicallyloadedelements.DynamicallyLoadedPageElementsPage;
import pages.dynamicallyloadedelements.HiddenElementPage;
import pages.dynamicallyloadedelements.RenderedElementPage;
import pages.frames.FramesPage;
import pages.frames.IFramePage;
import pages.frames.NestedFramesPage;
import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@ExtendWith(TestBase.Listener.class)
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
    protected static HorizontalSliderPage horizontalSliderPage;
    protected static KeyPressesPage keyPressesPage;
    protected static FramesPage framesPage;
    protected static NestedFramesPage nestedFramesPage;
    protected static IFramePage iFramePage;
    protected static DynamicallyLoadedPageElementsPage dynamicallyLoadedPageElementsPage;
    protected static HiddenElementPage hiddenElementPage;
    protected static RenderedElementPage renderedElementPage;
    protected static ForgotPasswordPage forgotPasswordPage;
    protected static HoversPage hoversPage;

    public static WebDriver getDriver() {
        return driver;
    }

    public static Logger getLogger() {
        return logger;
    }

    @BeforeAll
    static void setUp() {
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
        horizontalSliderPage = new HorizontalSliderPage(driver);
        keyPressesPage = new KeyPressesPage(driver);
        framesPage = new FramesPage(driver);
        nestedFramesPage = new NestedFramesPage(driver);
        iFramePage = new IFramePage(driver);  //zamien inne wywoałania getText na to z klasy wrapującej
        dynamicallyLoadedPageElementsPage = new DynamicallyLoadedPageElementsPage(driver);
        hiddenElementPage = new HiddenElementPage(driver);
        renderedElementPage = new RenderedElementPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        hoversPage = new HoversPage(driver);
    }

//    public static class Listener implements TestWatcher{
//        @Override
//        public void testSuccessful(ExtensionContext context) {
//            System.out.println(">>>>>>>>>>>>>>>>> Success");
//        }
//    }

//    @AfterAll
//    static void tearDown() {
//        driver.quit();
//        logger.debug("Driver quit.");
//        logger.info(">>>>>>>>>>   End test   >>>>>>>>>>");
//    }
}
