package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.*;

public class StepDefinitions {

    AddComment actuator = new AddComment();

    @Given("A product {string} exists in the store")
    public void productExistsInStore(String productName) {
        actuator.Init();
        actuator.VerifyProductExists(productName);
    }

    @Given("The user {string} is logged in with the password {string}")
    public void userLogsIn(String username, String password) {
        actuator.NavigateToLogin();
        actuator.Login(username, password);
        actuator.VerifyLogin();
    }

    @When("The user navigates to the product {string} page")
    public void userNavigatesToProductPage(String productName) {
        actuator.NavigateToProduct(productName);
    }

    @When("The user writes a comment {string}")
    public void userWritesComment(String comment) {
        actuator.WriteComment(comment);
    }

    @Then("The comment {string} is visible under the product {string}")
    public void verifyCommentIsVisible(String comment, String productName) {
        actuator.VerifyCommentVisible(productName, comment);
    }

    @Given("A product {string} exists in the store with a comment {string}")
    public void productExistsWithComment(String productName, String comment) {
        actuator.VerifyProductExists(productName);
        actuator.VerifyCommentVisible(productName, comment);
    }

    @Given("The admin is logged in with username {string} and password {string}")
    public void adminLogsIn(String username, String password) {
        actuator.NavigateToAdminLogin();
        actuator.AdminLogin(username, password);
    }

    @When("The admin deletes the product {string}")
    public void adminDeletesProduct(String productName) {
        actuator.DeleteProduct(productName);
    }

    @When("The user logs in with username {string} and password {string}")
    public void userLogsInAgain(String username, String password) {
        actuator.NavigateToLogin();
        actuator.Login(username, password);
        actuator.VerifyLogin();
    }

    @Then("The product {string} and the comment {string} are no longer visible")
    public void verifyProductAndCommentNotVisible(String productName, String comment) {
        actuator.VerifyProductDeleted(productName);
        actuator.VerifyCommentNotVisible(productName, comment);
        actuator.Close();
    }
}
