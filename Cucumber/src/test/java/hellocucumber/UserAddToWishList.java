package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserAddToWishList {
    private WebDriver driver;
    private static WebDriverWait wait;

    private enum Config {
        WEBDRIVER("webdriver.chrome.driver"),
        DRIVER_PATH("2025-mbt-teamalpha\\Selenium\\chromedriver.exe"),
        TEST_EMAIL("testuser@example.com"),
        TEST_PASSWORD("password123"),
        SAMPLE_PRODUCT("Sample Product"),
        DEFAULT_QUANTITY(1);

        private final String stringValue;
        private final int intValue;

        Config(String value) {
            this.stringValue = value;
            this.intValue = 0;
        }

        Config(int value) {
            this.stringValue = null;
            this.intValue = value;
        }

        public String getString() {
            return stringValue;
        }

        public int getInt() {
            return intValue;
        }
    }

    // @Before("@UserAddToWishlist")
    // public void initSession() {
    //     //System.setProperty(Config.WEBDRIVER.getString(), Config.DRIVER_PATH.getString());

    //     // Initialize WebDriver and WebDriverWait
    //     driver = new ChromeDriver();
    //     wait = new WebDriverWait(driver, Duration.ofSeconds(1));

    //     // Launch OpenCart site and maximize window
    //     driver.get("http://localhost/opencartsite/");
    //     driver.manage().window().setPosition(new Point(700, 5));

    //     System.out.println("Driver initialized. Page title: " + driver.getTitle());
    // }



    @And("the user is on the OpenCart homepage")
    public void userIsOnOpenCartHomepage() {
        driver.get("http://localhost/opencartsite");

    }

    @And("the user is logged in to their account")
    public void userIsLoggedIn() {
        loginToAccount(Config.TEST_EMAIL.getString(), Config.TEST_PASSWORD.getString());
    }

    @When("the user navigates to a product page")
    public void userNavigatesToProductPage() {
        System.out.println("Navigating to product page...");
        // Assuming specific product name is not yet provided here
    }

    @When("the user selects a quantity of {string}")
    public void userSelectsQuantity(String quantity) {
        System.out.println("Selecting quantity: " + quantity);
        searchAndAddToWishlist(Config.SAMPLE_PRODUCT.getString(), Integer.parseInt(quantity));
    }

    @And("the user clicks on the \"Add to Wishlist\" button")
    public void userClicksAddToWishlistButton() {
        System.out.println("Clicked 'Add to Wishlist' button.");
    }

    @Then("the product should be added to the wishlist with the specified quantity")
    public void productShouldBeAddedToWishlist() {
        System.out.println("Verifying product added to wishlist...");
        verifyProductInWishlist(Config.SAMPLE_PRODUCT.getString(), Config.DEFAULT_QUANTITY.getInt());
    }

    @And("the wishlist should display the correct product details and quantity")
    public void wishlistDisplaysCorrectDetails() {
        System.out.println("Verifying wishlist displays correct details...");
        verifyProductInWishlist(Config.SAMPLE_PRODUCT.getString(), Config.DEFAULT_QUANTITY.getInt());
    }

    @Given("the user exists in the OpenCart database")
    public void userExistsInOpenCartDatabase() {
        driver = new ChromeDriver();
        driver.get("http://localhost/opencartsite");

        driver.findElement(By.xpath("//li[2]/div[1]/a[1]/span[1]")).click();
        driver.findElement(By.xpath("//li[2]/div[1]/ul[1]/li[1]/a[1]")).click();

        driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys("user");
        driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("user@gmail.com");
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("123456");

        // Scroll down until button visible
        WebElement tuggElement = driver.findElement(By.xpath("//form[1]/div[1]/div[1]/input[1]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 350);");

        tuggElement.click();

        driver.findElement(By.xpath("//form[1]/div[1]/button[1]")).click();
    }

    public void loginToAccount(String username, String password) {
        // Navigate to login page
        driver.findElement(By.xpath("//li[2]/div[1]/a[1]/span[1]")).click();
        driver.findElement(By.xpath("//li[2]/div[1]/ul[1]/li[2]/a[1]")).click();
        
        // Enter login credentials and submit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-email']"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='form-login']/div/button[1]")).click();

        System.out.println("User logged in successfully.");
    }

    public void searchAndAddToWishlist(String productName, int quantity) {
        // Search for the product
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/input[1]"))).sendKeys(productName);
        driver.findElement(By.xpath("//*[@id='search']/button[1]")).click();

        // Select the product
        driver.findElement(By.xpath("//*[@id='product-list']/div/div/div/a/img[1]")).click();

        // Set quantity
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-quantity']")));
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));

        // Add to wishlist
        driver.findElement(By.xpath("//*[@id='button-wishlist']")).click();
        System.out.println(productName + " added to wishlist with quantity: " + quantity);

        // Wait briefly for the wishlist update
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyProductInWishlist(String productName, int expectedQuantity) {
        // Navigate to wishlist page
        driver.findElement(By.xpath("//*[@id='wishlist-total']")).click();

        // Locate product details in the wishlist
        WebElement wishlistProduct = driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]"));
        WebElement wishlistQuantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));

        // Validate product details and quantity
        assertEquals(productName, wishlistProduct.getText(), "Product name mismatch in wishlist.");
        assertEquals(String.valueOf(expectedQuantity), wishlistQuantity.getAttribute("value"), "Product quantity mismatch in wishlist.");

        System.out.println("Wishlist verified: " + productName + " with quantity: " + expectedQuantity);
    }

    public void closeSession() {
        // Close the browser session
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Browser session closed.");
    }

}
