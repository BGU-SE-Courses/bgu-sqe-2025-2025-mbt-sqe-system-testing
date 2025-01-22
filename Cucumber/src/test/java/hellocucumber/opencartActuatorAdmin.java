package hellocucumber;

import org.openqa.selenium.*;
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
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[1]/ul[1]/li[7]/ul[1]/li[3]/a[1]"))).click();
        wait.until(ExpectedConditions.titleContains("Coupons"));
    }

    public void clickEditCouponsButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]/td[8]/a[1]"))).click();
    }

    public void scrollDownUntilFindStatus(){
        ((JavascriptExecutor)driver).executeScript("window,scrollTo(0,document.body.scrollHeight);");
        try{
            Thread.sleep(500);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void ClickOnStatusButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-status']"))).click();
        try{
            Thread.sleep(500);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void scrollUpUntilFindSave(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        try{
            Thread.sleep(500);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void ClickOnSaveButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[1]/button[1]"))).click();
    }
}
