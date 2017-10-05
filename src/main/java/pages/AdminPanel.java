package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;

import java.util.List;

public class AdminPanel {

    @FindBy(id = "box-apps-menu")
    WebElement sideMenuContainer;

    public boolean isHeaderPresent() {
        return isElementPresent(By.tagName("h1"));
    }

    private boolean isElementPresent(By locator) {
        return !DriverFactory.getDriver().findElements(locator).isEmpty();
    }

    private List<WebElement> getSideMenuContainer() {
        return sideMenuContainer.findElements(By.id("app-"));
    }
}
