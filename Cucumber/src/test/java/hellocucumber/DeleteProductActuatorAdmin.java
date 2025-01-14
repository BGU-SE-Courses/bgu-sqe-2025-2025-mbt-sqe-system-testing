package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteProductActuatorAdmin {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public void initSessionAsAdmin(String webDriver, String path) {
        // Set up WebDriver for Chrome
        System.setProperty(webDriver, path);

        // Initialize Chrome driver
        this.driver = new ChromeDriver();

        // WebDriver wait to ensure elements are loaded (40 sec max)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Launch PrestaShop website
        driver.get("http://localhost/my_shop/admin4150un9qxx4ji25cqkv/");

        // Maximize window to ensure proper display
        driver.manage().window().setPosition(new Point(0, 0));

        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void enterLoginInfoAdmin(String username, String password) {
        // locate the username input box and enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"email\"]"))).sendKeys(username);
        // locate the password input box and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"passwd\"]"))).sendKeys(password);
        // locate Log in button and press
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit_login']/span[1]"))).click();
        wait.until(ExpectedConditions.titleContains("Home"));
    }
}
