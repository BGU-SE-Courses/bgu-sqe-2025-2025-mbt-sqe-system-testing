package hellocucumber;


import io.cucumber.java.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GroupSubmission {
    private WebDriver driver;
    private WebDriverWait wait;
    private MoodleChangeSubmissionType changeSubmissionType;

    public void initSessionAsUser(String webDriver, String path) {
        System.setProperty(webDriver, path);
        
        this.driver = new ChromeDriver();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // launch website -> localhost
        driver.get("http://localhost/");
        // maximize the window - some web apps look different in different sizes
        //driver.manage().window().setPosition(new Point(700, 5));
    }

    public void goToCourse(String courseName) {
        // Navigate to the course
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + courseName + "']"))).click();
    }

    public void goToAssignment(String assignmentName) {
        // Navigate to the assignment
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + assignmentName + "']"))).click();
    }

    public void uploadFile(String filePath) {
        // Locate and upload the file
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file']")));
        fileInput.sendKeys(filePath);
    }

    public void submitAssignment() {
        // Locate and click the submit button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='id_submitbutton']"))).click();
    }

    public void confirmSubmissionSuccess() {
        // Validate submission success message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-success')]")));
        assert successMessage.getText().contains("success");
    }

    public void confirmGroupSubmissionVisibility(String groupName) {
        // Validate submission visibility for all group members
        WebElement groupMemberList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'group-members')]")));
        assert groupMemberList.getText().contains(groupName);
    }

    public void goToLogin() {
        driver.findElement(By.xpath("//*[@id='usernavigation']/div/div/span/a")).click();
    }
    
    public void enterLoginInfo(String username, String password) {
        // locate the username input box and enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(username);
        // locate the password input box and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/input[1]"))).sendKeys(password);
        // locate Log in button and press
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginbtn']"))).click();
        wait.until(ExpectedConditions.titleContains("Dashboard"));
    }
}
