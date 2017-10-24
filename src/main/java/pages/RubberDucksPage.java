package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RubberDucksPage extends AbstractPage{

    @FindBy(className = "name")
    List<WebElement> duckNames;

    public List<String> getDuckNames() {
        List<String> duckNamesResult = new ArrayList<>();
        for(WebElement duckName : duckNames) {
            duckNamesResult.add(duckName.getText());
        }

        return duckNamesResult;
    }
}
