package hellocucumber;

import io.cucumber.java.en.*;

public class StepDefinitions {

    //Scenario Outline: A user writes a comment on a product

    AddComment comment_actuator = new AddComment();
    DeleteProduct product_actuator = new DeleteProduct();

    @Given("A product {string} exists in the store")
    public void productExistsInStore(String productName) {
        comment_actuator.Init();
        comment_actuator.VerifyProductExists(productName);
    }

    @Given("The user {string} is logged in with the password {string}")
    public void userLogsIn(String username, String password) {
        comment_actuator.NavigateToLogin();
        comment_actuator.Login(username, password);
        comment_actuator.VerifyLogin();
    }

    @When("The user navigates to the product {string} page")
    public void userNavigatesToProductPage(String productName) {
        comment_actuator.NavigateToProduct(productName);
    }
    @When("The user writes a comment with title {string} and body {string}")
    public void userWritesComment(String title, String body) throws InterruptedException {
        comment_actuator.WriteComment(title, body);
    }

    @Then("The comment with title {string} and body {string} is visible under the product {string}")
    public void verifyCommentIsVisible(String title, String body, String productName) {
        comment_actuator.VerifyCommentVisible(productName, title, body);
    }

    @Given("A product {string} exists in the store with a comment with title {string} and body {string}")
    public void productExistsWithComment(String productName, String title, String body) {
        comment_actuator.VerifyProductExists(productName);
        comment_actuator.VerifyCommentVisible(productName, title, body);
    }


    @Given("The admin is logged in with username {string} and password {string}")
    public void adminLogsIn(String username, String password) {
        comment_actuator.NavigateToAdminLogin();
        comment_actuator.AdminLogin(username, password);
    }

    @When("The admin deletes the product {string}")
    public void adminDeletesProduct(String productName) {
        comment_actuator.DeleteProduct(productName);
    }

    @When("The user logs in with username {string} and password {string}")
    public void userLogsInAgain(String username, String password) {
        comment_actuator.NavigateToLogin();
        comment_actuator.Login(username, password);
        comment_actuator.VerifyLogin();
    }

    @Then("The product {string} and the comment with title {string} and body {string} are no longer visible")
    public void verifyProductAndCommentNotVisible(String productName, String title, String body) {
        comment_actuator.VerifyProductDeleted(productName);
        comment_actuator.VerifyCommentNotVisible(productName, title, body);
        comment_actuator.Close();
    }


    //Scenario: Admin deletes a product

    @Given("The admin {string} is logged into the PrestaShop admin panel with the password {string}")
    public void adminLogin(String admin_username, String admin_password) {
        product_actuator.Init();
        //product_actuator.NavigateToLogin();
        product_actuator.Login(admin_username, admin_password);
        //product_actuator.VerifyLogin();
    }

}
