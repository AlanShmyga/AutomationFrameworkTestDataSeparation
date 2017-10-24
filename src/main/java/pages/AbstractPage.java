package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public abstract class AbstractPage {

    WebDriver driver = DriverFactory.getDriver();

    AbstractPage() {
        PageFactory.initElements(driver, this);
    }
}
