package hellocucumber;

import io.cucumber.java.en.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StepDefinitions class implements Cucumber test steps for PastaShop e-commerce application.
 * Manages both user and admin interactions through separate sessions.
 * Handles test scenarios for cart operations and admin management.
 */
public class StepDefinitions {
    // List to track all user cart instances
    private static List<PrestaShop> allOpenCarts;
    // Main user session instance
    private static PrestaShop PastaShopUser;
    // Main admin session instance
    private static PrestaShopAdmin PastaShopManager;
    // List to track open user cart sessions
    private static List<PrestaShop> allopenCarts;
    // List to track open admin sessions
    private static List<PrestaShopAdmin> allopenCartsA;
    // WebDriver configuration
    private String webDriver = "webdriver.chrome.driver";
    // Path to ChromeDriver executable
    private String path = "C:\\Users\\User\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe";

    /**
     * Initializes a new user session for PastaShop testing.
     * Creates and tracks a new user cart instance if none exists.
     */
    public void PastaShopUser() {
        System.out.println("--------------- INITIALIZING PASTASHOP TEST - OPENING WEBPAGE ---------------");
        if(allopenCarts == null){
            allopenCarts = new ArrayList<>();
        }
        PastaShopUser = new PrestaShop();
        allopenCarts.add(PastaShopUser);
        PastaShopUser.initSessionAsUser(webDriver, path);
    }

    /**
     * Initializes a new admin session for PastaShop management.
     * Creates and tracks a new admin instance if none exists.
     */
    public void PastaShopAdmin() {
        System.out.println("--------------- INITIALIZING ADMIN TEST - OPENING WEBPAGE ---------------");
        if(allopenCartsA == null){
            allopenCartsA = new ArrayList<>();
        }
        PastaShopManager = new PrestaShopAdmin();
        allopenCartsA.add(PastaShopManager);
        PastaShopManager.initAdminSession(webDriver, path);
    }

    /**
     * Cucumber step: Verifies user is logged in to PastaShop.
     * Initializes user session and performs login with credentials.
     */
    @Given("User is already in PastaShop home page")
    public void userIsAlreadyLoggedIn() {
        PastaShopUser();
        PastaShopUser.enterLoginInfo("einavcohen124@gmail.com", "Einav0907");
    }

    /**
     * Cucumber step: Adds a product to cart twice.
     * Executes double add-to-cart operation for testing.
     */
    @When("User adds a product to cart Twice")
    public void userAddAProductToCart() {
        PastaShopUser.addProductToCartTwice("ProductName");
    }

    /**
     * Cucumber step: Verifies cart contains expected number of products.
     *
     * @param quantity Expected number of products in cart
     */
    @Then("the cart contains {int} identical products")
    public void theCartContainsProducts(int quantity) {
        PastaShopUser.verifyProductInCart(quantity);
    }

    /**
     * Cucumber step: Verifies admin is logged into system.
     * Initializes admin session for database operations.
     */
    @Given("Admin is already logged in to the system")
    public void adminIsAlreadyLoggedIn() {
        PastaShopAdmin();
        //PastaShopManager.loginToPhpMyAdmin("root", "");
    }

    /**
     * Cucumber step: Updates product quantity through admin interface.
     *
     * @param quantity New quantity to set for product
     */
    @When("Admin updates the product quantity to {int}")
    public void adminUpdatesProductQuantity(int quantity) {
        PastaShopManager.updateQuantityToOne();
    }

    /**
     * Cucumber step: Verifies product quantity update in cart.
     *
     * @param quantity Expected quantity after update
     */
    @Then("the product quantity in the cart is updated to {int}")
    public void verifyProductQuantityInCart(int quantity) {
        PrestaShopAdmin.verifyQuantity(quantity);
    }

    /**
     * Cucumber step: Additional verification for two identical products.
     * Checks quantity specifically equals 2 in admin interface.
     */
    @And("the cart contains 2 identical products on the admin page")
    public void verifyCartContainsTwoIdenticalProductsAgain() {
        PrestaShopAdmin.verifyQuantity(2);
    }
}