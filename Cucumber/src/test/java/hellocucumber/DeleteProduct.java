package hellocucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteProduct {

    private WebDriver driver;
    private WebDriverWait wait;
    final String URL = "http://localhost/prestashop/admin1";
    final private String WEB_DRIVER = "webdriver.chrome.driver";
    final private String PATH = "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver.exe";


    public void Init() {
        System.out.println("--------------- OPENING WEBPAGE ---------------");
        System.setProperty(WEB_DRIVER, PATH);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void Login(String username, String password) {
        System.out.println("--------------- EXECUTING Login ---------------");
        try {
            // Find and fill in the email input
            WebElement emailInput = driver.findElement(By.id("email"));
            emailInput.clear();
            emailInput.sendKeys(username);

            // Find and fill in the password input
            WebElement passwordInput = driver.findElement(By.id("passwd"));
            passwordInput.clear();
            passwordInput.sendKeys(password);

            // Click the login button
            WebElement loginButton = driver.findElement(By.id("submit_login"));
            loginButton.click();

            System.out.println("Login attempted with email: " + username);
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
        }
    }
}
