package hellocucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeleteProduct {

    private WebDriver driver;
    private WebDriverWait wait;
    final String URL = "http://localhost/prestashop/admin1";
    final private String WEB_DRIVER = "webdriver.chrome.driver";
    final private String PATH = "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver.exe";
    WebElement product_roWebElement;


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

    public void navigateToProducts() {
        System.out.println("--------------- NAVIGATING TO PRODUCTS PAGE ---------------");
    
        try {
            // Wait for the sidebar to load and the "Catalog" link to be visible
            WebElement catalogLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subtab-AdminCatalog")));
            catalogLink.click();
            System.out.println("Clicked on 'Catalog'.");
    
            // Wait for the submenu to expand
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collapse-9")));
    
            // Locate and click the "Products" link
            WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("subtab-AdminProducts")));
            productsLink.click();
            System.out.println("Clicked on 'Products'.");
    
        } catch (Exception e) {
            System.err.println("Navigation to Products page failed: " + e.getMessage());
        }
    }

    public boolean isProductPresent(String product_name) throws Exception {

        System.out.println("--------------- CHECKING IF PRODUCT EXISTS ---------------");

        try {
            // Wait for the product table to load
            WebElement productTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tbody")));

            // Locate all rows in the product table
            List<WebElement> rows = productTable.findElements(By.tagName("tr"));

            // Iterate through each row to check for the product name
            for (WebElement row : rows) {
                // Locate the product name column
                WebElement nameCell = row.findElement(By.cssSelector(".column-name a"));
                if (nameCell.getText().equalsIgnoreCase(product_name)) {
                    product_roWebElement = row;
                    System.out.println("Product found: " + product_name);
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            throw new Exception("Error while checking for product: " + e.getMessage());
        }

    }

    public void click3Dots(String productName) {
        System.out.println("--------------- FINDING PRODUCT AND CLICKING DELETE ---------------");
    
        try {
            // Wait for the product table to load
            //WebElement productTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tbody")));
    
            // Locate all rows in the product table
            //List<WebElement> rows = productTable.findElements(By.tagName("tr"));

            // Scroll into view of the product row
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product_roWebElement);
    
            // Locate the "3 dots" button in the same row
            WebElement threeDotsButton = product_roWebElement.findElement(By.cssSelector(".dropdown-toggle-dots"));
            threeDotsButton.click();
            System.out.println("Clicked the 3 dots button for product: " + productName);
    
            //System.out.println("Product not found: " + productName);
        } catch (Exception e) {
            System.err.println("Error while attempting to delete product: " + e.getMessage());
        }
    }

    public void clickDeleteButton() {
        System.out.println("--------------- CLICKING DELETE BUTTON ---------------");
    
        try {
            // Wait for the delete option to be clickable within the dropdown menu
            WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(
                    product_roWebElement.findElement(By.cssSelector(".grid-delete-row-link"))));
    
            // Click the delete option
            deleteOption.click();
            System.out.println("Clicked the delete button.");
        } catch (Exception e) {
            System.err.println("Error while clicking the delete button: " + e.getMessage());
        }
    }

    public void confirmDeletion() {
        System.out.println("--------------- CONFIRMING DELETION ---------------");
    
        try {
            // Wait for the modal to appear
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-grid-confirm-modal")));
    
            // Locate and click the "Delete" button
            WebElement confirmDeleteButton = modal.findElement(By.cssSelector(".btn-confirm-submit"));
            confirmDeleteButton.click();
            System.out.println("Confirmed deletion.");
    
        } catch (Exception e) {
            System.err.println("Error while confirming deletion: " + e.getMessage());
        }
    }
}
