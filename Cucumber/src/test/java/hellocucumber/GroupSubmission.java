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

    public void goToAssignment(String assignmentName) {
        // Navigate to the assignment
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/section/div/aside/section[1]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[2]/div/div[4]/div[2]/div[1]/div[1]/div[2]/div/h6/a"))).click();
    }

    public void addSubmission(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div/div/form/button"))).click();
    }

    public void writeText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        try {
            // Wait for the iframe and switch to it
            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(iframeElement);
            System.out.println("Switched to iframe successfully.");
        } catch (TimeoutException e) {
            System.out.println("ERROR: Iframe not found within the timeout period.");
            return;
        }

        try {
            // Wait for the text area
            WebElement textArea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tinymce\"]")));
            System.out.println("Text area found.");

            // Clear existing text
            textArea.clear();
            System.out.println("Cleared text area.");

            // Try sending text
            textArea.sendKeys(text);
            System.out.println("Text entered successfully: " + text);

            // Verify text input (optional)
//            String enteredText = textArea.getAttribute("value");
//            if (!enteredText.equals(text)) {
//                System.out.println("WARNING: Text input mismatch. Expected: " + text + " | Actual: " + enteredText);
//            }

        } catch (TimeoutException e) {
            System.out.println("ERROR: Text area not found or not interactable.");
            driver.switchTo().defaultContent();
            return;
        }

        // Switch back to the main page
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main content.");
    }



    public void submitAssignment() {
        // Locate and click the submit button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div/form/div[2]/div[2]/div[1]/div/div[1]/span/input"))).click();
    }

    public void confirmSubmissionSuccess() {
        // Validate submission success message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/section/div[2]/div[2]/div/div/table/tbody/tr[2]/td")));
        assert successMessage.getText().contains("Submitted");
    }

//    public void confirmGroupSubmissionVisibility(String groupName) {
//        // Validate submission visibility for all group members
//        WebElement groupMemberList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'group-members')]")));
//        assert groupMemberList.getText().contains(groupName);
//    }

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
