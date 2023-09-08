package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage{
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form//input[1]")
    private WebElement firstCheckbox;

    @FindBy(xpath = "//form//input[2]")
    private WebElement secondCheckbox;



    public boolean checkFirstCheckbox(){
       boolean isChecked = false;
       try{
           String attributeValue = firstCheckbox.getAttribute("checked");
           if(attributeValue == null){
               isChecked = true;
           }
       } catch (Exception e){
           e.printStackTrace();
       }

       if(!isChecked){
           click(firstCheckbox);
       }

        try{
            String attributeValue = firstCheckbox.getAttribute("checked");
            if(attributeValue == null){
                isChecked = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
