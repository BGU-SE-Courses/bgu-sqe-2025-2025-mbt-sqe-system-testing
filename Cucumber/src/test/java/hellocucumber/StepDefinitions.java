package hellocucumber;

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
    @When("The user writes a comment with title {string} and body {string}")
    public void userWritesComment(String title, String body) throws InterruptedException {
        actuator.WriteComment(title, body);
    }

    @Then("The comment with title {string} and body {string} is visible under the product {string}")
    public void verifyCommentIsVisible(String title, String body, String productName) {
        actuator.VerifyCommentVisible(productName, title, body);
    }

    @Given("A product {string} exists in the store with a comment with title {string} and body {string}")
    public void productExistsWithComment(String productName, String title, String body) {
        actuator.VerifyProductExists(productName);
        actuator.VerifyCommentVisible(productName, title, body);
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

    @Then("The product {string} and the comment with title {string} and body {string} are no longer visible")
    public void verifyProductAndCommentNotVisible(String productName, String title, String body) {
        actuator.VerifyProductDeleted(productName);
        actuator.VerifyCommentNotVisible(productName, title, body);
        actuator.Close();
    }

}
