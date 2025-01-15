package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {
    private static opencartActuator opencartUser;
    private static opencartActuatorAdmin opencartManager;
    private static List<opencartActuator> allopenCarts;
    private static List<opencartActuatorAdmin> allopenCartsA;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\ass4\\Selenium\\chromedriver.exe";
    public void OpenCartInitUser() {
        System.out.println("--------------- INITIALIZING OPENCART TEST - OPENING WEBPAGE ---------------");
        if(allopenCarts == null){
            allopenCarts = new ArrayList<>();
        }
        opencartUser = new opencartActuator();
        allopenCarts.add(opencartUser);
        opencartUser.initSessionAsUser(webDriver, path);
    }
    public void OpenCartInitAdmin() {
        System.out.println("--------------- INITIALIZING OPENCART TEST - OPENING WEBPAGE ---------------");
        if(allopenCartsA == null){
            allopenCartsA = new ArrayList<>();
        }
        opencartManager = new opencartActuatorAdmin();
        allopenCartsA.add(opencartManager);
        opencartManager.initSessionAsAdmin(webDriver, path);
    }

    // $$*TODO* explain what this step does$$
    @Given("User is on log in page")
    public void userIsOnHomePage() {
        OpenCartInitAdmin();
    }

    // $$*TODO* explain what this step does$$
    @When("Admin is logged in with {string} and {string}")
    public void user_is_logged_in_with_and(String email, String password) {
        opencartManager.enterLoginInfoAdmin(email, password);
    }

    @And("Admin click on marketing button")
    public void AdminClickMarketingButton() {
        opencartManager.clickMarketingButton();
    }

    @And("Admin navigates to Coupon button")
    public void AdminClickCouponButton() {
        opencartManager.clickCouponsButton();
    }

    @And("Admin click on edit button")
    public void AdminClickOnEditCoupon() {
        opencartManager.clickEditCouponsButton();
    }
    @And("Admin scroll down")
    public void AdminScrollDownUntilFindStatus() {
        opencartManager.scrollDownUntilFindStatus();
    }
    @And("Admin click on status button")
    public void AdminClickOnStatusButton() {
        opencartManager.ClickOnStatusButton();
    }

    @And("Admin scroll up")
    public void AdminScrollUpUntilFindSave() {
        opencartManager.scrollUpUntilFindSave();
    }

    @And("Admin click on the save button")
    public void AdminClickOnSaveButton() {
        opencartManager.ClickOnSaveButton();
    }
    // $$*TODO* explain what this step does$$
    @Then("the Coupon is disable")
    public void theScenarioPasses() {
    }

    // Customer Scenario Steps
    @Given("User is on home page")
    public void CustomerIsOnHomePage() {
        OpenCartInitUser();
    }

    @When("User logs in with {string} and {string}")
    public void userLogsInWith(String email, String password) {
        OpenCartInitUser();
        opencartUser.goToLogin();
        opencartUser.enterLoginInfoUser(email, password);
    }

    @And("User clicks on the homepage")
    public void userClicksOnHomepage() {
        opencartUser.clickHomepage();
    }

    @And("User scrolls down to see a product")
    public void userScrollsDownToSeeProduct() {
        opencartUser.scrollDownToProduct();
    }

    @And("User clicks on add to cart for the product")
    public void userClicksAddToCart() {
        opencartUser.addToCart();
    }

    @And("User scrolls up")
    public void userScrollsUp() {
        opencartUser.scrollUp();
    }

    @And("User clicks on shopping cart")
    public void userClicksOnShoppingCart() {
        opencartUser.clickShoppingCart();
    }

    @And("User scrolls down")
    public void userScrollsDown() {
        opencartUser.scrollDown();
    }

    @And("User clicks on use a coupon")
    public void userClicksOnUseCoupon() {
        opencartUser.clickUseCoupon();
    }

    @And("User enters the coupon code {string}")
    public void userEntersCouponCode(String couponCode) {
        opencartUser.enterCouponCode(couponCode);
    }

    @And("User clicks apply coupon")
    public void userClicksApplyCoupon() {
        opencartUser.clickApplyCoupon();
    }

    @Then("The discount is applied to the total price")
    public void discountAppliedToTotal() {
        opencartUser.verifyDiscountAppliedTest();
    }
}

