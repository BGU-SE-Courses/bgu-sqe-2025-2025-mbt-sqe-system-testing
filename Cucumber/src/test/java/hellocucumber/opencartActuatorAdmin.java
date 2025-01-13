package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class opencartActuatorAdmin {
    protected WebDriver driver;
    private WebDriverWait wait;

    public void initSessionAsAdmin(String webDriver, String path) {
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));


        // launch website -> localhost
        driver.get("http://localhost/opencartsite/admin/");

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().setPosition(new Point(0, 0));
    }

    public void enterLoginInfoAdmin(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-username']"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-security")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-close[data-bs-dismiss='modal']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.modal-backdrop.show")));
        wait.until(ExpectedConditions.titleContains("Dashboard"));
    }

    public void clickMarketingButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[1]/ul[1]/li[7]/a[1]"))).click();
    }

    public void clickCouponsButton(){
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[1]/ul[1]/li[7]/ul[1]/li[2]/a[1]"))).click();

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'route=marketing/coupon')]"))).click();
//        wait.until(ExpectedConditions.titleContains("Coupons"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'route=marketing/coupon')]"))).click();
        //wait.until(ExpectedConditions.titleContains("Coupons"));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[3]/a[1]"))).click();
//        wait.until(ExpectedConditions.titleContains("Coupons"));

//        // Wait for the "Coupon" link with class="active" to be clickable and click it
//        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='active']/a[contains(@href, 'route=marketing/coupon')]"))).click();

        // Verify that the "Coupons" page is loaded
//        longWait.until(ExpectedConditions.titleContains("Coupons"));
//        WebElement element = driver.findElement(By.linkText("Coupons"));
//        element.click();
    }

}
