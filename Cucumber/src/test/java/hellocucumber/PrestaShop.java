package hellocucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * PrestaShop class provides automation functionality for an e-commerce presta shop website.
 * Handles browser interactions, user authentication, cart management, and product operations
 * using Selenium WebDriver.
 */
public class PrestaShop {
    // Main WebDriver instance for browser control
    private static WebDriver driver;
    // Wait instance for handling explicit waits
    private static WebDriverWait wait;
    // Tracks the current number of items in the shopping cart
    private int currentCartQuantity;

    /**
     * Initializes a new browser session and sets up the WebDriver configuration.
     * Configures logging, window position, and navigates to the initial URL.
     *
     * @param webDriver The WebDriver system property key to be set
     * @param path The path to the WebDriver executable
     */
    public void initSessionAsUser(String webDriver, String path) {
        // Suppress ChromeDriver logging for cleaner console output
        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.OFF);

        System.setProperty(webDriver, path);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Navigate to the login page URL
        driver.get("http://localhost:8080/login?back=http%3A%2F%2Flocalhost%3A8080%2Fwomen%2F2-9-brown-bear-printed-sweater.html");
        driver.manage().window().setPosition(new Point(300, 5));
        driver.manage().window().maximize();
        System.out.println("Driver setup finished for - " + driver.getTitle());
    }

    /**
     * Performs user authentication by entering login credentials and verifying successful login.
     * Uses explicit waits to ensure elements are ready before interaction.
     *
     * @param username The user's login username
     * @param password The user's login password
     * @throws RuntimeException if login process fails
     */
    public void enterLoginInfo(String username, String password) {
        try {
            // Fill in username field
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[1]/div[1]/input"))).sendKeys(username);
            // Fill in password field
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[2]/div[1]/div/input"))).sendKeys(password);
            // Click login button
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/main/section/div/div/div/section/div/section/form/footer/button"))).click();

            // Allow time for login process to complete
            Thread.sleep(1000);

            // Verify login success by checking for account elements
            WebElement accountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(@class,'account') or contains(@class,'logged-in')]")));

            System.out.println("Successfully logged in as: " + username);
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            throw new RuntimeException("Login failed", e);
        }
    }

    /**
     * Adds a specified product to the cart twice.
     * Handles the add-to-cart process and confirmation dialogs with appropriate waits.
     *
     * @param productName The name of the product to be added
     * @throws RuntimeException if adding product to cart fails
     */
    public void addProductToCartTwice(String productName) {
        try {
            // First addition to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"))).click();
            Thread.sleep(1000); // Wait for cart update
            // Close first confirmation dialog
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/button"))).click();
            Thread.sleep(1000); // Wait for cart update

            // Second addition to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"))).click();
            Thread.sleep(1000); // Wait for cart update
            // Close second confirmation dialog
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/button"))).click();
            Thread.sleep(1000); // Wait for cart update
            System.out.println("Successfully added product to cart twice");
        } catch (Exception e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
            throw new RuntimeException("Failed to add product to cart", e);
        }
    }

    /**
     * Retrieves the current quantity of items in the cart.
     * Opens the cart modal and reads the quantity value from the input field.
     *
     * @return The current quantity in the cart, or 0 if retrieval fails
     */
    private int getCartQuantity() {
        try {
            // Open cart by clicking cart icon
            WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[3]/div")));
            cartIcon.click();

            // Locate and get quantity from input field
            WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/main/section/div/div/div/section/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input")));

            // Extract and parse quantity value
            String quantity = quantityInput.getAttribute("value");
            return Integer.parseInt(quantity);
        } catch (Exception e) {
            System.out.println("Error getting cart quantity: " + e.getMessage());
            return 0;
        }
    }

    /**
     * Verifies that the cart contains the expected quantity of items.
     * Makes multiple attempts to check the quantity with delays between attempts.
     *
     * @param expectedQuantity The expected number of items in the cart
     * @throws RuntimeException if verification fails after maximum attempts
     */
    public void verifyProductInCart(int expectedQuantity) {
        try {
            int attempts = 0;
            int maxAttempts = 3;
            int actualQuantity;

            // Retry loop for checking cart quantity
            do {
                actualQuantity = getCartQuantity();
                if (actualQuantity == expectedQuantity) {
                    System.out.println("Cart verification successful: Quantity = " + actualQuantity);
                    return;
                }
                Thread.sleep(1000);
                attempts++;
            } while (attempts < maxAttempts);

            // Final verification using assertion
            assertEquals(expectedQuantity, actualQuantity,
                    "The product quantity in the cart does not match the expected value. " +
                            "Expected: " + expectedQuantity + ", Actual: " + actualQuantity);
        } catch (Exception e) {
            System.out.println("Error verifying cart quantity: " + e.getMessage());
            throw new RuntimeException("Cart verification failed", e);
        }
    }

    /**
     * Closes the browser and performs cleanup of WebDriver resources.
     * Should be called after all operations are complete.
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }
}