package hellocucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * PrestaShopAdmin class handles administrative operations for the presta shop database.
 * Provides functionality for database access, cart quantity updates, and verification
 * through phpMyAdmin interface using Selenium WebDriver.
 */
public class PrestaShopAdmin {
    // WebDriver instance for browser control
    private static WebDriver driver;
    // Wait instance for handling explicit waits in element interactions
    private static WebDriverWait wait;

    /**
     * Initializes an admin session by setting up WebDriver and navigating to phpMyAdmin.
     * Configures the browser window and establishes connection to the cart_product table.
     *
     * @param webDriver The WebDriver system property key to be set
     * @param path The path to the WebDriver executable
     * @throws RuntimeException if initialization fails
     */
    public void initAdminSession(String webDriver, String path) {
        try {
            System.setProperty(webDriver, path);
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(40));

            // Navigate to phpMyAdmin cart_product table
            driver.get("http://localhost:9090/index.php?route=/sql&pos=0&db=prestashop&table=ps_cart_product");
            driver.manage().window().maximize();
            Thread.sleep(1000);

            System.out.println("Admin session initialized successfully");
        } catch (Exception e) {
            System.out.println("Error initializing admin session: " + e.getMessage());
            if (driver != null) {
                driver.quit();
            }
            throw new RuntimeException("Failed to initialize admin session", e);
        }
    }

    /**
     * Updates the quantity of the last cart entry to one in the database.
     * Performs the following steps:
     * 1. Locates and clicks the edit button for the last row
     * 2. Clears the quantity field
     * 3. Sets the new quantity to 1
     * 4. Saves the changes
     * 5. Verifies the update
     *
     * @throws RuntimeException if quantity update fails
     */
    public void updateQuantityToOne() {
        try {
            Thread.sleep(1000);
            // Click edit button on the last row
            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("table.table_results tbody tr:last-child .edit_row_anchor")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
            Thread.sleep(1000);
            editButton.click();
            System.out.println("Clicked edit on the last cart entry");
            Thread.sleep(1000);

            // Locate quantity field and use multiple methods for clearing and input
            WebElement quantityInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("/html/body/div[7]/form/div/table/tbody/tr[7]/td[5]/input[2]")));

            // Thorough field clearing
            quantityInput.clear();
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", quantityInput);
            Thread.sleep(500);

            // Input new value
            quantityInput.sendKeys("1");
            Thread.sleep(500);

            // Verify input value
            String currentValue = quantityInput.getAttribute("value");
            System.out.println("Current input value: " + currentValue);

            if (!"1".equals(currentValue)) {
                throw new RuntimeException("Failed to set quantity to 1. Current value: " + currentValue);
            }

            // Click first save button
            WebElement goButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@type='submit' and @value='Go']")));
            Thread.sleep(1000);
            goButton.click();
            Thread.sleep(1000);

            // Scroll to bottom of page
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1000);

            // Verify return to main page
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.className("table_results")));

            // Wait before refresh
            Thread.sleep(1000);
            driver.navigate().refresh();
            Thread.sleep(1000);

            System.out.println("Successfully updated cart quantity to 1");
        } catch (Exception e) {
            System.out.println("Error updating cart quantity: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to update cart quantity",e);
        }
    }

    /**
     * Verifies the quantity in the database matches the expected value.
     * Checks the last row of the cart_product table for quantity verification.
     *
     * @param ex_quantity The expected quantity to verify against
     * @throws RuntimeException if verification fails
     * @throws AssertionError if quantity doesn't match expected value
     */
    public static void verifyQuantity(int ex_quantity) {
        try {
            Thread.sleep(1000); // Wait for table to load

            // Get quantity from last row
            WebElement quantityCell = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("table.table_results tbody tr:last-child td:nth-child(11)")));

            String quantity = quantityCell.getText().trim();
            int actualQuantity = Integer.parseInt(quantity);

            // Verify quantity matches expected value
            if (actualQuantity != ex_quantity) {
                throw new AssertionError("Expected quantity to be 2 but was: " + actualQuantity);
            }
            System.out.println("Cart verification successful: Quantity = " + actualQuantity);
        } catch (Exception e) {
            System.out.println("Error verifying database quantity: " + e.getMessage());
            throw new RuntimeException("Failed to verify database quantity", e);
        }
    }

    /**
     * Closes the browser and cleans up WebDriver resources.
     * Includes a delay to ensure all operations are complete before closing.
     */
    public void closeBrowser() {
        try {
            Thread.sleep(2000);
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error closing browser: " + e.getMessage());
        }
    }
}