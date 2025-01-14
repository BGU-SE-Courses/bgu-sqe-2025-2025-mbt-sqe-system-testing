package hellocucumber;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;

public class StepDefinitions {

    //private static final String CHROME_DRIVER_PATH = "../../../Selenium/chromedriver.exe";
    private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/../Selenium/chromedriver.exe";
    private WebDriver driver;
    private WebDriverWait wait;


    @Given("The user is logged in with {string} and {string}")
    public void userLogsIn(String username, String password) throws InterruptedException {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        // Navigate to Moodle homepage
        driver.get("http://localhost:8080");
        // Click the login button on the homepage
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://localhost:8080/login/index.php']"))).click();

        // Enter username
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        usernameField.clear();
        try {
            usernameField.sendKeys(username);
        } catch (StaleElementReferenceException e) {
            usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
            usernameField.sendKeys(username);
        }

        // Enter password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        passwordField.clear();
        try {
            passwordField.sendKeys(password);
        } catch (StaleElementReferenceException e) {
            passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
            passwordField.sendKeys(password);
        }

        // Click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']")));
        try {
            loginButton.click();
        } catch (StaleElementReferenceException e) {
            loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']")));
            loginButton.click();
        }
    }

    @Given("The student is enrolled in the course {string}")
    public void theStudentIsEnrolledInTheCourse(String courseName) throws InterruptedException {
        // Click on the "My courses" button using XPath
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-disableactive='true'])[3]"))).click();
        WebElement courseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[3]/span[2]")
        ));
        Assertions.assertTrue(
                courseElement.isDisplayed(),
                "Student is not enrolled in the course."
        );
        courseElement.click();
    }

    @When("The student searches for the comment {string} in the forum")
    public void theStudentSearchesForTheCommentInTheForum(String commentText) {
        // Click the "Announcements" button
        WebElement announcementsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")));
        announcementsButton.click();

        // Find the search input and type the comment text
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[1]/div[1]/input[1]")));
        searchInput.sendKeys(commentText);

        // Press ENTER to perform the search
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("The comment {string} should appear in the search results")
    public void theCommentShouldAppearInTheSearchResults(String commentText) {
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[1]/a[2]/span[1]"))); //***************************************************************
        Assertions.assertNotNull(searchResult, "Comment not found in the search results.");
        Assertions.assertTrue(searchResult.getText().contains(commentText), "Expected comment text not found in the search result.");
    }

    @Then("The student can navigate to the comment")
    public void theStudentCanNavigateToTheComment() {
        // Wait for the button or link to navigate to the comment to appear
        WebElement navigateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[3]/a[1]")));

        // Click the button to navigate to the comment
        navigateButton.click();

        // Verify that the navigation was successful by checking the URL
        Assertions.assertTrue(driver.getCurrentUrl().contains("forum"), "Failed to navigate to the comment.");
    }


    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    @Given("The teacher has posted the comment {string} in the course {string}")
    public void theTeacherHasPostedTheCommentInTheCourse(String commentText, String courseName) {
        // Navigate to "My courses" and select the course
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-disableactive='true'])[3]"))).click();
        WebElement courseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[3]/span[2]")
        ));
        Assertions.assertTrue(
                courseElement.isDisplayed(),
                "Course not found in 'My courses'."
        );
        courseElement.click();

        // Navigate to the Forum
        WebElement announcementsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")));
        announcementsButton.click();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[1]/div[1]/input[1]")));
        searchInput.sendKeys(commentText);
        searchInput.sendKeys(Keys.ENTER);
        WebElement commentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[1]/a[2]/span[1]"))); //***************************************************************
        Assertions.assertTrue(commentLink.getText().contains(commentText), "Comment not found in the search results.");
        commentLink.click();
    }


    @When("The teacher deletes their comment")
    public void theTeacherDeletesTheirComment() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div[2]/div[2]/div[1]/a[3]")));
        deleteButton.click();
        // Wait for the confirmation button to appear and click it
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/form[1]/button[1]")));
        confirmButton.click();
    }

    @Then("The comment {string} should no longer appear in the forum")
    public void theCommentShouldNoLongerAppearInTheForum(String commentText) {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            driver.findElement(By.xpath("//*[contains(text(), '" + commentText + "')]"));
        }, "Comment is still visible in the forum.");

        restoreComment(commentText);
    }

    // Helper function to restore the deleted comment
    private void restoreComment( String commentText) {
        // Navigate to the course
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-disableactive='true'])[3]"))).click();
        WebElement courseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[3]/span[2]")
        ));
        Assertions.assertTrue(
                courseElement.isDisplayed(),
                "Course not found in 'My courses'."
        );
        courseElement.click();

        // Navigate to the Forum
        WebElement announcementsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")));
        announcementsButton.click();

        WebElement post1Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div[1]/div[2]/a[1]")));
        post1Button.click();

        // Add the comment back
        WebElement subjectField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/input[1]")));
        subjectField.clear();
        try {
            subjectField.sendKeys(commentText);
        } catch (StaleElementReferenceException e) {
            subjectField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/input[1]")));
            subjectField.sendKeys(commentText);
        }


        // Locate and switch to the iframe
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_message_ifr")));
        driver.switchTo().frame(iframe);

        // Locate the body inside the iframe and type the message
        WebElement editorBody = driver.findElement(By.id("tinymce"));
        editorBody.clear(); // Clear any existing text
        editorBody.sendKeys("This is the message content."); // Replace with your message

        // Switch back to the main content
        driver.switchTo().defaultContent();


        // Click the post button
        WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/span[1]/input[1]")));
        try {
            postButton.click();
        } catch (StaleElementReferenceException e) {
            postButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/span[1]/input[1]")));
            postButton.click();
        }
    }


}
