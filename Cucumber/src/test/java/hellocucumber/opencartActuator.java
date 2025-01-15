package hellocucumber;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class opencartActuator {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private double originalPrice;

    public void initSessionAsUser(String webDriver, String path){
        // webDriver = "webdriver.chrome.driver"
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));


        // launch website -> localhost
        driver.get("http://localhost/opencartsite/");

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().setPosition(new Point(700, 5));

        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    public void enterLoginInfoUser(String email, String password) {
        // Locate the email input and enter the email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-email']"))).sendKeys(email);

        // Locate the password input and enter the password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys(password);

        // Locate and click the login button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/button[1]"))).click();
    }

    public void clickHomepage() {
        // Locate and click the homepage link/button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[1]"))).click();
    }

    public void scrollDownToProduct() {
        // Scroll down the page to view the product
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        try {
            Thread.sleep(500); // Wait for any animations or lazy-loading
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addToCart() {
        // Locate and click the add-to-cart button for the product
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[1]/div[2]/form[1]/div[1]/button[1]"))).click();
    }

    public void scrollUp() {
        // Scroll back up the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickShoppingCart() {
        // Locate and click the shopping cart button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[4]/a[1]/span[1]"))).click();
    }

    public void scrollDown() {
        // Scroll down to the coupon section
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickUseCoupon() {
        // Locate and click the "use a coupon" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/h2[1]/button[1]"))).click();
    }

    public void enterCouponCode(String couponCode) {
        // Locate the coupon code input field and enter the code
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-coupon']"))).sendKeys(couponCode);
    }

    public void clickApplyCoupon() {
        // Locate and click the "apply coupon" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[1]/div[1]/form[1]/div[2]/button[1]"))).click();
    }

    public void storeOriginalPrice() {
        // Locate the element showing the total price before applying the coupon
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tfoot[1]/tr[4]/td[2]")));
        String priceText = priceElement.getText();

        // Convert the price text to a numerical value
        originalPrice = parsePrice(priceText);
    }

    @Test
    public void verifyDiscountAppliedTest() {
        /**
         * Verifies if a discount is successfully applied to the total price.
         *
         * This method performs the following actions:
         * 1. Locates the total price element after applying the coupon.
         * 2. Checks if the new total price is less than the original total price.
         *
         * Steps:
         * - XPath for total price element and apply coupon button should be updated based on the page structure.
         * - The parsePrice helper function extracts numerical values from the price text.
         *
         * @throws AssertionError If the discount is not applied correctly.
         */
        try {
            // Wait for the new total price to appear (or update)
            WebElement totalPriceElementAfter = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tfoot[1]/tr[4]/td[2]")));
            String totalPriceTextAfter = totalPriceElementAfter.getText();
            double newPrice = parsePrice(totalPriceTextAfter);

            //System.out.println("New Price: " + newPrice);

            // Verify the new price is less than the original price
            assertTrue(newPrice < originalPrice, "Discount was not applied correctly. New price is not less than the original price.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("An error occurred during the discount verification test.");
        }
    }

    /**
     * Helper method to extract a numerical price from a text string.
     *
     * @param priceText The text containing the price.
     * @return The price as a double.
     */
    private double parsePrice(String priceText) {
        // Remove currency symbols and commas, then parse to double
        return Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
    }

    public void goToLogin(){
        // locate and click on web element -> login
        driver.findElement(By.xpath("//*[@id='top']/div[1]/div[2]/ul[1]/li[2]/div[1]/a[1]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='top']/div[1]/div[2]/ul[1]/li[2]/div[1]/ul[1]/li[2]/a[1]")).click();
    }
}
