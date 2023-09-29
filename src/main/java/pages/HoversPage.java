package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage{ //do
    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public static final String FIGURE_ONE_NAME = "name: user1";
    public static final String FIGURE_TWO_NAME = "name: user2";
    public static final String FIGURE_THREE_NAME = "name: user3";
    @FindBy(xpath = "//div[@id='content']//div[@class='figure'][1]")
    private WebElement figureOne;

    @FindBy(xpath = "//div[@id='content']//div[@class='figure'][1]//div[@class='figcaption']//h5")
    private WebElement figureOneName;

    @FindBy(xpath = "//div[@id='content']//div[@class='figure'][2]")
    private WebElement figureTwo;

    @FindBy(xpath = "//div[@id='content']//div[@class='figure'][2]//div[@class='figcaption']//h5")
    private WebElement figureTwoName;

    @FindBy(xpath = "//div[@id='content']//div[@class='figure'][3]")
    private WebElement figureThree;

    @FindBy(xpath = "//div[@id='content']//div[@class='figure'][3]//div[@class='figcaption']//h5")
    private WebElement figureThreeName;

    @FindBy(xpath = "//div[@id='content']//div[@class='figure'][3]//div[@class='figcaption']//a")
    private WebElement figureThreeViewProfileLnk;

    @FindBy(xpath = "//body//h1")
    private WebElement figureThreeViewProfileTitle;

    public String getFigureOneName(){
        mouseHover(figureOne);
        return getText(figureOneName);
    }

    public String getFigureTwoName(){
        mouseHover(figureTwo);
        return getText(figureTwoName);
    }

    public String getFigureThreeName(){
        mouseHover(figureThree);
        return getText(figureThreeName);
    }

    public boolean viewFigureThreeProfile(){
        mouseHover(figureThree);
        click(figureThreeViewProfileLnk);
        return figureThreeViewProfileTitle.isDisplayed();
    }
}
