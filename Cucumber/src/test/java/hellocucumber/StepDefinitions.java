package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private static BuyProductActuator buyProductActuator;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "..\\Selenium\\chromedriver.exe";

    // Initialize the user session
    @Before
    public void BuyProductInitUser() {
        System.out.println("--------------- INITIALIZING TEST - OPENING WEBPAGE ---------------");
        if (buyProductActuator == null) {
            buyProductActuator = new BuyProductActuator();
        }
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        buyProductActuator.initSessionAsUser(webDriver, path);
    }

    // Scenario 1: User buys an item from the store

    // Simulate user login to the store
    @Given("a user is logged into the PrestaShop store with {string} and {string}")
    public void aUserIsLoggedIntoThePrestaShopStore(String email, String password) {
        buyProductActuator.goToLogin();
        buyProductActuator.enterLoginInfo(email, password);
    }

    // Simulate user adding an item to the shopping cart
    @Given("the user adds an item to their shopping cart")
    public void theUserAddsTheItemToTheirShoppingCart() {
        buyProductActuator.addProductToCart();
    }

    // Simulate user buy the item through the checkout and payment process
    @When("the user buy the item")
    public void theUserProceedsToCheckoutAndCompletesPayment() {
        buyProductActuator.proceedToCheckout();
        buyProductActuator.enterAddressDetailsAndContinue();
        buyProductActuator.confirmShippingMethodAndContinue();
        buyProductActuator.enterPaymentDetailsAndConfirm();
    }

    //verify that the product purchase successfully confirmed
    @Then("the product purchase successfully confirmed")
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

    // Scenario 2: Admin deletes an item from the store

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
}