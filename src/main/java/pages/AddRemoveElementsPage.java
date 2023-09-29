package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import providers.RandomIntGenerator;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addElementBtn;

    @FindBy(xpath = "//div[@id='elements']//button ")
    private List<WebElement> elementsPresent;

    RandomIntGenerator rnd = new RandomIntGenerator();

    public int addRandomCountOfElements(int bound) {
        int expectedElementsToBeAddedCount = rnd.generateRandomIndex(bound);
        for (int i = 0; i < expectedElementsToBeAddedCount; i++) {
            click(addElementBtn);
        }
        return expectedElementsToBeAddedCount;
    }

    public int addSixElements() {
        int expectedElementsToBeAddedCount = 6;
        for (int i = 0; i <= expectedElementsToBeAddedCount; i++) {
            click(addElementBtn);
        }
        return expectedElementsToBeAddedCount;
    }

    public int countElements(){
        return elementsPresent.size();
    }

    public int deleteRandomCountOfElements(){
        int bound = countElements();
        int elementsToBeDeletedCount = rnd.generateRandomIndex(bound);
        for (int i = 0; i < elementsToBeDeletedCount; i++) {
            click(elementsPresent.get(i));
        }
        return elementsToBeDeletedCount;
    }
}

