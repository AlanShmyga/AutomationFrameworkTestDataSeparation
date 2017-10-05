import pages.AdminPanel;
import pages.LoginToAdminPage;
import utils.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class LoginToAdminPage_PO {

    private final String appLink = "http://localhost/litecart/admin/login.php";
    private final String username = "admin";
    private final String password = "admin";

    @Before
    public void setup() {
        DriverFactory.getDriver().get(appLink);
    }

    @Test
    public void loginToAdminPanel() {
        new LoginToAdminPage().loginAsUser(username, password);
    }

    @Test
    public void checkThatAdminPanelDirectoriesContainHeaders() {
        new LoginToAdminPage().loginAsUser(username, password);

        Assert.assertTrue(new AdminPanel().isHeaderPresent());
    }

    @After
    public void teardown() {
        DriverFactory.getDriver().quit();
    }
}
