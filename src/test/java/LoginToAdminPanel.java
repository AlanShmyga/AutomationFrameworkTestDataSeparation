import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToAdminPanel {

    @Test //анотация Test из jUnit что бы наш метод был распознан как jUnit тест
    public void loginAdminPage() { //создание метода
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/login.php");

        driver.findElement(By.name("usernameControl")).sendKeys("admin");
        driver.findElement(By.name("passwordControl")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        driver.quit();
    }
}
