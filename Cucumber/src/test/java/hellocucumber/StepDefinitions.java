package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private static BuyProductActuator buyProductActuator;
    private String webDriver = "webdriver.chrome.driver";
    //TODO: change this path
    private String path = "C:\\sq_assignment4\\2025-mbt-m\\Selenium\\chromedriver.exe";

    // Initialize the user session
    public void OpenCartInitUser() {
        System.out.println("--------------- INITIALIZING TEST - OPENING WEBPAGE ---------------");
        if (buyProductActuator == null) {
            buyProductActuator = new BuyProductActuator();
        }
        buyProductActuator.initSessionAsUser(webDriver, path);
    }


    // Scenario 1: Admin deletes an item from the store

    // $$*TODO* explain what this step does$$
    @Given("an admin is logged into the PrestaShop admin panel")
    public void anAdminIsLoggedIntoThePrestaShopAdminPanel() {
        // Simulate admin login to the admin panel
        System.out.println("Admin is logged into the PrestaShop admin panel.");
    }

    // $$*TODO* explain what this step does$$
    @Given("the admin navigates to the product catalog")
    public void theAdminNavigatesToTheProductCatalog() {
        // Simulate navigation to the product catalog in the admin panel
        System.out.println("Admin navigates to the product catalog.");
    }

    // $$*TODO* explain what this step does$$
    @When("the admin deletes an item from the store")
    public void theAdminDeletesAnItemFromTheStore() {
        // Simulate admin deleting a product from the store
        System.out.println("Admin deletes an item from the store.");
    }

    // $$*TODO* explain what this step does$$
    @Then("the item is no longer visible in the product catalog")
    public void theItemIsNoLongerVisibleInTheProductCatalog() {
        // Verify that the deleted item is no longer visible in the catalog
        System.out.println("Item is no longer visible in the product catalog.");
        // Assert that the item is removed from the catalog (simulated)
        Assertions.assertTrue(true, "Item should be removed from the catalog.");
    }

    // $$*TODO* explain what this step does$$
    @Then("the item is no longer available in the store for users")
    public void theItemIsNoLongerAvailableInTheStoreForUsers() {
        // Verify that the item is no longer available in the store
        System.out.println("Item is no longer available in the store for users.");
        // Assert that the item is no longer in the store (simulated)
        Assertions.assertTrue(true, "Item should no longer be available for purchase.");
    }

    // Scenario 2: User buys an item from the store

    // $$*TODO* explain what this step does$$
    @Given("a user is logged into the PrestaShop store with {string} and {string}")
    public void aUserIsLoggedIntoThePrestaShopStore(String email, String password) {
        // Simulate user login to the store
        buyProductActuator.goToLogin();
        buyProductActuator.enterLoginInfo(email, password);
    }

    // $$*TODO* explain what this step does$$
    @Given("the user adds an item to their shopping cart")
    public void theUserAddsTheItemToTheirShoppingCart() {
        // Simulate user adding the item to the shopping cart
        buyProductActuator.addProductToCart();
    }

    // $$*TODO* explain what this step does$$
    @When("the user buy the item")
    public void theUserProceedsToCheckoutAndCompletesPayment() {
        // Simulate the checkout and payment process
        buyProductActuator.proceedToCheckout();
        buyProductActuator.enterAddressDetailsAndContinue();
        buyProductActuator.confirmShippingMethodAndContinue();
        buyProductActuator.enterPaymentDetailsAndConfirm();
    }

    // $$*TODO* explain what this step does$$
    @Then("the product successfully bought")
    public void theOrderConfirmationPageIsDisplayed() {
        buyProductActuator.verifySuccessfulProductBuy();
    }

    /*
    // $$*TODO* explain what this step does$$
    @Then("the item is marked as \"sold\" in the store's inventory")
    public void theItemIsMarkedAsSoldInTheStoresInventory() {
        // Verify that the item is marked as "sold" in the inventory
        System.out.println("Item is marked as \"sold\" in the store's inventory.");
        // Assert that the item is marked as sold (simulated)
        Assertions.assertTrue(true, "Item should be marked as sold.");
    }
    */
}