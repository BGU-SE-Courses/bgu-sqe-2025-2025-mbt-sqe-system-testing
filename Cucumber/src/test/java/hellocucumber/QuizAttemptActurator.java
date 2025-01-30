package hellocucumber;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class QuizAttemptActurator {

    private WebDriver driver;
    private WebDriverWait wait;

    public void initSessionAsUser(String webDriver, String  path){

        System.setProperty(webDriver,path);

        this.driver = new ChromeDriver();
        
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("http://localhost:8888/moodle405/");
        driver.manage().window().setPosition(new Point(700, 5));

        System.out.println("Init Finished");
    }

    public void logIn(String Username, String password){
        // navigate to log in
        driver.findElement(By.linkText("Log in")).click();

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='username']")));
        usernameField.clear();
        usernameField.sendKeys(Username);
    
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement passwordField = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password']")));
        passwordField.click(); 
        passwordField.sendKeys(password);
                    
        driver.findElement(By.id("loginbtn")).click();
        }


    public void navigateToCourse(String courseName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='frontpage-available-course-list']")));

        // Use JavaScript to scroll down to the 'Available Courses' section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='frontpage-available-course-list']")));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='courses frontpage-course-list-all']")));

        WebElement courseLink = driver.findElement(By.xpath("//a[contains(@class, 'aalink') and contains(text(), '" + courseName + "')]"));
        System.out.println("amit2"+courseLink);
        courseLink.click();
    }

    public void selectQuiz(String quizName){
        String xpathExpression = "//a[contains(@href, 'mod/quiz') and .//span[contains(text(), '" + quizName + "')]]";
        // use the constructed XPath to find the element and click
        WebElement quizLink = driver.findElement(By.xpath(xpathExpression));
        quizLink.click();
    }

    public void startQuiz(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"region-main\"]/div[2]/div[1]/div/div/form"))).click();
        
        // Wait for the 'Start attempt' button using multiple attributes
        WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@name='submitbutton']"))
        );
        startButton.click();
    }
 
    public void answerQuiz(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@type='radio']")
        ));
        
        // Click on the radio button
        radioButton.click();
    }

    public void finishQuiz() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("mod_quiz-next-nav")));  
        submitButton.click();

        WebElement submitAllButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@type='submit' and contains(@class, 'btn') and contains(@class, 'btn-primary')]")
        ));
        submitAllButton.click();
        WebElement finish = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[@type='button' and contains(@class, 'btn') and contains(@class, 'btn-primary') and @data-action='save']")));
        finish.click();
    }
    
    public void markedFinished(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the status cell in the summary table
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//table[contains(@class, 'generaltable')]//tr[th[text()='Status']]/td")
        ));
    
        String statusText = statusElement.getText().trim();
    
        // Assertion: Check if the status is "Finished"
        Assertions.assertEquals("Finished", statusText, "Quiz status is not 'Finished'");    

    }

    public void quizResults(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the grade cell in the summary table
        WebElement gradeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//table[contains(@class, 'generaltable')]//tr[th[text()='Grade']]/td")
        ));
        
        String gradeText = gradeElement.getText().trim();
        
        // Ensure that the grade text is not empty
        Assertions.assertFalse(gradeText.isEmpty(), "Grade is missing in the quiz summary");        
    }

    public void verifyQuizIsAvailable(String quizName) {
        // Construct the XPath expression to locate the quiz
        String xpathExpression = "//a[contains(@href, 'mod/quiz') and .//span[contains(text(), '" + quizName + "')]]";
        
        try {
            // Try to find the quiz element using the XPath
            WebElement quizLink = driver.findElement(By.xpath(xpathExpression));
            
            // Assert that the quiz element is displayed (i.e., it is visible on the page)
            Assertions.assertTrue(quizLink.isDisplayed(), "The quiz '" + quizName + "' is not visible.");
        } catch (NoSuchElementException e) {
            // If the quiz is not found, fail the assertion
            Assertions.fail("The quiz '" + quizName + "' was not found on the page.");
        }
    }

    public void hideQuiz(){
        //change to edit mode
        WebElement editModeLabel = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//label[contains(text(), 'Edit mode')]")
        ));
        editModeLabel.click();
        
        // Wait for the third icon to be visible and click it to open the quiz editing options
        WebElement threeDotsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='action-menu-toggle-2']")));
        threeDotsButton.click();

        // Click on the availability option
        WebElement availabilityOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[@class='menu-action-text' and text()='Availability']")
        ));
        availabilityOption.click();    
                
        // Wait for the "Hide on course page" option to be clickable and click it
        WebElement hideOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Hide on course page")
        ));
        hideOption.click();

    }

    public void verifyQuizIsOnHiddenStatus() {
        // Try to find the "Hidden from students" message indicating quiz is hidden
        boolean isHidden = checkIfQuizIsHidden();
        Assertions.assertTrue(isHidden, "Quiz is not hidden from students.");    
    }
    
    private boolean checkIfQuizIsHidden() {
        try {
            // Locate the div with data-region="visibility" and find the span containing "Availability"
            WebElement visibilityDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[data-region='visibility'] span.sr-only")
            ));
            
            // Check if the "Availability" text is present in the span
            return visibilityDiv.getText().contains("Availability");
        } catch (Exception e) {
            return false;
        }
    }
        
    public void logOut(){
        driver.findElement(By.className("userbutton")).click();
        driver.findElement(By.linkText("Log out")).click();
    }


    public void failedGoToQuiz(String quizName) {
        try {
            // Attempt to verify if the quiz is available
            verifyQuizIsAvailable(quizName);
            // If no exception is thrown, the quiz is accessible (which is incorrect behavior for this method)
            Assertions.fail("Quiz should be inaccessible but was found");
        } catch (Exception e) {
            // Assert that an exception was thrown (indicating the quiz is inaccessible)
            Assertions.assertTrue(true, "Quiz is inaccessible, as expected");
        }
    }

    public void unHideQuiz(String quizName){
        WebElement thirdIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='icon fa fa-ellipsis-v fa-fw '])[4]")));
        thirdIcon.click();

        // Wait for the hide option to be visible
        WebElement item = driver.findElement(By.id("actionmenuactionsubpanel-3"));
        item.click();

        // Click the hide option
        WebElement element = driver.findElement(By.linkText("Show on course page"));
        element.click();
    }

    public void verifyQuizIsClosed() {
        try {
            // Try to locate the 'Start Quiz' button (or any other indicator that the quiz is open)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"region-main\"]/div[2]/div[1]/div/div/form"))).click();            
            // If the button is clickable, it means the quiz is open
            Assertions.fail("Quiz is open, 'Start Quiz' button is clickable.");
        } catch (Exception e) {
            // If we catch an exception (such as NoSuchElementException or TimeoutException), 
            // it means the 'Start Quiz' button is unavailable, indicating the quiz is closed.
            Assertions.assertTrue(true, "Quiz is closed, 'Start Quiz' button is not available.");
        }
    }        

}
