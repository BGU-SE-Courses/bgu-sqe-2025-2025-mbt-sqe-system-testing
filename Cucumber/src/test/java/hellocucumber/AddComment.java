package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddComment {

    private WebDriver driver;
    private WebDriverWait wait;
    final String URL = "https://demo.prestashop.com/#/en/front";
    final private String WEB_DRIVER = "webdriver.chrome.driver";
    final private String PATH = "/path/to/chromedriver";  // Replace with the correct path

    public void Init() {
        System.out.println("--------------- OPENING WEBPAGE ---------------");
        System.setProperty(WEB_DRIVER, PATH);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void NavigateToLogin() {
        System.out.println("--------------- EXECUTING NavigateToLogin ---------------");
        driver.findElement(By.linkText("Sign in")).click();
    }

    public void Login(String username, String password) {
        System.out.println("--------------- EXECUTING Login ---------------");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-email"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-password"))).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_desktop_logo"))).click();
    }

    public void VerifyLogin() {
        System.out.println("--------------- VERIFYING Login ---------------");
        driver.findElement(By.linkText("Sign out"));
    }

    public void NavigateToProduct(String productName) {
        System.out.println("--------------- NAVIGATING TO PRODUCT ---------------");
        driver.findElement(By.linkText(productName)).click();
    }

    public void WriteComment(String comment) {
        System.out.println("--------------- WRITING COMMENT ---------------");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment-input"))).sendKeys(comment);
        driver.findElement(By.id("submit-comment")).click();
    }

    public void VerifyCommentVisible(String productName, String comment) {
        System.out.println("--------------- VERIFYING COMMENT IS VISIBLE ---------------");
        NavigateToProduct(productName);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("comment-content"), comment));
    }

    public void NavigateToAdminLogin() {
        System.out.println("--------------- NAVIGATING TO ADMIN LOGIN ---------------");
        driver.get(URL + "admin");
    }

    public void AdminLogin(String username, String password) {
        System.out.println("--------------- ADMIN LOGIN ---------------");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd"))).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();
    }

    public void DeleteProduct(String productName) {
        System.out.println("--------------- DELETING PRODUCT ---------------");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Catalog"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Products"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(productName))).click();
        driver.findElement(By.className("delete-product-button")).click();
        driver.switchTo().alert().accept();
    }

    public void VerifyProductDeleted(String productName) {
        System.out.println("--------------- VERIFYING PRODUCT DELETION ---------------");
        driver.findElement(By.id("search_query_top")).sendKeys(productName);
        driver.findElement(By.name("submit_search")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("alert-warning"), "No results were found"));
    }

    public void VerifyCommentNotVisible(String productName, String comment) {
        System.out.println("--------------- VERIFYING COMMENT IS NOT VISIBLE ---------------");
        NavigateToProduct(productName);
        boolean isCommentPresent = driver.getPageSource().contains(comment);
        if (isCommentPresent) {
            throw new AssertionError("Comment is still visible after product deletion!");
        }
    }

    public void Close() {
        System.out.println("--------------- CLOSING DRIVER ---------------");
        driver.quit();
    }
}
