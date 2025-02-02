package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private String CHROME_DRIVER_PATH ="C:\\Users\\yuval\\IdeaProjects\\2025-mbt-j\\Selenium\\chromedriver.exe";
    private ChromeDriver driver;
    private WebDriverWait wait;
    private final String BASE_ADDRESS = "http://localhost:8080/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15); //
    }


    @Given("User is not logged in and on homepage")
    public void navigateToLoginPage() throws InterruptedException{
        // Navigate to PrestaShop website
        driver.get(BASE_ADDRESS);
        // Click on Sign in
        WebElement signInElement = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a/span[1]"));
        signInElement.click();
        Thread.sleep(1000);
    }

    @When("User fills in login details {string} and {string}")
    public void login(String email, String password) throws InterruptedException{
        WebElement emailElement = driver.findElement(By.xpath("//*[@id='login-form']/div/div/div/input[1]"));
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id='login-form']/div[1]/div[2]/div[1]/div[1]/input[1]"));
        passwordElement.sendKeys(password);
        Thread.sleep(1000);
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='login-form']/footer[1]/button[1]"));
        signInButton.click();
    }

    @And("User is logged in and on homepage")
    public void navigateToUserInformation() throws InterruptedException {
        // Navigate to user information
        WebElement userInformationElement = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a/span[1]"));
        userInformationElement.click();
        Thread.sleep(1000);

    }
    @And("User is on user information")
    public void navigateToInformation() throws InterruptedException {
        // Navigate to user information
        WebElement userInformationElement = driver.findElement(By.xpath("//*[@id='identity-link']/span/i[1]"));
        userInformationElement.click();
        Thread.sleep(1000);

    }

    @And("User changes his first name to {string} with password {string}")
    public void changeFirstName(String newFirstName, String password) throws InterruptedException {
        // Change first name
        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id='field-firstname']"));
        firstNameElement.click();
        firstNameElement.clear();
        firstNameElement.sendKeys(newFirstName);
        Thread.sleep(1000);
        // Insert password
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id='customer-form']/div[1]/div[5]/div[1]/div[1]/div[1]/input[1]"));
        passwordElement.sendKeys(password);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // Check data privacy
        WebElement dataPrivacyCheck = driver.findElement(By.xpath("//*[@id='customer-form']/div[1]/div[9]/div[1]/span[1]/label[1]/input[1]"));
        dataPrivacyCheck.click();
        Thread.sleep(1000);
        // Check terms and conditions
        WebElement termsAndConditionsCheck = driver.findElement(By.xpath("//*[@id='customer-form']/div[1]/div[11]/div[1]/span[1]/label[1]/input[1]"));
        termsAndConditionsCheck.click();
        Thread.sleep(1000);
        // Click save
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='customer-form']/footer[1]/button[1]"));
        saveButton.click();
    }

    @Then("user scenario passes")
    public void userScenarioPasses() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        WebElement changeNameMSG = driver.findElement(By.xpath("//*[@id='notifications']/div[1]/article[1]/ul[1]/li[1]"));
        assertEquals("Information successfully updated.", changeNameMSG.getText());
        driver.quit();
    }

    @Given("the Admin enters the login page")
    public void EnterLoginPage() {
        //opening the login page for the admin
        try {
            String BASE_ADDRESS = "http://localhost:8080/admina";
            driver.get(BASE_ADDRESS);
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            driver.quit();
            throw e;
        }



    }

    @When("the Admin logs in with {string} and {string}")
    public void adminLoginWithEmailAndPassword(String email, String password) throws InterruptedException {
        String emailXpath = "//*[@id='email']";
        String passwordXpath = "//*[@id='passwd']";
        String submitButtonXpath = "//*[@id='submit_login']";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailXpath))).sendKeys(email);
            Thread.sleep(500);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordXpath))).sendKeys(password);
            Thread.sleep(500);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submitButtonXpath))).click();
            Thread.sleep(2000);
        } catch (AssertionError | InterruptedException e) {
            System.out.println(e.getMessage());
            driver.quit();
            throw e;
        }


    }

    // $$*TODO* explain what this step does$$
    @And("navigates to the customers page")
    public void navigatesToCustomerPage() throws InterruptedException {
        String customerPageXpath = "//section[5]/ul[1]/li[1]/span[1]/a[1]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerPageXpath))).click();
        Thread.sleep(2000);
    }

    @And("deactivates the user with email {string}")
    public void deactivatesTheUserWithEmail(String email) throws InterruptedException {
        String email_search_field="//*[@id='customer_email']";
        String Button_search_field="//td[14]/button[1]";
        String disableCustomerCheckboxXpath = "//*[@id='input-false-admin_customers_toggle_status-3']";
        try{
            //look for Tommy's email
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(email_search_field))).clear();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(email_search_field))).sendKeys(email);
            Thread.sleep(1000);
            //find the search button and click it
            WebElement searchButton = driver.findElement(By.xpath(Button_search_field));
            searchButton.getLocation();
            Thread.sleep(1500);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Button_search_field))).click();
            Thread.sleep(1500);

            WebElement toggleOff = driver.findElement(By.xpath(disableCustomerCheckboxXpath));

            // Check if user is activated
            toggleOff.click();
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[3]")));
            // Check if user was deactivated successfully

        } catch (AssertionError | InterruptedException e) {
            System.out.println(e.getMessage());
            driver.quit();
            throw e;
        }}

    @Then("the user should be successfully deactivated")
    public void DeactivationHappened() {
        driver.quit();
    }

}