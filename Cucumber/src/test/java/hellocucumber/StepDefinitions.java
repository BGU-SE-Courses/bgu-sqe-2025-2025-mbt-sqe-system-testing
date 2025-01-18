package hellocucumber;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {

    private static WebDriver driver;
    private static WebDriverWait wait;

    // $$*TODO* explain what this step does$$
    @Given("Student is on Home page")
    public void studentIsOnHomePage() {
        driver = new SafariDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("http://localhost:8888/moodle405/");
    }

    @And("Student is logged in with {string} and {string}")
    public void studentIsLoggedIn(String username, String password){
        WebElement loginElement = driver.findElement(By.xpath("//*[@id=\"usernavigation\"]/div/div/span/a"));
        loginElement.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/form[1]/div[1]/input[1]"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/input[1]"))).sendKeys(password);
        driver.findElement(By.xpath("//form[1]/div[3]/button[1]")).click();
    }

    @And("Studnt has a course")
    public void studentHasACourse(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement courseElement = driver.findElement(By.xpath("//div[1]/div[1]/h3[1]/a[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", courseElement);
        courseElement.click();
    }

    @And("Course has a forum discussion")
    public void CourseHasAForum(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")).click();
    }

    // $$*TODO* explain what this step does$$
    @When("Student subscribes to a forum discussion")
    public void studentSubscribesToADiscussion() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//td[5]/div[1]")).click();
    }

    // $$*TODO* explain what this step does$$
    @Then("The student succcessfully subscribed to the discussion")
    public void theScenarioPasses() {
        driver.findElement(By.xpath("//td[5]/div[1]"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
